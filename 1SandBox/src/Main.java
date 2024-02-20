
public class Main {
	public static void main(String[] args)
	{
	 String[][] board= new String[5][5];
	 
	 for(int row = 0; row < 5; row++)
	 {
		 for(int col = 0; col < 5; col++)
		 {
			 board[row][col] = "O";
		 }
	 }
	 for(int i = 0; i < 5; i++)
	 {
		 if(i % 2 == 1)
		 {
			 int row = i;
			 int col = 0;
			 while(col < 5 && row >= 0)
			 {
				 board[row][col] = "X";
				 col++;
				 row--;
			 }
		 }
	 }
	 System.out.println(board);
	}

}
