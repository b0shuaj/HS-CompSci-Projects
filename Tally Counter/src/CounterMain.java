/**
 * 
 * @author Josh Babbitt
 * Counter Main
 *
 */
public class CounterMain 
{
	public static void main(String[] args)
	{
		Counter counter = new Counter();
		
		System.out.println(counter.get_count());
		counter.click();
		counter.click();
		System.out.println(counter.get_count());
	}
}
