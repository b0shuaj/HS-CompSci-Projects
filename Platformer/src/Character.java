
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/*/
 * This is the lil' guy
 * Made by Josh
 */
public class Character extends JComponent
{
	
	//Demonstrate a commit and push
	private Rectangle2D.Double hero;
	private int dx, dy;
	
	
	public Character(int x, int y)
	{
		hero = new Rectangle2D.Double(0,0, 20, 20);
		this.setLocation(x,y);
		this.setSize(new Dimension(20,20));
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.draw(hero);
		g2.setColor(Color.BLUE);
		g2.fill(hero);
	}
	
	public void setDx(int x)
	{
		dx = x;
	}
	public void setDy(int y)
	{
		dy = y;
	}
	public int getDx()
	{
		return dx;
	}
	public int getDy()
	{
		return dy;
	}
	public void changeX(int x)
	{
		setLocation(getX() + x, getY());
	}
	public void changeY(int y)
	{
		setLocation(getX(), getY() + y);
	}
	public void updateX()
	{
		setLocation(getX() + dx, getY());
	}
	public void updateY()
	{
		setLocation(getX(), getY() + dy);
	}
}
