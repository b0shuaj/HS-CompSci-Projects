
public class SavingsAccount extends BankAccount
{
	private double intRate;
	private int numTransfers;
	
	private final double MIN_BAL;
	private final double MIN_BAL_FEE;
	public static final double MAX_TRANSFER = 6;
	public static final double TRANSACTION_FEE = 10;
	
	SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(n, b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	SavingsAccount(String n, double r, double mb, double mbf)
	{
		super(n);
		intRate= r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	
	public void deposit(double amt) throws IllegalArgumentException
	{
		if(amt <= 0)
		{
			throw new IllegalArgumentException("Deposit amount cannot be less than 0.");
		}
		else
		{
			super.deposit(amt);
		}
	}
	
	public void withdraw(double amt) throws IllegalArgumentException
	{
	
		double temp = super.getBalance() - amt;
		if(amt <= 0)
		{
			throw new IllegalArgumentException("Withdraw Amount cannot be less than 0.");
		}
		else
		{
			if(super.getBalance() - amt < 0)
			{
				throw new IllegalArgumentException("Balance cannot be negative.");
			}
			else
			{
				if(temp <= MIN_BAL)
				{
					super.withdraw(amt+MIN_BAL_FEE);
					
				}
				else
				{
					super.withdraw(amt);
				}
			}
		}
	}
	
	public void transfer(BankAccount other, double amt) throws IllegalArgumentException
	{
		if(super.getName().equals(other.getName()))
		{
			if(super.getBalance() - amt >= 0)
			{
				if(numTransfers >= MAX_TRANSFER)
				{
					super.transfer(other, amt);
				}
				else
				{
					super.transfer(other, amt);
					super.withdraw(TRANSACTION_FEE);
					other.withdraw(TRANSACTION_FEE);
				}
			}
			else
			{
				throw new IllegalArgumentException("Balance cannot be lower than 0 after Transfer.");
			}
		}
		else
		{
			throw new IllegalArgumentException("Both account names must be identical.");
		}
	}
	
	public void addInterest()
	{
		super.deposit(intRate*getBalance());
	}
	
	public void endOfMonthUpdate()
	{
		addInterest();
	}
	
	public int getTransfers()
	{
		return numTransfers;
	}
	
	
	
	
	
	
	
	
	
	
	
}
