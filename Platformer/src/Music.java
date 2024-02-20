
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Music 
{
	private Clip clip;
	
	public static Music music = new Music("/gff.wav");
	public static Music get = new Music("/getkey.wav");
	
	public Music(String filename)
	{
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(Music.class.getResource(filename));
			clip = AudioSystem.getClip();
			clip.open(ais);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void play()
	{
		try{
			if(clip != null)
			{
				new Thread()
				{
					public void run()
					{
						synchronized (clip)
						{
							clip.stop();
							clip.setFramePosition(0);
							clip.start();
						}
					}
					
				}.start();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void stop()
	{
		if(clip==null) return;
		clip.stop();
	}
	public void loop() {
		try {
			if (clip != null) {
				new Thread() {
					public void run() {
						synchronized (clip) {
							clip.stop();
							clip.setFramePosition(0);
							clip.loop(Clip.LOOP_CONTINUOUSLY);
						}
					}
				}.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isActive(){
		return clip.isActive();
	}
}
