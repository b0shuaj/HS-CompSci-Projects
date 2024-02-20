
public abstract class BankAccount 
{
	private static int nextAccNum;
	private String name;
	private int acctNum;
	private double balance;
	
	BankAccount(String n)
	{
		name = n;
		nextAccNum++;
		acctNum = nextAccNum;
		balance = 0;
	}
	
	BankAccount(String n, double b)
	{
		name = n;
		nextAccNum++;
		acctNum = nextAccNum;
		balance = b;
	}
	
	public void deposit(double amt)
	{
		balance += amt;
	}
	
	public void withdraw(double amt)
	{
		balance -= amt;
	}
	
	public int getAccountNum()
	{
		return acctNum;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public abstract void endOfMonthUpdate();
	
	public void transfer(BankAccount other, double amt)
	{
		other.deposit(amt);
		withdraw(amt);
	}
	
	public String toString()
	{
		String temp =  "Number: " + acctNum + "\t" + "Name: " + name + "\t" + "Balance: $" + balance;
		return temp;
	}

	public abstract int getTransfers();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
