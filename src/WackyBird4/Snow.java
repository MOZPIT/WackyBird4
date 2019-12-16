package WackyBird4;

import java.awt.Color;
import java.awt.Graphics;

public class Snow {
	private int size;
	private int rotation;
	private int windSpeed;
	private int speed;
	private float gravity = 0.1f;
	private int x = 0;
	private int y = 0;
	private int weight;
	
	public Snow(int s, int w, int ws) {
		this.size = s;
		this.weight = w;
		this.windSpeed = ws;
	}
	
	public void update() {
		if(x <= GameCore.WIDTH - 35) {
			x += (int)(Math.random() * windSpeed);
		}else {
//			x = (int)Math.random();
			x = 0;
		}
		
		if(y >= GameCore.HEIGHT - 35) {
//			y = (int)Math.random();
			y = 0;
		}else {
			y += windSpeed;
		}
		
		
		if(windSpeed > 8) {
			windSpeed = 8;
		}else {
			windSpeed += gravity;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
	
		for(int i = 1; i < 10; i++) {
			g.drawOval(x*i, y*i, size, size);
		}
	}
}
