package WackyBird4;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class BackDrop {
	private String filename;
//	private String trees;
	
	public BufferedImage backdrop = null;
	public BufferedImage trees = null;
	
	public ImageLayer levelBackground;
	private static int level;
	private int dx;
	
//	ImageLayer trees = new ImageLayer("images/dawntree.png", 0, GameCore.HEIGHT+100, 1);
	
	/* Constructor */
	public BackDrop(int level) {
		this.level = level;
	}
	
	public void update() {
		if(level == 1) {
			filename = "images/airadventurelevel2.png";
		}else if(level == 2) {
			filename = "images/airadventurelevel3.png";
		}else if(level == 3) {
			filename = "images/airadventurelevel4.png";
		}
		
//		treesFile = "images/dawntree.png";
		
		
		
//		dx = Bird.getBirdX();
		dx = 0;
//		if(level == 1) {
//			levelBackground = level1BackGround;
//		}else if(level == 2) {
//			levelBackground = level2BackGround;
//		}else if(level == 3) {
//			levelBackground = level3BackGround;
//		}
	}
	
	

	public void render(Graphics g) {
		if(backdrop != null) {
				for(int i = 0; i < 50; i++) {
		        	g.drawImage(backdrop, ((int) ((dx + (GameCore.WIDTH * .01)) - Camera.x/100)), -100, null);	
				    g.drawImage(trees, ((int) ((dx + (GameCore.WIDTH * 0.6)) - Camera.x/10)), GameCore.HEIGHT-120, null);	
				}
		}else {
			try {
			    try {       
					backdrop = ImageIO.read(new File(getClass().getResource(filename).toURI()));
					trees = ImageIO.read(new File(getClass().getResource("images/dawntree.png").toURI()));
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
		
//		trees.draw(g);
	}	
//	public void render(Graphics g) {
//		level1BackGround.draw(g);
//		trees.draw(g);
//	 } 
	
	public static int getLevel() {
		return level;
	}
  }