

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @author Josh Babbitt
 * Salary Calculator
 *
 */
public class SalaryCalculator 
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setBounds(0,0,500,450);
		frame.setLayout(null);
		frame.setTitle("Salary Calculator");
		
		JLabel rate = new JLabel("Hourly Rate: ");
		rate.setBounds(100,100,100,50);
		frame.add(rate);
		
		JLabel hours = new JLabel("Hours/Week: ");
		hours.setBounds(100,120,100,50);
		frame.add(hours);
		
		JTextField rateTxt = new JTextField();
		rateTxt.setBounds(175,115,100,20);
		frame.add(rateTxt);
		
		
		
		JTextField hoursTxt = new JTextField();
		hoursTxt.setBounds(175, 135,100,20);
		frame.add(hoursTxt);
		
		
		JCheckBox fulltime = new JCheckBox("Full Time? ");
		fulltime.setBounds(100,155,100,25);
		frame.add(fulltime);
		
		
		
		
		
		JButton btn = new JButton("Calculate!");
		btn.setBounds(100,180,100,25);
		frame.add(btn);
		
		JLabel salary = new JLabel("Annual Salary: $");
		salary.setBounds(215,180,400,25);
		frame.add(salary);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					salary.setText("Annual Salary: $ " + Double.parseDouble(hoursTxt.getText())*Double.parseDouble(rateTxt.getText())*52);
				}
				catch(NumberFormatException e)
				{
					salary.setText("Improper Inputs! Please try again.");
				}
				
				
			}
			
		});
		
		fulltime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(fulltime.isSelected())
				{
					hoursTxt.setText("");
					hoursTxt.setEditable(false);
				}
				else
				{
					hoursTxt.setEditable(true);
					hoursTxt.setText("");
				}
				
			}
			
		});
		
		
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
