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
		
		public Ball(int x, int y)
		{
			circle = new Ellipse2D.Double(0,0,8,8);
			this.setSize(9,9);
			this.setLocation(x,y);
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
		public void bounce()
		{
			dx = -dx;
			dy = -dy;
		}
		
		public void update()
		{
			if(getX() <= 0 && dx <= 0)
			{
				dx = 0;
				dy = 0;
			}
			if(getX() >=975 && dx>=0)
			{
				dx = 0;
				dy = 0;
			}
			if(getY() <= 0 && dy <= 0)
			{
				dy = -dy;
			}
			if(getY() >=785 && dy>=0)
			{
				dy = -dy;
			}
			setLocation(getX() + dx, getY() + dy);
		}
		
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g; //do this first
			
			g2.setColor(Color.WHITE);
			g2.draw(circle);
			g2.fill(circle);
			
		}
	}