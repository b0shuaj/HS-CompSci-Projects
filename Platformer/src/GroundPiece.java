
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;


public class GroundPiece extends JComponent 
{

	private Rectangle2D.Double rect;
	
	public GroundPiece(int lx, int ly, int sx, int sy) 
	{
		rect = new Rectangle2D.Double(0,0,sx,sy);
		setSize(new Dimension(sx+1,sy+1));
		setLocation(lx,ly);
	}
	
	public Rectangle2D.Double getPlatform()
	{
		return rect;
	}
	
	public void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.fill(rect);
		g2.draw(rect);
	}
}
