/**
 * 
 * @author Josh Babbitt
 * Project: Dice Test
 * There is no easter egg
 *
 */
public class Test 
{
	public static void main(String[] args) 
	{
		Dice x = new Dice();
		Dice y = new Dice();
	
		
		System.out.print("Dice 1 rolls: ");
		while(x.getNumRolls() < 10)
		{
			System.out.print(x.roll() + " ");
		}
		System.out.print("\nDice 2 rolls: ");
		while(y.getNumRolls() < 10)
		{
			System.out.print(y.roll() + " ");
		}
		
		System.out.println("\n\nDice 1 was rolled " + x.getNumRolls() + " times.");
		System.out.println("Dice 2 was rolled " + y.getNumRolls() + " times.");
		
		x.reset();
		
		System.out.println("\nRESET:\nDice 1 was rolled " + x.getNumRolls() + " times.");
		System.out.println("Dice 2 was rolled " + y.getNumRolls() + " times.");
	}

}
