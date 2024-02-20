import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class Player extends JComponent{
	
	private Rectangle2D.Double player = new Rectangle2D.Double(0,0,10,100);
	
	int dy = 0;
	
	public Player(int x, int y)
	{
		 this.setLocation(x,y);
		 this.setSize(new Dimension(10,100));
		 dy = 0;
	}
	public void setDy(int x)
	{
		dy = x;
	}
	public void stop()
	{
		dy = 0;
	}
	public void update()
	{
		 if (getY() <= 0 && dy <=0)
		{
			dy = 0;
		}
		 if(getY() >=645 && dy>=0)
		 {
			 dy = 0;
		 }
		setLocation(getX(), getY() + dy);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.draw(player);
		g2.fill(player);
		
	}
}
