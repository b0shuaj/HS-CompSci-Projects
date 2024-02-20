/**
 * 
 * @author Josh Babbitt
 * Project 2D Array Classwork
 * 
 */
public class Classwork
{
	public static void main(String[] args)
	{
		int num = (int)(Math.random()*51 + 50);
		int[] arr = new int[num];
		System.out.println(num);
		
		for(int i = 0; i<arr.length; i++)
		{
			arr[i] = (int)(Math.random()*100+1);
		}
		int row;
		if((num%7) != 0)
			row = (num/7) + 1;
		else
			row = num/7;
			
		int[][] arr2d = new int[row][7];
		
		for(int i = 0; i < arr2d.length; i++)
		{
			for(int j = 0; j < arr2d[i].length; j++)
			{
				if(i*7 + j < arr.length)
					arr2d[i][j] = arr[i*7 + j];
			}
		}
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + ", ");
		}
		for(int i = 0; i < arr2d.length; i++)
		{
			for(int j = 0; j < arr2d[i].length; j++)
			{
				System.out.print(arr2d[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
