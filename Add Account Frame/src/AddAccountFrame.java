import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddAccountFrame extends JFrame
{
	public ArrayList<BankAccount> accounts;
	
	public AddAccountFrame()
	{
		accounts = new ArrayList<BankAccount>();
		setTitle("Add Account");
		setBounds(100,100,750,400);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		
		JLabel name = new JLabel("Name: ");
		add(name,gbc);
		JTextField txt = new JTextField();
		txt.setPreferredSize(new Dimension(120,30));
		gbc.gridx++;
		add(txt,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		JLabel amt = new JLabel("Deposit: ");
		add(amt,gbc);
		JTextField deposit = new JTextField();
		deposit.setPreferredSize(new Dimension(120,30));
		gbc.gridx++;
		deposit.setEnabled(false);
		add(deposit,gbc);
		
		
		JCheckBox chk = new JCheckBox("Enable Deposit?");
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=2;
		
		chk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(chk.isSelected())
				{
					deposit.setEnabled(true);
				}
				else
				{
					deposit.setEnabled(false);
				}
				
			}
			
		});
		add(chk,gbc);
		
		gbc.gridy++;
		String[] choices = {"-------", "Checkings Account", "Savings Account"};
		JComboBox<String> menu = new JComboBox<String>(choices);
		menu.setPreferredSize(new Dimension(150,30));
		add(menu,gbc);
		
		gbc.gridy++;
		gbc.gridwidth = 3;
		JButton submit = new JButton("Submit");
		submit.setPreferredSize(new Dimension(200,30));
		add(submit,gbc);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
				
				if(deposit.isEnabled())
				{
					if(menu.getSelectedIndex() == 1)
					{
						//checking
						CheckingAccount checkingAccountD = new CheckingAccount(txt.getText(), Double.parseDouble(deposit.getText()));
						accounts.add(checkingAccountD);
					}
					if(menu.getSelectedIndex() == 2)
					{
						SavingsAccount savingsAccountD = new SavingsAccount(txt.getText(), Double.parseDouble(deposit.getText()));
						accounts.add(savingsAccountD);
					}
				}
				else
				{
					if(menu.getSelectedIndex() == 1)
					{
						//checking
						CheckingAccount checkingAccount = new CheckingAccount(txt.getText());
						accounts.add(checkingAccount);
					}
					if(menu.getSelectedIndex() == 2)
					{
						SavingsAccount savingsAccount = new SavingsAccount(txt.getText());
						accounts.add(savingsAccount);
					}
				}
				txt.setText("");
				deposit.setText("");
				menu.setSelectedIndex(0);
				chk.setSelected(false);
				deposit.setEnabled(false);
				}
				catch(NumberFormatException k)
				{
					
				}
			}
			
		});
		
		
		
		
		
		this.setResizable(false);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new AddAccountFrame();
	}
}
