import java.util.Scanner;

/**
 * 
 * @author Josh Babbitt
 * Project String Reverse
 *
 */
public class StringReverse 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Input a String: ");
		String str = in.nextLine();
		System.out.println("");
		
		for(int i = str.length() -1; i>=0; i--)
		{
			System.out.print(str.charAt(i));
		}
		
		in.close();
	}

}
