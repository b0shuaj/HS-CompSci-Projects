import java.util.ArrayList;

public class BankAccountTest 
{

	public static void main(String[] args) 
	{
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		accounts.add(new CheckingAccount("Mr. Ellis", 100, 30, 1, 10));
		accounts.add(new CheckingAccount("Mrs. Ellis",30,1,10));
		accounts.add(new SavingsAccount("Mr. Ellis", 500, .025, 200,5));
		accounts.add(new SavingsAccount("Mrs. Ellis", .025, 200,5));
	
		boolean correct = true;
		
		accounts.get(3).deposit(600);
		try 
		{
			accounts.get(3).deposit(-10);
			System.out.println("savings deposit negative");
			return;
			

		}
		catch(IllegalArgumentException e)
		{
			
		}
		
		try 
		{

			accounts.get(0).deposit(-10);
			System.out.print("checking deposit negative");
			return;
		}
		catch(IllegalArgumentException e)
		{
			
		}
		
		
		try 
		{
			accounts.get(3).withdraw(-10);
			System.out.println("savings withdraw negative");
			return;

		}
		catch(IllegalArgumentException e)
		{
			
		}
		
		try 
		{

			accounts.get(0).withdraw(-10);
			System.out.print("checking withdraw negative");
			return;
		}
		catch(IllegalArgumentException e)
		{
		}
		
		try
		{
			accounts.get(3).transfer(accounts.get(0), 50);
			System.out.println("savings transfer names don't match");
			return;
		}
		catch(IllegalArgumentException e)
		{
			
		}
		
		try
		{
			accounts.get(0).transfer(accounts.get(3), 50);
			System.out.println("checking transfer names don't match");
			return;
		}
		catch(IllegalArgumentException e)
		{
		}
		
		
		accounts.get(0).withdraw(120);
		if(accounts.get(0).getBalance() != -50)
		{
			System.out.println("line 82 overdraft fee");
			return;
		}
		
		try
		{
			accounts.get(3).withdraw(601);
			System.out.println("overdraft savings line 89");
			return;
		}
		catch(IllegalArgumentException e)
		{
		}
		
		accounts.get(3).withdraw(600);
		if(accounts.get(3).getBalance()!= -5)
		{
			System.out.println("withdraw line 96 min balance fee");
			return;
		}
		
		accounts.get(3).deposit(100);
		if(accounts.get(3).getBalance() != 95)
		{
			System.out.println("deposit line 102 maybe minbal");
			return;
		}
		System.out.println("hey!" +    accounts.get(0).getBalance());
		accounts.get(2).transfer(accounts.get(0),200);
		System.out.println("hey!" +    accounts.get(0).getBalance());
		
		for(int i = 0; i<8; i++)
		{
			if(i%2 == 0)
			{
				accounts.get(0).deposit(10);
				System.out.println("deposit: " + accounts.get(0).getBalance());
			}
			else
			{
				accounts.get(0).withdraw(10);
				System.out.println("withdraw: " + accounts.get(0).getBalance());
			}
		}
		if(accounts.get(0).getBalance() != 150)
		{
			System.out.println("transactions in loop on 111");
			System.out.println(accounts.get(0).getBalance());
			System.out.println(accounts.get(0).getTransfers());
			return;
		}
		
		accounts.get(0).withdraw(50);
		if(accounts.get(0).getBalance() != 99)
		{
			System.out.println("transaction fee line 119");
			return;
		}
		
		
		try
		{
			accounts.get(0).transfer(accounts.get(2), 100);
			System.out.println("transfer overdraft line 132");
			return;
		}
		catch(Exception e)
		{
		}
		
		accounts.get(0).withdraw(99);
		if(accounts.get(0).getBalance() != -31)
		{
			System.out.println("transaction fee overdraft");
			return;
		}
		accounts.get(3).deposit(700);
		//System.out.print(accounts.get(3).getBalance());
		for(int i = 0; i < 7; i++)
		{
			
			accounts.get(3).transfer(accounts.get(1), 5);
		}
		if(accounts.get(3).getBalance() != 750)
		{
			
			System.out.println("transfer fee Savings line 165");
			return;
		}
		
		
		if(!accounts.get(0).toString().equals("1\tMr. Ellis\t$-31.0"))
		{
			
			System.out.println("toString incorrect line 171");
			return;
		}
		System.out.println("you made it.");
		
			
		
		
	}

}
