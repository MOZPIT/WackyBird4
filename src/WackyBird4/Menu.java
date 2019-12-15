package WackyBird4;
import java.awt.*;
import java.io.IOException;

public class Menu{

    public void render(Graphics g) throws IOException {
        Font font0 = new Font("arial", Font.BOLD, 50);
        g.setFont(font0);

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, GameCore.WIDTH, GameCore.HEIGHT);
        g.drawImage(Bird.getBird(), GameCore.WIDTH / 3 - 150, 150, null);

        g.setColor(Color.white);
        g.drawString("WACKY BIRD", GameCore.WIDTH / 3, 100);

        g.setColor(Color.black);
        g.setFont(new Font("Helvetica", Font.BOLD, 20));
        
        if(GameCore.state == GameCore.STATE.MENU) {
        	g.drawString("Press S to start!", GameCore.WIDTH / 2 - 80, GameCore.HEIGHT / 2);
        }
        else if(GameCore.state == GameCore.STATE.OVER) {
        	g.drawString("GAME OVER", GameCore.WIDTH / 2 - 80, GameCore.HEIGHT / 2);
        	g.drawString("Press R to start!", GameCore.WIDTH / 2 - 80, GameCore.HEIGHT / 2 - 30);
        }
    }
}
