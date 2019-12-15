package WackyBird4;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class gameNotifications {
	private String notification;
	private boolean gameOver;
	
	public gameNotifications(String notification) {
		this.notification = notification;
	}
	public void update() {
		if(notification == "Game Over") {
			gameOver = true;
		}
	}
	
	public void render(Graphics g) {
		if(gameOver == true) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Verdana",Font.BOLD, 100));
			g.drawString("Game Over!", GameCore.WIDTH/2, GameCore.HEIGHT/2);
		}else {
			g.drawString("Oops", GameCore.WIDTH/2, GameCore.HEIGHT/2);
		}
	}
}
