import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class StickFigure extends JComponent{
	private Ellipse2D.Double head = new Ellipse2D.Double(15,0,20,20);
	private Rectangle2D.Double leftLeg = new Rectangle2D.Double(7,70,15,50);
	private Rectangle2D.Double rightLeg = new Rectangle2D.Double(27,70,15,50);
	private Rectangle2D.Double torso = new Rectangle2D.Double(17,35,15,40);
	private Rectangle2D.Double arms = new Rectangle2D.Double(0,20,50,15);
	
	
	
	public StickFigure(int x, int y)
	{
		 this.setLocation(x,y);
		 this.setSize(new Dimension(50,120));
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		g2.draw(leftLeg);
		g2.fill(leftLeg);
		g2.draw(rightLeg);
		g2.fill(rightLeg);
		g2.draw(torso);
		g2.fill(torso);
		g2.draw(head);
		g2.fill(head);
		g2.draw(arms);
		g2.fill(arms);
	}
}
