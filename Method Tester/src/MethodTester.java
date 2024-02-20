/**
 * 
 * @author Josh Babbitt
 * Project Method Tester
 *
 */
public class MethodTester 
{

	public static void main(String[] args) 
	{
		
		String myString = "Run some methods on this jawn";
		
		//1. write  code which will return the character at index 5 and 
		//  store it in a variable.  display the value of the variable in the console
			char ch = myString.charAt(5);
			System.out.println(ch);
		//2. write code which will return the length of the string and store it in a 
		//   variable.   Display the content of the variable in the console.
			int length = myString.length();
			System.out.println("\n" + length);
		//3. write code which will return the word 'some' and store it in a variable 
		//     you must use a method on myString to generate the word, you may not type 'some'
			String some = myString.substring(4,8);
			System.out.println("\n" + some);
		//4. write code which will display the string in myString with all char 'o' 
		//      replaced with '*'
			String replace = myString.replace("o","*");
			System.out.println("\n" + replace);
		//write a line of code which will return and print the index of the letter m in the 
		//      given string, myString
			int firstM = myString.indexOf("m");
			int lastM = myString.lastIndexOf("m");
			System.out.println("\nFirst M is at " + firstM + "\t\tLast M is at " + lastM);
	}

}
