
public abstract class NumberCounter 
{
	private int number;
	
	public NumberCounter(int n)
	{
		number = n;
	}
	
	public void increment(int amt)
	{
		number+=amt;
	}
	
	public abstract void somethingSpecial(int amt);
}
