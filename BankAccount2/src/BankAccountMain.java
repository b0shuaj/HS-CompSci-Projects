import java.util.ArrayList;
import java.util.Scanner;

public class  BankAccountMain 
{
	static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	private static BankAccount getAccountByNumber(int number)
	{
		for(int i = 0; i < accounts.size(); i++)
		{
			if(accounts.get(i).getAccountNum() == number)
			{
				return accounts.get(i);
			}
		}
		return null;
	}
	
	private static ArrayList<BankAccount> getAccountByName(String name)
	{
		ArrayList<BankAccount> accountNames = new ArrayList<BankAccount>();
		for(int i = 0; i < accounts.size(); i++)
		{
			if(accounts.get(i).getName().equals(name))
			{
				accountNames.add(accounts.get(i));
			}
		}
		if(accountNames.get(0) != null)
		{
			return accountNames;
		}
		else
			return null;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		boolean terminate = false;
		String firstAns;
		String cOrS;
		String checkingName;
		String bal;
		double balance;
		String wdtg;
		boolean make = true;
		int accNum;
		double withdraw;
		double deposit;
		int transNum;
		double transfer;
		boolean getAccNum = false;
		
		
		while(terminate == false)
		{
			accNum = 0;
			System.out.print("Would you like to (A)dd an Account, (M)ake a transaction, or (T)erminate? ");
			firstAns = in.nextLine();
			
			//add an account
			if(firstAns.equals("A"))
			{
				System.out.print("\nWould you like to create a (C)hecking or a (S)avings account: ");
				cOrS = in.nextLine();
				
					//checking
				if(cOrS.equals("C"))
				{
					System.out.print("\nPlease enter the name of your checking account: ");
					checkingName = in.nextLine();
					System.out.print("Please enter the balance of your account. If you have no balance, press the Enter key: ");
					bal = in.nextLine();
					
					if(bal.equals(""))
					{
						System.out.println("pressed enter");
						//bal = 0
						accounts.add(new CheckingAccount(checkingName, 15, 1.5, 10));
					}
					else
					{
						balance = Double.parseDouble(bal);
						//bal != 0
						accounts.add(new CheckingAccount(checkingName, balance, 15, 1.5, 10));
					}
					System.out.println("Account Added: " + accounts.get(0).toString());
					System.out.println("Please press enter again.");
					in.nextLine();
				}
				else if(cOrS.equals("S"))
				{
					System.out.print("\nPlease enter the name of your savings account: ");
					checkingName = in.nextLine();
					System.out.print("Please enter the balance of your account. If you have no balance, press the Enter key: ");
					bal = in.nextLine();
					
					if(bal.equals(""))
					{
						//bal = 0
						accounts.add(new SavingsAccount(checkingName, 0.0025, 300, 10));
					}
					else
					{
						balance = Double.parseDouble(bal);
						//bal != 0
						accounts.add(new SavingsAccount(checkingName, balance, 0.0025, 300, 10));
					}
					System.out.println("Account Added: \t" + accounts.get(0).toString());
					System.out.println("Please press enter again.");
					in.nextLine();
				}
			}

			if(firstAns.equals("M"))
			{

				System.out.print("Would you like to (W)ithdraw, (D)eposit, (T)ransfer, or (G)et account numbers: ");
				wdtg = in.nextLine();
				
				while(make == true)
				{
					if(wdtg != "G")
					{
						while(getAccNum == false)
						{
							System.out.print("Please enter your account number: ");
							accNum = in.nextInt();
							in.nextLine();
							
							if(getAccountByNumber(accNum) == null)
							{
								boolean thisWhile = true;
								String accName;
								while(thisWhile)
								{
									System.out.println("ERROR! There are no accounts associated with this name or number. "
											+ "Please enter in your number again, or enter your account name: ");
									if(in.hasNextInt())
									{
										accNum = in.nextInt();
										in.nextLine();
										if(getAccountByNumber(accNum) == null)
										{
											
										}
										else
										{
											
											thisWhile = false;
										}
									}
									else
									{
										accName = in.nextLine();
										if(getAccountByName(accName) == null)
										{
											
										}
										else
										{
											for(BankAccount a : getAccountByName(accName))
											{
												if(a instanceof CheckingAccount)
												{
													System.out.println("Checking Account: \t" + a.toString());
												}
												if(a instanceof SavingsAccount)
												{
													System.out.println("Savings Account: \t" + a.toString());
												}
											}
										}
											
																						
												
									}
								}
							}
							else
								getAccNum = true;
						}
					}

					switch(wdtg)
					{
					//FIX
					case "W":
						make = false;
						System.out.print("How much would you like to Withdraw: ");
						withdraw = in.nextDouble();
						in.nextLine();
						try
						{
							getAccountByNumber(accNum).withdraw(withdraw);
							System.out.println("Done!");
							
						}
						catch (IllegalArgumentException e)
						{
							System.out.println("TRANSACTION NOT AUTHORIZED!");
						}
						break;
						
					case "D":
						make = false;
						System.out.print("How much would you like to Deposit: ");
						deposit = in.nextDouble();
						in.nextLine();
						try
						{
							getAccountByNumber(accNum).deposit(deposit);
							System.out.println("Done!");
						}
						catch (IllegalArgumentException e)
						{
							System.out.println("TRANSACTION NOT AUTHORIZED!");
						}
						break;
						
					case "T":
						make = false;
						System.out.print("What is the Account Number of the account you wish to transfer to: ");
						transNum = in.nextInt();
						in.nextLine();
						if(getAccountByNumber(transNum) == null)
						{
							System.out.println("ERROR! There are no accounts associated with this number. Please try again later");
							break;
						}
						System.out.print("How much would you like to Transfer: ");
						transfer = in.nextDouble();
						in.nextLine();
						try
						{
							getAccountByNumber(accNum).transfer(getAccountByNumber(transNum), transfer);
							System.out.println("Done!");
						}
						catch (IllegalArgumentException e)
						{
							System.out.println("TRANSACTION NOT AUTHORIZED!");
						}
						break;
						
					case "G":
						make = false;
						System.out.println(getAccountByNumber(accNum).toString());
						break;
							
						default:
							System.out.println("ERROR! Inappropriate response. Please try again...");
					
				}
				
				}
			}
			if(firstAns.equals("T"))
				terminate = true;
				
			}
		System.out.println("You've chose Terminate. Goodbye!");
		in.close();
		}
	}

