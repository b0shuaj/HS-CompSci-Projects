
public class BankAccountTesting 
{
	public static void main(String[] args)
	{
		BankAccount checking = new CheckingAccount("Josh", 1000, 5, 17, 3);
		BankAccount saving = new SavingsAccount("Josh", 1000, 0.2, 200, 14);
		
		saving.withdraw(20);
		saving.withdraw(20);
		saving.withdraw(20);
		saving.withdraw(20);
		saving.withdraw(20);
		System.out.println(saving.getBalance());
		
	}
}
