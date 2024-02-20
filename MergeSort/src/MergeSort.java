import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args)
	{
		int[] start = new int[100];
		for(int i = 0; i < start.length; i++)
		{
			start[i] = (int)(Math.random()*20 + 1);
		}
		int[] sorted = Arrays.copyOf(start,start.length);
		Arrays.sort(sorted);
		mergesort(start);
		if(Arrays.equals(start, sorted))
			System.out.print("correctly sorted");
		else
			System.out.print("not properly sorted");
		
	}
	
	/*
	 * implement the mergesort method.  It should be a recursive
	 * implementation of the mergesort algorithm we spoke about
	 * in class.  If you run this main method it will tell you 
	 * if your algorithm properly sorted the array.  You do not 
	 * need to add any code to the main method.
	 */
	
	public static void mergesort(int[] arr)
	{

		
		if(arr.length > 1)
		{
			int mid = arr.length/2;
			
			int[] farr = new int[mid];
			int[] sarr = new int[arr.length - mid];
			
			for(int i = 0; i < mid; i++)
			{
				farr[i] = arr[i];
			}
			for(int i = mid; i < arr.length; i++)
			{
				sarr[i-mid] = arr[i];
			}
			
			
			mergesort(farr);
			mergesort(sarr);
			
			int hi = 0;
			int mr = 0;
			int ellis = 0;
			
			while(hi < farr.length && mr < sarr.length)
			{
				if(farr[hi] < sarr[mr])
				{
					arr[ellis] = farr[hi];
					hi++;
				}
				else
				{
					arr[ellis] = sarr[mr];
					mr++;
				}
				ellis++;
			}
			while(hi < farr.length)
			{
				arr[ellis] = farr[hi];
				hi++;
				ellis++;
			}
			while(mr < sarr.length)
			{
				arr[ellis] = sarr[mr];
				mr++;
				ellis++;
			}
			
		}
	}

}
