	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.geom.Ellipse2D;

	import javax.swing.JComponent;

	public class Ball extends JComponent
	{
		private Ellipse2D.Double circle;
		
		private int dx;
		private int dy;
		
		public Ball()
		{
			circle = new Ellipse2D.Double(0,0,10,10);
			this.setSize(11,11);
			dy = 0;
			dx = 0;
		}
		public void setPos(int x, int y)
		{
			this.setLocation(x,y);
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
		
		public void update()
		{
			setLocation(getX() + dx, getY() + dy);
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
