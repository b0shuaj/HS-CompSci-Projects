import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class PongMain extends JFrame implements ActionListener 
{
	
	private Ball b;
	
	private Player left;
	private Player right;
	
	private Scoreboard score;
	
	
	public PongMain()
	{
		this.setBounds(0,0,1000,800);
		this.setLayout(null);
		this.setTitle("Pong!");
		this.setResizable(false);
		this.getContentPane().setBackground(Color.BLACK);
		
		left = new Player(50,400);
		right = new Player(940,400);
		b = new Ball(400,300);
		score = new Scoreboard();
		
		this.add(left);
		this.add(right);
		this.add(b);
		this.add(score);
		
		Timer t = new Timer(25, this);
		t.start();
		
	
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == e.VK_W)
				{
					left.setDy(-7);

				}
				if(e.getKeyCode() == e.VK_S)
				{
					left.setDy(7);
				}
				
				if(e.getKeyCode() == e.VK_UP)
				{
					right.setDy(-7);
				}
				if(e.getKeyCode() == e.VK_DOWN)
				{
					right.setDy(7);
				}
				if(e.getKeyCode() == e.VK_SPACE)
				{
					b.setDx((int) (Math.random()*6) +3);
					b.setDy((int) (Math.random()*6) +3);
					
				}
				if(e.getKeyCode() == e.VK_R)
				{
					b.setPos(400,300);
					left.setLocation(50,400);
					right.setLocation(940,400);
				}
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == e.VK_W)
				{
					left.setDy(0);
				}
				if(e.getKeyCode() == e.VK_S)
				{
					left.setDy(0);
				}
				
				if(e.getKeyCode() == e.VK_UP)
				{
					right.setDy(0);
				}
				if(e.getKeyCode() == e.VK_DOWN)
				{
					right.setDy(0);
				}
				repaint();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			
		});
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		right.update();
		left.update();
		
		b.update();
		
		if(b.getX() > right.getX() && b.getX() < right.getX() + right.getWidth())
		{
			if(b.getY() > right.getY() && b.getY() < right.getY() + right.getHeight())
			{
				b.rightBounce();
			}
		}
		if(b.getX() > left.getX() && b.getX() < left.getX() + left.getWidth())
		{
			if(b.getY() > left.getY() && b.getY() < left.getY() + left.getHeight())
			{
				b.leftBounce();
			}
		}
		
		//left = 2
		//right = 1
		
		if(b.getX() == 0)
		{
			score.point(2);
			b.setPos(400,300);
			System.out.println(score.score());
		}
		if(b.getX() == 1000)
		{
			score.point(1);
			b.setPos(400,300);
			System.out.println(score.score());
		}
		
		
		if(score.winner() == 1)
		{
			b.setPos(400,300);
			left.setLocation(50,400);
			right.setLocation(940,400);
			right.stop();
			left.stop();
			JOptionPane.showMessageDialog(this, "Left won!");
			
		}
		if(score.winner() == 2)
		{
			b.setPos(400,300);
			left.setLocation(50,400);
			right.setLocation(940,400);
			right.stop();
			left.stop();
			JOptionPane.showMessageDialog(this, "Right won!");
			
		}
		
		
	}
	public static void main(String[] args)
	{
		new PongMain();
	}

}
