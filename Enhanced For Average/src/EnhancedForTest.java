
public class EnhancedForTest
{
	private static double findAverage(int[] arr)
	{
		double sum = 0.0;
		int index = 0;
		for(int a : arr)
		{
			sum+=a;
			index++;
		}
		return (sum/index);
	}
	private static int findMinVal(int[] arr)
	{
		int min = arr[0];
		for(int a : arr)
		{
			if(min > a)
			{
				min = a;
			}
		}
		return min;
	}
	public static void main(String[] args)
	{
		int[] arr = new int[20];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = (int)((Math.random()*100) + 1);
		}
		int sum = 0;
		for(int a : arr)
		{
			System.out.print(a + ", ");
			sum+=a;
		}
		System.out.println("\n\nThe Minimum Value is: " + findMinVal(arr));
		System.out.println("\nThe Average is: " + findAverage(arr));
	}
}
