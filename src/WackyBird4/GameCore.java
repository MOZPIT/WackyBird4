package WackyBird4;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Renderer;

public class GameCore extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 960, HEIGHT = 800;
	private Thread thread;

	//set game state
	public static enum STATE{
		GAME,
		OVER,
		MENU
	};
	public static STATE state = STATE.MENU;

	private Menu menu = new Menu();
	private boolean started = false;
	private static boolean gameOver = true;
	public static double score = 0;
	public static int keyTouched;
	
	public static Pipe pipe;
	public Bird bird;
	public BackDrop backdrop;
	public Score playerScore;
	public Floor gameFloor;
	
	//Constructor
	public GameCore() {
		Dimension d = new Dimension(GameCore.WIDTH, GameCore.HEIGHT);
		Camera.setLocation(100, 0);
		
		requestFocus();
		setPreferredSize(d);
		this.addKeyListener(new InputManager());
		this.setIgnoreRepaint(true);
		
		pipe = new Pipe(60);
		bird = new Bird(20,GameCore.HEIGHT/2,pipe.pipes);
		playerScore = new Score();
		gameFloor = new Floor();
	}
	
	public synchronized void start() {		
		if(started && state == STATE.GAME) return;
			started = true;
			thread = new Thread(this);
			thread.start();
	}
	
	public synchronized void stop() {
		if(!started  && state == STATE.MENU) return;
		started = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		GameCore game = new GameCore();
		jFrame.add(game);
		
		//jFrame.setResizable(false);
		jFrame.pack();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setTitle("Wacky Bird");
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		jFrame.setFocusable(true);

	
		Object Sound;
		Sound = new Sound();
		((Sound) Sound).playBackgroundMusic();
		
		game.createBufferStrategy(2);
		
		game.start();

	}

	@Override
	public void run() {
		int fps = 0;
		long lastUpdated = System.nanoTime();
		double timer = System.currentTimeMillis();
		double delta = 0;
		double nanosecs = 1000000000 / 60;
		
		/* game loop */
		while(started) {
			long now = System.nanoTime();
			delta += (now - lastUpdated) / nanosecs;
			lastUpdated = now;
			
			while(delta >= 1) {
				update();
				try {
					render();
				} catch (IOException e) {
					e.printStackTrace();
				}
				fps++;
				delta--;
				
			}
			
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + fps);
				System.out.println("isGameOver: " + gameOver);
				System.out.println("Game State: " + state);
				System.out.println("KeyTouched: " + keyTouched);
			}
			
			if(score <= 2) {
				backdrop = new BackDrop(1);
			}else if(score <= 3){
				backdrop = new BackDrop(2);
			}else{
				backdrop = new BackDrop(3);
			}
			
		}
		
		stop();
		
	}
	
	private void update() {
		if(state == STATE.GAME){
			backdrop.update();
			pipe.update();
			bird.update();
		}
		else if(state == STATE.MENU){
			//do somethin
		}

	}

	private void render() throws IOException {
		BufferStrategy buf = this.getBufferStrategy();
		if(buf == null) {
			createBufferStrategy(2);
			return;
		}
		
		Graphics g = buf.getDrawGraphics();

		if(state == STATE.GAME){
			start();
			backdrop.render(g);
			pipe.render(g);
			bird.render(g);
			playerScore.render(g);
			gameFloor.render(g);
		}else{
			menu.render(g);
		}

		g.dispose();
		buf.show();
		
	}

	public static boolean isGameOver(boolean gameStatus) {
		return gameOver = gameStatus;
	}
	
	@Override
	public void paint(Graphics g) {}
	
}
