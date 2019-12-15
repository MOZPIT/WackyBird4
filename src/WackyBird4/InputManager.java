package WackyBird4;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
    The InputManager manages input of key and mouse events.
    Events are mapped to GameActions.
*/
public class InputManager implements KeyListener
{
	public static final int UP = KeyEvent.VK_UP;
	public static final int DN = KeyEvent.VK_DOWN;
	public static final int LT = KeyEvent.VK_LEFT;
	public static final int RT = KeyEvent.VK_RIGHT;

	public static final int _R = KeyEvent.VK_R;
	public static final int _S = KeyEvent.VK_S;
	public static final int _Q = KeyEvent.VK_Q;
	
	public static final int _1 = KeyEvent.VK_1;
	public static final int _2 = KeyEvent.VK_2;
	public static final int _3 = KeyEvent.VK_3;
	public static final int _4 = KeyEvent.VK_4;
	
	public void keyPressed(KeyEvent e) {
		if(GameCore.state == GameCore.STATE.GAME) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				Bird.keyPressed = true;
				Camera.moveRight(2);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if(GameCore.state == GameCore.STATE.GAME) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				Bird.keyPressed = false;
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		if(GameCore.state == GameCore.STATE.MENU) {
				if(e.getKeyChar() == _S) {
					GameCore.state = GameCore.STATE.GAME;
				}
		
				if(e.getKeyChar() == _Q) {
					System.exit(1);
				}
		}
		
		if(GameCore.state ==  GameCore.STATE.OVER) {
			if(e.getKeyChar() == _R) {
				GameCore.state = GameCore.STATE.GAME;
//				GameCore.keyTouched = e.getKeyChar();
			}
		}
	}
	
}
