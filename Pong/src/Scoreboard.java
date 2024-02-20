import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;




public class Scoreboard extends JComponent
{
	int p1;
	int p2;
	
	

	public Scoreboard()
	{
		
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
	public int winner()
	{
		if (p1 == 10)
		{
			return 1;
		}
		if(p2 == 10)
		{
			return 2;
		}
		return -1;
	}
	@Override
	public void paintComponent(Graphics g)
	{	
		
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.drawString(Integer.toString(p1),425,100);
		g2.drawString(Integer.toString(p2),525,100);
}
}
