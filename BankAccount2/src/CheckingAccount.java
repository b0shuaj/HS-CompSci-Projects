
public class CheckingAccount extends BankAccount
{
	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final int FREE_TRANS;
	
	private int numTransactions;
	
	CheckingAccount(String n, double b, double odf, double tf, int freeTrans)
	{
		super(n, b);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
		super(n);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	
	public void deposit(double amt) throws IllegalArgumentException
	{
		if(amt <= 0)
		{
			throw new IllegalArgumentException("Amount cannot be less than 0.");
		}
		else
		{
			if(FREE_TRANS <= numTransactions)
			{
				//fees
				numTransactions++;
				super.deposit(amt);
				super.withdraw(TRANSACTION_FEE);
			}
			else if (FREE_TRANS > numTransactions)
			{
				//no fees
				numTransactions++;
				super.deposit(amt);
			}
		}
		
	}
	
	public void withdraw(double amt) throws IllegalArgumentException
	{
		if(amt <= 0)
		{
			throw new IllegalArgumentException("Amount cannot be less than 0.");
		}
		else if(super.getBalance() <= 0)
		{
			throw new IllegalArgumentException("Cannot make a withdraw while Balance is Negative");
		}
		else
		{
			if(FREE_TRANS <= numTransactions)
			{
				if(super.getBalance() - amt - TRANSACTION_FEE < 0)
				{
					//overdraft w/ trans fee
					numTransactions++;
					super.withdraw(amt);
					super.withdraw(OVER_DRAFT_FEE);
					super.withdraw(TRANSACTION_FEE);
					
				}
				else
				{
					//no overdraft w/ trans fee
					numTransactions++;
					super.withdraw(amt);
					super.withdraw(TRANSACTION_FEE);
	
				}
			}
			else
			{
				if(super.getBalance() - amt < 0)
				{
					//overdraft w/o trans fee
					numTransactions++;
					super.withdraw(amt);
					super.withdraw(OVER_DRAFT_FEE);
				}
				else
				{
					//no overdraft w/o trans fee
					numTransactions++;
					super.withdraw(amt);
				}
			}
		}
		
	}
	
	public void transfer(BankAccount other, double amt) throws IllegalArgumentException
	{
		if(other.getName().equals(super.getName()))
		{
			if(super.getBalance() - amt >= 0)
			{
				super.transfer(other, amt);
			}
			else
			{
				throw new IllegalArgumentException("Balance cannot be lower than 0 after the transfer.");
			}
		}
		else
		{
			throw new IllegalArgumentException("Both account names have to be identical");
		}
 
	}
	
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
	public int getTransfers()
	{
		return numTransactions;
	}
	
}
