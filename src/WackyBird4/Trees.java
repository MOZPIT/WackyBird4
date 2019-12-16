package WackyBird4;

import java.awt.Graphics;

public class Trees {
	ImageLayer trees = new ImageLayer("images/dawntree.png", 0, 0, 50);
	
	public void render(Graphics g) {
		trees.draw(g);	
	}
}
