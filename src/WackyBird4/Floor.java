package WackyBird4;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

public class Floor {
	private static Color Floor = null;
	
	public void render(Graphics g) throws IOException {
		
		if(BackDrop.getLevel() == 1) {
			Floor = Color.green;
		}else if(BackDrop.getLevel() == 2) {
			Floor = Color.pink;
		}else {
			Floor = Color.white;
		}
		g.setColor(Floor);
		g.fillRect(0, GameCore.HEIGHT - 2, GameCore.WIDTH, 20);
	}
}
