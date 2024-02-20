import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
//why is github bad?

import javax.swing.JComponent;


public class Key extends JComponent
{
	int length;
	int width;
	
	int x;
	int y;
	
	int dy;
	
	boolean collected = false;
	
	private Rectangle2D.Double outer = new Rectangle2D.Double(0,0,20,20);
	private Rectangle2D.Double inner = new Rectangle2D.Double(5,5,10,10);
	private Rectangle2D.Double keyLength = new Rectangle2D.Double(5,20,10,20);
	private Rectangle2D.Double littleOne = new Rectangle2D.Double(15,25,3,5);
	private Rectangle2D.Double littleTwo = new Rectangle2D.Double(15,35,5,5);
	
	Music get = new Music("/getkey.wav");
	
	public Key(int x, int y)
	{
		this.x = x;
		this.y = y;
		
		setLocation(x,y);
		this.setSize(new Dimension(100,100));
	}
	
	public void collect()
	{
		collected = true;
		get.play();
	}
	public void uncollect()
	{
		collected = false;
	}
	public boolean isCollected()
	{
		return collected;
	}
	
	public void bobbing()
	{
		while(collected == false)
		{
			setLocation(getX(),getY() + dy);
		}
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.draw(outer);
		g2.draw(inner);
		g2.draw(keyLength);
		g2.draw(littleOne);
		g2.draw((littleTwo));
		g2.setColor(Color.YELLOW);
		g2.fill(outer);
		g2.fill(keyLength);
		g2.fill(littleOne);
		g2.fill(littleTwo);
		g2.setColor(Color.WHITE);
		g2.fill(inner);
		
	}
}