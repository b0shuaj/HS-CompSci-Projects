	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.geom.Ellipse2D;

	import javax.swing.JComponent;

	public class Ball extends JComponent
	{
		private Ellipse2D.Double circle;
		
		public Ball(int x, int y, int d)
		{
			circle = new Ellipse2D.Double(0,0,d,d);
			this.setLocation(x,y);
			this.setSize(d+1,d+1);
		}
		
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g; //do this first
			
			g2.setColor(Color.BLUE);
			g2.draw(circle);
			g2.setColor(Color.RED);
			g2.fill(circle);
			
		}
	}


