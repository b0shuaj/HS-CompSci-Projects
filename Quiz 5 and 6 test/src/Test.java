import java.util.Scanner;

public class Test 
{
	public static void main(String[] args)
	{
//		int x;
//		int y;
//		Scanner in = new Scanner(System.in);
//		System.out.print("Please enter: ");
//		y = in.nextInt();
//		
//		if(y<300)
//		{
//			x=y;
//		}
//		else
//		{
//			x = 0;
//		}
//		System.out.print(x);
		
//		double income = 25;
//		double cutoff = 55;
//		double minIncome = 30;
//		
//		if(minIncome > income)
//		{
//			System.out.print("Min income requirement not met");
//		}
//		if(cutoff<income)
//		{
//			System.out.print("Max limit exceeded");
//		}
//		else
//		{
//			System.out.print("Income req not met");
//		}
		
		
//		int num = 100;
//		if(num<100)
//		{
//			if(num<50)
//			{
//				num = num-5;
//			}
//			else
//			{
//				num = num -10;
//			}
//		}
//		else
//		{
//			if(num>150)
//			{
//				num = num +5;
//			}
//			else
//			{
//				num = num+10;
//			}
//		}
//		System.out.println(num);
		
		
//		boolean attendance = false;
//		String str = "Unknown";
//		attendance = !(attendance);
//		if(!attendance)
//		{
//			str = "false";
//		}
//		if(attendance)
//		{
//			attendance = false;
//		}
//		if(attendance)
//		{
//			str = "True";
//		}
//		else
//		{
//			str = "maybe";
//		}
//		System.out.println(str);
		
		
		
//		
//		int i = 1;
//		while(i < 10)
//		{
//			System.out.print(i + " ");
//			i = i+2;
//			if(i == 5)
//			{
//				i = 9;
//			}
//		}
		
		
//		int i = 60;
//		int j = 50;
//		int count = 0;
//		while(count < 5)
//		{
//			i = i + i;
//			i = i + 1;
//			j = j-1;
//			j = j-j;
//			count++;
//		}
//		System.out.print(i + " " + j);
		
//		String str = "ABCabc";
//		char ch;
//		int i = 0;
//		while (i < str.length())
//		{
//			ch = str.charAt(i);
//			if(Character.isLowerCase(ch))
//			{
//				System.out.print(i + " ");
//			}
//			else
//			{
//				i++;
//			}
//		}
		
//		int f1 = 0;
//		int f2 = 1;
//		int fRes;
//		System.out.print(f1 + " ");
//		System.out.print(f2 + " ");
//		for(int i = 1; i <10; i++)
//		{
//			fRes = f1 + f2;
//			System.out.print(fRes + " ");
//			f1 = f2;
//			f2 = fRes;
//		}
//		System.out.println();
		
		int n1 = 120;
		int n2 = 90;
		int result = 1;
		
		for(int k = 1; k <= n1 && k<= n2; k++)
		{
			if(n1 % k == 0 && n2% k == 0)
			{
				result = k;
			}
		}
		System.out.print(result);
		
		
		
		
		
		
		
		
	}
}
