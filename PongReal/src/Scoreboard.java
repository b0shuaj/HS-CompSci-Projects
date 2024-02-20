import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;




public class Scoreboard extends JComponent
{
	int p1;
	int p2;
	
	int x;
	int y;

	
	public Scoreboard(int width, int height)
	{
		x = width;
		y = height;
		this.setLocation(width, height);
		this.setSize(50,50);
		p1 = 0;
		p2 = 0;
	}
	public void point(int x)
	{
		if(x  == 1)
			p1++;
		if(x == 2)
			p2++;
	}
	public int score()
	{
		return p1 + p2;
	}
	public void paintComponent(Graphics g)
	{	
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.drawString(String.valueOf(p1),x,y);
		g2.drawString(String.valueOf(p2),x +100,y);
}
}
