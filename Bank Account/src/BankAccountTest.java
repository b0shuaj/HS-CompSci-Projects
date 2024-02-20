/**
 * 
 * @author Josh Babbitt
 * Project Bank Account Test
 *
 */
public class BankAccountTest 
{
	public static void main(String[] args)
	{
		BankAccount cW = new BankAccount("Carson Wentz", 10);
		BankAccount jC = new BankAccount("Jose Canseco", 21, 300);
		
		System.out.println("Carson Wentz:");
		cW.deposit(100);
		System.out.println(cW.getBalance());
		cW.withdraw(23);
		System.out.println(cW.getBalance());
		cW.deposit(73);
		System.out.println(cW.getBalance());
		cW.withdraw(85);
		System.out.println(cW.getBalance());
		cW.deposit(283);
		System.out.println(cW.getBalance());
		cW.withdraw(154);
		System.out.println(cW.getBalance());
		
		System.out.println("\nJose Canseco:");
		jC.deposit(100);
		System.out.println(jC.getBalance());
		jC.withdraw(23);
		System.out.println(jC.getBalance());
		jC.deposit(73);
		System.out.println(jC.getBalance());
		jC.withdraw(85);
		System.out.println(jC.getBalance());
		jC.deposit(283);
		System.out.println(jC.getBalance());
		jC.withdraw(394);
		System.out.println(jC.getBalance());
		
		System.out.println("\n" + cW.toString());
		System.out.println("\n" + jC.toString());
	}
}
