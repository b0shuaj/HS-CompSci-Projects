import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
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
		
		left = new Player(50,250);
		right = new Player(940,250);
		b = new Ball(400,300);
		score = new Scoreboard(425, 100);
		
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
		
		if(left.getX()+10 == b.getX())
		{
			if(left.getY()<= b.getY() || left.getY()-50 >= b.getY())
			{
				b.bounce();
			}
		}
		if(right.getX() == b.getX())
		{
			if(right.getY()<=b.getY() || left.getY()-50 >= b.getY())
			{
				b.bounce();
			}
		}
		
		//left = 2
		//right = 1
		
		if(b.getX() == 0)
		{
			score.point(1);
			b.setPos(400,300);
			System.out.println(score.score());
		}
		if(b.getX() == 1000)
		{
			score.point(2);
			b.setPos(400,300);
			System.out.println(score.score());
		}
		
		
		
	}
	public static void main(String[] args)
	{
		new PongMain();
	}

}
