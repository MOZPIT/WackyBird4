package WackyBird4;
public class Camera
{
	static int x; 
	static int y;

	public static void setLocation(int x, int y)
	{
		Camera.x = x;
		Camera.y = y;
	}
	
	public static void moveLeft(int dx)
	{
		x -= dx;
	}
	
	public static void moveRight(int dx)
	{
		x += dx;
	}
}