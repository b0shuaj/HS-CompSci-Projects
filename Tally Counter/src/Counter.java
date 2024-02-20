/**
 * 
 * @author Josh
 * Tally Counter
 *
 */
public class Counter 
{
	//Fields (Instance Variables)
	
	private int count;
	
	//Constructors (to initialize instance variables)
	
	public Counter()
	{
		count = 0;
	}
	
	//Methods
	
	public void click()
	{
		count++;
	}
	public int get_count()
	{
		return count;
	}
}
