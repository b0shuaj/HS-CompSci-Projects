import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GettysburgAddress 
{
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();
		Scanner read = null;
		File myFile = new File("GettysburgAddress.txt");
		try {
			read = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while(read.hasNext())
		{
			String str = read.next();
			int start = -1;
			for(int i = 0; i < str.length(); i++)
			{
				
				if(str.charAt(i) == ',' || str.charAt(i) == '.' || str.charAt(i) == '-')
				{
					if(start != -1)
					{
						list.add(str.substring(start, i));
						start = -1;
					}
				}
				else
				{
					if(start == -1)
					{
						start = i;
					}
				}
			}
		}
		
		
		String longest = " ";
		for(String a : list)
		{
			if(a.length() > longest.length())
			{
				longest = a;
			}
		}
		System.out.println(longest);
		
		
		
		int sum = 0;
		int count = 0;
		for(int i = 0; i < list.size(); i++)
		{
			sum += list.get(i).length();
			count++;
		}
		
		System.out.println((sum*1.0/count));
		
		

	}
}
