
public class Ben10000Spammer
{
	public static void main(String[] args)
	{
		System.out.print("Ben 10? What about ");
		int count = 0;
		int bens = 1;
		
		while(count<9989)
		{
			if(bens == 10)
			{
				bens++;
			}
			else
			{
				System.out.print("Ben " + bens + " and " );
				count++;
				bens++;
			}
				
		}
	}
}
