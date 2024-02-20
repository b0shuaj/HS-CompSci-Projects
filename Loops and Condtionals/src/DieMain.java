import java.util.Scanner;

//import java.util.Scanner;

/**
 * 
 * @author 	Josh Babbitt
 * 
 * MULTI SIDED DIE MAIN
 *
 */
public class DieMain 
{

	public static void main(String[] args) 
	{
		/*
		 * TASK ONE
		 * 
		 * create two twelve sided dice and
		 * roll the dice until you roll doubles
		 * (print each roll to the screen).
		 * Once you have rolled doubles, print
		 * to the screen the number of times
		 * you had to roll the dice to get doubles
		 * 
		 */
			
			MultiSidedDie dice1 = new MultiSidedDie(12);
			MultiSidedDie dice2 = new MultiSidedDie(12);
		
			int roll1 = dice1.roll();
			int roll2 = dice2.roll();
			
			while (!(roll1 == roll2))
			{
				System.out.println(roll1 + " " + roll2);
				roll1 = dice1.roll();
				roll2 = dice2.roll();
			}
			System.out.println(roll1 + " " + roll2);
			System.out.println("This was rolled : " + dice1.getNumRolls() + " times.");
			
		
		/*
		 * TASK TWO
		 * 
		 * ask the user to enter the number of sides
		 * they would like to have on their dice and
		 * construct the appropriate Die object (only one).
		 * 
		 * ask the user to identify a target roll 
		 * value(ensure that it is between 1 and numSides).
		 * Roll the Die 20 times, printing
		 * each roll.  Print the number of times the
		 * target was rolled
		 *
		 */
		
//			Scanner in = new Scanner(System.in);
//			int num = 0;
//	
//			System.out.print("Please enter the number of sides on your die: ");
//			num = in.nextInt();
//			in.nextLine();
//			
//			if(num < 4)
//				num = 4;
//		
//			MultiSidedDie die = new MultiSidedDie(num);
//			int guess = 0;
//			
//		while(!(guess > 0 ) || !(guess <= num))
//			{
//				System.out.print("Please guess a number between 1 and " + num + ": ");
//				guess = in.nextInt();
//			}
//			int count = 0;
//			for(int i = 0; i<20; i++)
//			{
//				int roll = die.roll();
//				System.out.println(roll);
//				if(roll == guess)
//				{
//					count++;
//				}
//			}
//			System.out.println("Your number: " + guess + " was rolled " + count + " times.");
//	
//		in.close();
			
			

		/*
		 * TASK THREE
		 * 
		 * As in task two, ask the user to identify the number
		 * of sides for the Die object and construct the 
		 * appropriate Die.  Ask the user to identify a target
		 * roll value(ensure that it is a valid entry).  
		 * Roll the die until you the target is rolled.  Print
		 * each roll.   Print the number of rolls required to 
		 * roll the target value.
		 */
		
//		Scanner in = new Scanner(System.in);
//		int num = 0;
//
//		System.out.print("Please enter the number of sides on your die: ");
//		num = in.nextInt();
//		in.nextLine();
//	
//		if(num < 4)
//			num = 4;
//		
//		MultiSidedDie die = new MultiSidedDie(num);
//		
//		int guess = 0;
//		while(!(guess > 0 ) || !(guess <= num))
//		{
//			System.out.print("Please guess a number between 1 and " + num + ": ");
//			guess = in.nextInt();
//		}
//		
//		int roll = die.roll();
//		while(!(roll == guess))
//		{
//			System.out.println(roll);
//			roll = die.roll();
//		}
//		System.out.println(roll);
//		System.out.println("It took " + die.getNumRolls() + " tries to get your number of " + guess);
		
	}

}
