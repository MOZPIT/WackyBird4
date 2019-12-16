package WackyBird4;

import java.awt.Graphics;

public class Trees {
	ImageLayer trees = new ImageLayer("images/houses.png", 0, GameCore.HEIGHT-45, 50);
	
	public void render(Graphics g) {
		trees.draw(g);	
	}
}
