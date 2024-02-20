
public class Test 
{
	public static String goAgain(String str, int index)
	{	
		if(index >=str.length())
			return str;
		return str + goAgain(str.substring(index), index + 1);
	}
	public static void main(String[] args)
	{
		
		
		String[][] letters = {{"A", "B", "C", "D"}, {"E", "F", "G", "H"},{ "I", "J", "K", "L"}};
		for(int col = 1; col < letters[0].length; col++)
		{
			for(int row = 1; row < letters.length; row++)
			{
				System.out.print(letters[col][row] + " ");
			}
			System.out.println();
		}
	}
}
