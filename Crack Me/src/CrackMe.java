/**
 * 
 * @author Josh Babbitt
 * Project Crack Me
 *
 */
public class CrackMe 
{
	private String numb;
	public CrackMe()
	{
		int num = (int)(Math.random()*900 + 100);
		numb = Integer.toString(num);
	}
	public boolean checkFirstDigit(String guess)
	{
		
		String checkFirst = guess.substring(0,1);
		String first = numb.substring(0,1);
		if(checkFirst.equals(first))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean checkSecondDigit(String guess)
		{
			
			String checkSecond = guess.substring(1,2);
			String second = numb.substring(1,2);
			if(checkSecond.equals(second))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		public boolean checkThirdDigit(String guess)
		{
			
			String checkThird = guess.substring(2,3);
			String third = numb.substring(2,3);
			if(checkThird.equals(third))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		public String toString()
		{
			return numb;
		}
	}
