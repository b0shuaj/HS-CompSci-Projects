import javax.swing.JFrame;

public class GUIPractice
{
	public static void main(String[] args)
	{
		JFrame myFrame = new JFrame();
		myFrame.setBounds(0, 0,1920,1080);
		//(x,y,width,height)
		
		//always the last two lines
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
