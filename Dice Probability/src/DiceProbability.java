import java.util.Scanner;
/**
 * 
 * @author Josh Babbitt
 *
 */
public class DiceProbability 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Dice die1 = new Dice();
		Dice die2 = new Dice();
		int roll1;
		int roll2;
		
		System.out.print("Please enter the number of time you would like to roll: ");
		int num = in.nextInt();
		in.nextLine();
		int[] outcomes = new int[11];
		
		for(int i = 0; i < num; i++)
		{
			roll1 = die1.roll();
			roll2 = die2.roll();
			outcomes[(roll1+roll2)-2]++;
		}
		for(int i = 0; i < outcomes.length; i++)
		{
			System.out.printf("\n%d : %d ", i+2, outcomes[i]);
			System.out.printf("\tExperimental Probability: %.4f", (1.0 * outcomes[i]/num));
		}
		in.close();
		
	}
}
