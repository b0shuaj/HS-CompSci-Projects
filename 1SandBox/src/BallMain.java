import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BallMain extends JFrame
{
	public BallMain()
	{
		//ArrayList<Ball> balls = new ArrayList<Ball>();
		this.setBounds(200,200,600,400);
		this.setLayout(null);
		this.setTitle("BallJawn");
		
		Ball b = new Ball(50,150,15);
		add(b);
		
		
		
//		
//		JButton btn = new JButton("click me please");
//		btn.setBounds(500,340,90,40);
//		btn.addActionListener(new ActionListener () {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				Ball b = new Ball((int)(Math.random()*590),(int)(Math.random()*360),(int)(Math.random()*50));
//				add(b);
//				repaint();
//			}
//			
//		});
//		add(btn);\
		
		this.addKeyListener(new KeyListener()
		{

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_W)
				{
					b.setLocation(b.getX(),b.getY()-10);
				}
				else if(e.getKeyCode() == e.VK_A)
				{
					b.setLocation(b.getX()-10,b.getY());
				}
				else if(e.getKeyCode() == e.VK_S)
				{
					b.setLocation(b.getX(),b.getY()+10);
				}
				else if(e.getKeyCode() == e.VK_D)
				{
					b.setLocation(b.getX()+10,b.getY());
				}
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				//not really using
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				//not using
			}
			
		});
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args)
	{
		new BallMain();
	}
}
