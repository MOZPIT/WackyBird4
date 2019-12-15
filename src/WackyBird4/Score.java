package WackyBird4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

public class Score {

	
	public void render(Graphics g) throws IOException {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana",Font.BOLD, 21));
		g.drawString("Score: "+ (int)GameCore.score, 10, 20);
	}
}
