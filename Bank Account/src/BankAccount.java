/**
 * 
 * @author Josh Babbitt
 * Project Bank Account
 * Still no easter eggs here.
 *
 */
public class BankAccount
{
	//Fields
	
	private String name;
	private double balance;
	private int accountNumber;
	
	//Constructors
	
	public BankAccount(String n, int aN)
	{
		balance = 0.0;
		name = n;
		accountNumber = aN;
	}
	public BankAccount(String n, int aN, double b)
	{
		name = n;
		accountNumber = aN;
		balance = b;
	}
	
	//Methods
	
	public double deposit(double amt)
	{
		return balance += amt;
	}
	public double withdraw(double amt)
	{
		return balance -= amt;
	}
	public double getBalance()
	{
		return balance;
	}
	public String toString()
	{
		String aNString = Integer.toString(accountNumber); 
		String bString = Double.toString(balance); 
		return "Name: " + name + "\tBalance: " + bString + "\tAccount #: " + aNString;
	
	}
}
