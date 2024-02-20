import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Resize 
{
	public static BufferedImage resize(BufferedImage img, int width, int height) throws IOException
	{
		BufferedImage output = new BufferedImage(width, height, img.getType());
		Graphics2D g2d = output.createGraphics();
		g2d.drawImage(img,0,0,width,height,null);
		g2d.dispose();
		return img;
	}
	public static BufferedImage resize(BufferedImage img, double percent) throws IOException
	{
		int width = (int)(img.getWidth()*percent);
		int height = (int)(img.getHeight()*percent);
		return resize(img,width,height);
	}
}
