public class Xander
{
	public static boolean SXSTFU()
	{
		double random;
		random = Math.random()*2+1;
		if(random == 1)
		{
			return true;
		}
		if(random == 2)
		{
			return false;
		}
		return true;
		
		
	}
	public static void main(String[] args)
	{
		System.out.println("Should Xander Shut The Fuck Up?? " + SXSTFU());
	}
}
