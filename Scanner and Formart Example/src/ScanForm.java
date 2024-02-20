import java.util.Scanner;

public class ScanForm 
{
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a decimal number: ");
		double num = keyboard.nextDouble();
		System.out.println("You entered " + num);
		
		System.out.printf("No really, you've entered %.2f",num);
		
		keyboard.close();
	}
}
