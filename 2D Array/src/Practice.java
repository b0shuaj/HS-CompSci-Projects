
public class Practice 
{
	public static void main(String[] args)
	{
		//int[][] values = new int [rows][columns];
		int[][] values = new int[6][3];
		// String[][] data;
		//data.length = number of rows
		//data[0].length = number of columns
		System.out.println(values.length + ", " + values[0].length);
		
		int[][]arr2d = new int[4][6];
		for(int i = 0; i < arr2d.length; i++)
		{
			for(int j = 0; j < arr2d[i].length; j++)
			{
				arr2d[i][j] = 10*i + j;
			}
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
