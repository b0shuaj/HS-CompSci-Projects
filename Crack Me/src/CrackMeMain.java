import java.util.Scanner;
/**
 * 
 * @author Josh Babbitt
 * Project Crack Me
 *
 */
public class CrackMeMain 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		CrackMe pin = new CrackMe();
		boolean tf = false;
		int count = 0;
		String fullPin = pin.toString();
		int first = 0;
		int second = 0;
		int third = 0;
		int left = 10;
		boolean win = false;
		
		System.out.println("Hello and welcome to Crack Me! You have ten tries to guess the three digit pin! ");
		
		
		
		while(count < 10)
		{
			System.out.print("\nPlease enter a three digit code: ");
			int g = in.nextInt();
			in.nextLine();
			String guess = Integer.toString(g);
			int num = guess.length();
			
			
			if(num == 3)
			{
			if(pin.checkFirstDigit(guess) == tf)
			{
				System.out.print("_ ");
			}
			else if (pin.checkFirstDigit(guess) == true)
			{
				System.out.print(fullPin.substring(0,1));
				first++;
			}
			
			if(pin.checkSecondDigit(guess) == tf)
			{
				System.out.print("_ ");
			}
			else if(pin.checkSecondDigit(guess) == true)
			{
				System.out.print(fullPin.substring(1,2));
				second++;
			}
			
			if(pin.checkThirdDigit(guess) == tf)
			{
				System.out.print("_");
			}
			else if(pin.checkThirdDigit(guess) == true)
			{
				System.out.print(fullPin.substring(2,3));
				third++;
			}
			
			
			System.out.print("\n");
			if((first + second + third) !=3 && (first + second + third) != 0) 
			{
				System.out.println("You have " + (left-1) + " tries left to get them all!");
			}
			else if((first + second + third) == 0)
			{
				System.out.println("You've got none correct! You have " + (left-1) + " tries left to get them all!");
			}
			else if ((first + second + third) == 3)
			{
				System.out.println("\nCongratualations! You have soleved the pin!");
				count = 10;
				win = true;
			}
			
			
			count++;
			left--;
			
			first = 0;
			second = 0;
			third = 0;
			}
			
			else
			{
				System.out.println("\nERROR 404!!! You didn't enter the correct format silly. I got you tho! To the top we go!!!");
			}
		}
		
		if(win == false)
		{
			System.out.println("\nYou Lost!!! Restart the code to try again! The correct pin was " + pin.toString());
			
		}
		
		in.close();
	}
}