
public class APNumberCounter extends NumberCounter
{
	private int num;
	public APNumberCounter(int n) 
	{
		super(n);
		num = n;
	}

	public void increment(int amt)
	{
		if(amt < 0)
		{
			amt = Math.abs(amt);
		}
		
		amt += num;
	}


	public void somethingSpecial(int amt) 
	{
		amt = amt * 3;
		amt+= num;
	}
	
	
}
