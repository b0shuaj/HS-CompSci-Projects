
public class CheckerTest 
{

	public static void main(String[] args)
	{
		CompSciCheckerBoard gameboard = new CompSciCheckerBoard();
		
		CompSciChecker[][] board = null;
		try
		{
			board = gameboard.getBoard();
		}
		catch(Exception e)
		{
			System.out.print("getBoard() ERROR");
			System.exit(1);
		}
		
		System.out.print(gameboard);
		boolean boardSetup = true;
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<8; j++)
			{
				if(i%2 == j%2 && board[i][j] == null)
				{
					boardSetup = false;	
				}
				else if(i%2 != j%2 && board[i][j] != null)
				{
					boardSetup = false;	
				}
				else if(i%2 == j%2 && i<3 && !board[i][j].getColor().equals("W"))
				{
					boardSetup = false;
				}
				else if(i%2 == j%2 && i>4 && !board[i][j].getColor().equals("B"))
				{
					boardSetup = false;
				}
				else if(i%2 == j%2)
				{
					if(board[i][j].getX() != j || board[i][j].getY() != i)
						boardSetup = false;
				}
			}
		}
		
		if(!boardSetup)
		{
			System.out.println("CONSTRUCTOR FAIL");
			System.exit(1);
		}
		else
			System.out.println("CONSTRUCTOR PASS");
		
		
		CompSciChecker piece = gameboard.getPiece(2, 2);
		
		boolean validMove = true;
		
		if(!gameboard.isValidMove(piece, 2, 1))
		{
			validMove = false;
			System.out.println("q");
		}
		if(gameboard.isValidMove(piece, 2, 2))
		{
			validMove = false;
			System.out.println("w");
		}
		if(gameboard.isValidMove(piece, 2, 0))
		{
			validMove = false;
			System.out.println("e");
		}
		if(gameboard.isValidMove(piece, 4, 1))
		{
			validMove = false;
			System.out.println("r");
		}
		if(gameboard.isValidMove(piece, 0, 1))
		{
			validMove = false;
			System.out.println("t");
		}
		if(gameboard.isValidMove(piece, 1, 1))
		{
			validMove = false;
			System.out.println("y");
		}
		if(gameboard.isValidMove(piece, 3, 1))
		{
			validMove = false;
			System.out.println("u");
		}
		if(!gameboard.isValidMove(piece, 3, 2))
		{
			validMove = false;
			System.out.println("i");
		}
		if(gameboard.isValidMove(piece, 4, 0))
		{
			validMove = false;
			System.out.println("o");
		}
		
		CompSciChecker testPiece = new CompSciChecker("W",3,4);
		
		if(!gameboard.isValidMove(testPiece, 3, 6))
		{
			validMove = false;
			System.out.println("1");
		}
		testPiece.setX(0);
		if(gameboard.isValidMove(testPiece, -1, 6))
		{
			validMove = false;	
			System.out.println("2");
		}
		testPiece.setX(7);
		if(gameboard.isValidMove(testPiece,8,6))
		{
			validMove = false;
			System.out.println("3");
		}
		testPiece.setX(2);
		testPiece.setY(7);
		if(!gameboard.isValidMove(testPiece, 4, 7))
		{
			validMove = false;
			System.out.println("4");
		}
		if(!gameboard.isValidMove(testPiece, 0, 7))
		{
			validMove = false;
			System.out.println("5");
		}
		testPiece.setX(4);
		testPiece.setY(1);
		if(gameboard.isValidMove(testPiece, 2, 1))
		{
			validMove = false;
			System.out.println("6");
		}
		if(gameboard.isValidMove(testPiece, 4, 3))
		{
			validMove = false;
			System.out.println("7");
		}
		
		if(!validMove)
		{
			System.out.println("VALIDMOVE FAIL");
			//System.exit(1);
		}
		else
		{
			System.out.println("VALIDMOVE PASS");
		}
		
		
		testPiece.setX(4);
		testPiece.setY(7);
		
		
		boolean move = true;
		
		gameboard.makeMove(testPiece, 4, 5);
		if(testPiece.getX()!=4 || testPiece.getY() != 5)
		{
			move = false;
			System.out.println("q");
		}
		if(board[7][4]!=null)
		{
			move = false;
			System.out.println("w");
		}
		if(board[6][4] != null)
		{
			move = false;
			System.out.println("e");
		}
		gameboard.makeMove(testPiece, 5, 5);
		if(testPiece.getX()==5)
		{
			move = false;
			System.out.println("r");
		}
		testPiece.setX(2);
		testPiece.setY(5);
		gameboard.makeMove(testPiece, 4, 7);
		if(testPiece.getX()==4)
		{
			move = false;
			System.out.println("t");
		}
		if(testPiece.getY() == 7)
		{
			move = false;
			System.out.println("y");
		}
		
		if(!move)
			System.out.println("MAKEMOVE FAIL");
		else
			System.out.println("MAKEMOVE PASS");
		
	
	}

}
