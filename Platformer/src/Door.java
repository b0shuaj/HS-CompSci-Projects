import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;


public class Door extends JComponent 
{

	private Rectangle2D.Double rect;
	
	public Door()
	{
		rect = new Rectangle2D.Double(0,0,40,43);
		setSize(new Dimension(41,44));
	}

	
	public void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.GRAY);
		g2.fill(rect);

	}
}
