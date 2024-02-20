import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GBLJawn extends JFrame
{

	public ArrayList<Person> people;
	
	
	public GBLJawn()
	{
		people = new ArrayList<Person>();
		setBounds(100,100,500,250);
		setTitle("GridBagLayout");
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		JLabel lblName = new JLabel("Name:");
		add(lblName,gbc);
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(120,30));
		
		txtName.setEnabled(false);
		gbc.gridx++;
		add(txtName,gbc);
		
		JCheckBox chkEnable = new JCheckBox("Enable that Jawn");
		
		gbc.gridx=0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		
		chkEnable.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(chkEnable.isSelected())
					txtName.setEnabled(true);
				else
					txtName.setEnabled(false);
				
				
			}
			
		});
		
		add(chkEnable,gbc);
		
		JButton submit = new JButton("Add Person");
		submit.setPreferredSize(new Dimension(200,40));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(txtName.isEnabled() && 
						!txtName.getText().equals(""))
				{
					people.add(new Person(txtName.getText()));
					txtName.setText("");
				}
			}
		});
		
		gbc.gridy++;
		add(submit,gbc);
		
		
		
		this.setResizable(false);
		
		
		
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) 
	{
		new GBLJawn();
	}

}
