package WackyBird4;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	private AudioClip clip;
	
	public static Sound test = new Sound("sound.wav");
	
	
	public Sound(String path) {
		clip = Applet.newAudioClip(getClass().getResource(path));
	}
	
	public Sound() {
		//do nothing
	}
	
	public void play() {
		new Thread() {
			public void run() {
				clip.play();
			}
		}.start();
	}
	
	void playBackgroundMusic() {		
		
		try 
		{
			File musicpath = new File("src/WackyBird4/sounds/backgroundAudio.wav");
			if(musicpath.exists())
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
				Clip bgclip = AudioSystem.getClip();
				bgclip.open(audioInput);
				bgclip.start();
				bgclip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else
			{
				System.out.println("Can't find file");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}
