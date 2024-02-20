import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Kickball extends JFrame{
	public Kickball()
	{
		this.setTitle("Kickball");
		this.setBounds(200,200,1000,750);
		this.setLayout(null);
		
		
		Ball b = new Ball(150,150,15);
		add(b);
		
		StickFigure sF = new StickFigure(0,0);
		add(sF);
		
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_W)
				{
					if(sF.getY() != 0) {
					sF.setLocation(sF.getX(),sF.getY()-10);
					
					if((sF.getX() - b.getX()<= 15 && sF.getX()-b.getX() >=0)|| 
							(b.getX()-sF.getX() <=45 && b.getX()-sF.getX()>=0)
							&&(b.getY()-sF.getY() <=10 && sF.getY()-b.getY() >=0))
					{
						b.setLocation(b.getX(),b.getY()-10);
					}
					}
				}
				else if(e.getKeyCode() == e.VK_S)
				{
					if(sF.getY() !=590)
					{
					sF.setLocation(sF.getX(),sF.getY()+10);
					
					if((sF.getX() - b.getX()<= 15 && sF.getX()-b.getX() >=0) || 
							(b.getX()-sF.getX() <=45 && b.getX()-sF.getX()>=0)
							&&(b.getY()-sF.getY() <=115 && sF.getY()-b.getY() >=105))
					{
						b.setLocation(b.getX(),b.getY()+10);
					}
				}
				}
				else if(e.getKeyCode() == e.VK_A)
				{
					if(sF.getX() != 0)
					{
					sF.setLocation(sF.getX()-10,sF.getY());
					if((sF.getY()-b.getY() <=15 && sF.getY() - b.getY() >= 0) || 
							(b.getY()-sF.getY() <=120 && b.getY()-sF.getY() >=0)
							&&(b.getX()-sF.getX() <=10 && b.getX()-sF.getX() >=0))
					{
						b.setLocation(b.getX()-10,b.getY());
					}
					}
				}
				else if(e.getKeyCode() == e.VK_D)
				{
					if(sF.getX() != 840)
					{
					sF.setLocation(sF.getX()+10,sF.getY());
					if((sF.getY()-b.getY() <=15 && sF.getY() - b.getY() >= 0) || 
							(b.getY()-sF.getY() <=120 && b.getY()-sF.getY() >=0)
							&&(b.getX()-sF.getX() <=45 && b.getX()-sF.getX() >=35))
					{
						b.setLocation(b.getX()+10,b.getY());
					}
					}
				}
				else if(e.getKeyCode() == e.VK_R)
				{
					b.setLocation(150,150);
					sF.setLocation(0,0);
				}
				repaint();				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new Kickball();
	}

}
