import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class DodgeballMain extends JFrame implements ActionListener{

	private Ball b1;
	private Ball b2;
	private Ball b3;
	private Ball b4;
	private Ball b5;
	private Ball b6;
	
	private StickFigure left;
	private StickFigure right;
	
	private ArrayList<Ball> balls;
	
	
	public DodgeballMain()
	{
		this.setBounds(100,100,1000,800);
		this.setLayout(null);
		this.setTitle("Dodgeball");
		
		left = new StickFigure(50,250);
		right = new StickFigure(900,250);

		add(left);
		add(right);
		
		balls = new ArrayList<Ball>(6);
		
		Timer t = new Timer(25,this);
		t.start();
		
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				//left stick figure
				if(e.getKeyCode() == e.VK_A)
				{
						left.setDx(-5);
				}
				else if(e.getKeyCode() == e.VK_D)
				{
						left.setDx(5);
				}
				else if(e.getKeyCode() == e.VK_W)
				{
						left.setDy(-5);
				}
				else if(e.getKeyCode() == e.VK_S)
				{
						left.setDy(5);
				}
				
				//right stick figure
				if(e.getKeyCode() == e.VK_LEFT)
				{
						right.setDx(-5);
				}
				else if(e.getKeyCode() == e.VK_RIGHT)
				{
						right.setDx(5);
				}
				else if(e.getKeyCode() == e.VK_UP)
				{
						right.setDy(-5);
				}
				else if(e.getKeyCode() == e.VK_DOWN)
				{
						right.setDy(5);
				}
				
				//left throw
				if(e.getKeyCode() == e.VK_SPACE && canLeftShoot())
				{
					Ball ball = new Ball();
					ball.setLocation(left.getX()+50, left.getY());
					ball.setDx(7);
					balls.add(ball);
					add(ball);
				}
				
				//right throw
				if(e.getKeyCode() == e.VK_NUMPAD0 && canRightShoot())
				{
					Ball ball = new Ball();
					ball.setLocation(right.getX(), right.getY());
					ball.setDx(-7);
					balls.add(ball);
					add(ball);
				}
				
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == e.VK_A)
					left.setDx(0);
				else if(e.getKeyCode() == e.VK_D)
					left.setDx(0);
				else if(e.getKeyCode() == e.VK_W)
					left.setDy(0);
				else if(e.getKeyCode() == e.VK_S)
					left.setDy(0);
				
				if(e.getKeyCode() == e.VK_LEFT)
					right.setDx(0);
				else if(e.getKeyCode() == e.VK_RIGHT)
					right.setDx(0);
				else if(e.getKeyCode() == e.VK_UP)
					right.setDy(0);
				else if(e.getKeyCode() == e.VK_DOWN)
					right.setDy(0);
				repaint();
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public boolean canLeftShoot()
	{
		int count = 0;
		for(Ball b: balls)
		{
			if(b.getDx() > 0)
			{
				count++;
			}
			
		}
		if(count >= 3)
		{
			return false;
		}
		return true;
	}
	public boolean canRightShoot()
	{
		int count = 0;
		for(Ball b: balls)
		{
			if(b.getDx() < 0)
			{
				count++;
			}
			
		}
		if(count >= 3)
		{
			return false;
		}
		return true;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean ball = true;
		
		left.update();
		right.update();
		for(Ball b: balls)
		{
			b.update();
			if(b.getDx() > 0)
			{
				if(b.getX() > right.getX() && b.getX() < right.getX() + right.getWidth())
				{
					if(b.getY() > right.getY() && b.getY() < right.getY() + right.getHeight())
					{
						JOptionPane.showMessageDialog(this, "Left Won!");
						left.setLocation(50,250);
						right.setLocation(900,250);
						right.stop();
						left.stop();
						ball = false;
					}
				}
			}
			else
			{
				if(b.getX() > left.getX() && b.getX() < left.getX() + left.getWidth())
				{
					if(b.getY() > left.getY() && b.getY() < left.getY() + left.getHeight())
					{
						JOptionPane.showMessageDialog(this, "Right Won!");
						left.setLocation(50,250);
						right.setLocation(900,250);
						right.stop();
						left.stop();
						ball = false;
					}
				}
			}
			
		}
		for(int i = 0; i < balls.size(); i++)
		{
			Ball b = balls.get(i);
			if(b.getX() < 0 || b.getX() > 1000)
			{
				balls.remove(b);
				i--;
			}
			if(ball == false)
			{
				balls.remove(b);
				this.remove(b);
			}
		}
	}
	public static void main(String[] args)
	{
		new DodgeballMain();
	}

}