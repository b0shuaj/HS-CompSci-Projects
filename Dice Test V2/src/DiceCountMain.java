/**
 * 
 * @author Josh Babbitt
 * Project Dice Roll Counter
 *
 */
public class DiceCountMain
{
	public static void main(String[] args) 
	{
		Dice dice = new Dice();
		int count = 0;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		
		while (count<10)
		{
			int roll = dice.roll();
			
			if(roll == 1)
			{
				one++;
			}
			if(roll == 2)
			{
				two++;
			}
			if(roll == 3)
			{
				three++;
			}
			if(roll == 4)
			{
				four++;
			}
			if(roll == 5)
			{
				five++;
			}
			if(roll == 6)
			{
				six++;
			}
			System.out.print(roll + " ");
			count++;
		}
		
		System.out.println("\n\nones: " + one);
		System.out.println("\ntwos: " + two);
		System.out.println("\nthrees: " + three);
		System.out.println("\nfours: " + four);
		System.out.println("\nfives: " + five);
		System.out.println("\nsixes: " + six);
		
	}
}
