
public class LetterCount 
{
	public static int letterCount(String in, char ch)
	{
		int loop = 0;
		int count = 0;
		while(loop != in.length())
		{
			if(in.charAt(loop) == ch)
			{
				count++;
			}
			loop++;
		}
		return count;
	}
	
	public static int vowelCount(String in)
	{
		int loop = 0;
		int count = 0;
		
		while(loop != in.length())
		{
			if(in.charAt(loop) == 'a' || in.charAt(loop) == 'e' ||in.charAt(loop) == 'i' ||in.charAt(loop) == 'o' ||in.charAt(loop) == 'u')
			{
				count++;
			}
			loop++;
		}
		return count;
	}
	
	public static void main(String[] args)
	{
		System.out.println(letterCount("I am so cool", 'o'));
		System.out.println(vowelCount("How many vowels?"));
	}
}
