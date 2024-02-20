import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

//motion demo part 2
public class DyDxDemo extends JFrame implements ActionListener
{
	private thing thing;
	public DyDxDemo()
{
		this.setBounds(100,100,700,500);
		setLayout(null);
		setTitle("MotionDemoPart2");
		
		thing = new thing();
		add(thing);
		
		Timer t = new Timer(25,this);
		t.start();
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_A)
					thing.setDx(-3);
				else if(e.getKeyCode() == e.VK_D)
					thing.setDx(3);
				else if(e.getKeyCode() == e.VK_W)
					thing.setDy(-3);
				else if(e.getKeyCode() == e.VK_S)
					thing.setDy(3);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == e.VK_A)
					thing.setDx(0);
				else if(e.getKeyCode() == e.VK_D)
					thing.setDx(0);
				else if(e.getKeyCode() == e.VK_W)
					thing.setDy(-0);
				else if(e.getKeyCode() == e.VK_S)
					thing.setDy(0);
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
}
	public static void main(String[] args)
	{
		new DyDxDemo();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		thing.update();
		
	}
}
