import java.util.Scanner;
/**
 * 
 * @author Josh Babbitt
 * Project Phone Number
 *
 */
public class PhoneNumber 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter your name: ");
		String name = in.nextLine();
		
		String num = "0";
		while(num.length()!=10)
		{
			System.out.print("\nPlease enter your phoen number in the pattern of xxxxxxxxxx: \n");
			num = in.nextLine();
		}
		String first = num.substring(0,3);
		String second = num.substring(3,6);
		String third = num.substring(6,10);
		
		String wholeNum = "(" + first + ")-" + second + "-" + third;
		
		System.out.printf(name + "%20s",wholeNum);
		
		in.close();
	}
}