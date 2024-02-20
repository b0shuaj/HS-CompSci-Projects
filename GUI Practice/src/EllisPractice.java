import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EllisPractice 
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 500, 250);
		frame.setLayout(null);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(new Rectangle(50,50,100,40));
		frame.add(lblName);
		
		JTextField txt = new JTextField("");
		txt.setBounds(150,25,200,30);
		frame.add(txt);
		
		JButton btn = new JButton("Rick Roll");
		btn.setBounds(175,65,140,40);
		frame.add(btn);
		
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				lblName.setText(txt.getText());
				txt.setText("");
				btn.setLocation((int)Math.random()*frame.getWidth()-btn.getWidth(),btn.getY());
			}
		});
	
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
