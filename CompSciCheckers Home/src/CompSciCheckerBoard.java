	/*
	 * A CompSciCheckerBoard represents a playing board for a 
	 * CompSciChecker game.  In this game a board is 8x8 and starts 
	 * with black and white CompSciChecker pieces.  The fields
	 * numWhitePieces and numBlackPieces track the appropriate 
	 * number of pieces for either side.  There are 12 white 
	 * pieces starting at the top left square and fill every other space
	 * on the board for the first three rows.  No two white pieces 
	 * should be directly adjacent to start.  The same is true of the
	 * 12 black pieces but they start at the bottom right and fill the
	 * bottom three rows.  the pieces may move one place in any
	 * direction, forwards, backwards, left, right or diagonal.  The
	 * pieces may "jump" an opposing player in any direction as well.
	 * 
	 */
public class CompSciCheckerBoard 
{
	
	private CompSciChecker[][] board;
	private int numWhitePieces;
	private int numBlackPieces;
	
	/*
	 * Create a Constructor for the CompSciCheckerBoard
	 * Once created the board should look like this:
	 * 
	 *  _ _ _ _ _ _ _ _
	 * |W   W   W   W  |
	 * |  W   W   W   W|
	 * |W   W   W   W  |
	 * |               |
	 * |               |
	 * |  B   B   B   B|
	 * |B   B   B   B  |
	 * |_ B _ B _ B _ B|
	 * 
	 * Empty Spaces have a value of null
	 * 
	 * 
	 */
	
	public CompSciCheckerBoard()
	{
		//TODO PART A GitterDone!
		String black = "Black";
		String white = "White";
		
		CompSciChecker black1 = new CompSciChecker(black, 2, 1);
			board[2][1] = black1;
		CompSciChecker black2 = new CompSciChecker(black, 4, 1);
			board[4][1] = black2;
		CompSciChecker black3 = new CompSciChecker(black, 6, 1);
			board[6][1] = black3;
		CompSciChecker black4 = new CompSciChecker(black, 8, 1);
			board[8][1] = black4;
		CompSciChecker black5 = new CompSciChecker(black, 1, 2);
			board[1][2] = black5;
		CompSciChecker black6 = new CompSciChecker(black,3, 2);
			board[3][2] = black6;
		CompSciChecker black7 = new CompSciChecker(black,5, 2);
			board[5][2] = black7;
		CompSciChecker black8 = new CompSciChecker(black, 7, 2);
			board[7][2] = black8;
		CompSciChecker black9 = new CompSciChecker(black, 2, 3);
			board[2][3] = black9;
		CompSciChecker black10 = new CompSciChecker(black, 4, 3);
			board[4][3] = black10;
		CompSciChecker black11 = new CompSciChecker(black, 6, 3);
			board[6][3] = black11;
		CompSciChecker black12 = new CompSciChecker(black, 8,3);
			board[8][3] = black12;
		
		
		
		CompSciChecker white1 = new CompSciChecker(white, 1, 8);
			board[1][8] = white1;
		CompSciChecker white2 = new CompSciChecker(white, 3, 8);
			board[3][8] = white2;
		CompSciChecker white3 = new CompSciChecker(white, 5, 8);
			board[5][8] = white3;
		CompSciChecker white4 = new CompSciChecker(white, 7, 8);
			board[7][8] = white4;
		CompSciChecker white5 = new CompSciChecker(white, 2, 7);
			board[2][7] = white5;
		CompSciChecker white6 = new CompSciChecker(white, 4, 7);
			board[4][7] = white6;
		CompSciChecker white7 = new CompSciChecker(white, 6, 7);
			board[6][7] = white7;
		CompSciChecker white8 = new CompSciChecker(white, 8, 7);
			board[8][7] = white8;
		CompSciChecker white9 = new CompSciChecker(white, 1, 6);
			board[1][6] = white9;
		CompSciChecker white10 = new CompSciChecker(white, 3, 6);
			board[3][6] = white10;
		CompSciChecker white11 = new CompSciChecker(white, 5, 6);
			board[5][6] = white11;
		CompSciChecker white12 = new CompSciChecker(white, 7, 6);
			board[7][6] = white12;
		
		//Null spaces in the first three rows (black territory)
		for(int i = 1; i <= 3; i++)
		{
			if(i == 1 || i == 3)
			{
				for(int j = 1; j <= 8; j+=2)
				{
					board[j][i] = null;
				}
			}
			if(i == 2)
			{
				for(int k = 2; k <=8 ; k+=2)
				{
					board[k][i] = null;
				}
			}
		}
		
		//null spaces in the middle (no man's land)
		for(int i = 4; i <= 5; i++)
		{
			for(int j = 1; j <= 8; j++)
			{
				board[j][i] = null;
			}
		}
		
		
		//null spaces in white territory
		
		for(int i = 6; i <= 8; i++)
		{
			if(i == 6 || i == 8)
			{
				for(int j = 2; j <=8;  j+=2)
				{
					board[j][i] = null;
				}
			}
			if(i == 7)
			{
				for(int k = 1; k <= 8; k+=2)
				{
					board[k][i] = null;
				}
			}
		}
		
		
		
	}
	
	
	
	/*
	 * Next you will write the method isValidMove which will
	 * take a CompSciChecker piece and a new x and y value
	 * and determine if the move to the new space is legal.
	 * 
	 * A CompSciChecker piece can move one space in any direction
	 * including diagonally, so long as the space is not occupied.
	 * 
	 * A CompSciChecker piece can move two spaces in any direction
	 * ONLY IF there is an opposing piece being "jumped" and the new
	 * space is not occupied.
	 * 
	 * write the method isValidMove.  return true if the desired move
	 * is valid and false if it is not.
	 */
	
	public boolean isValidMove(CompSciChecker piece, int newX, int newY)
	{
		//IF THE PIECE IS NOT TRYING TO JUMP
		if(Math.abs(newX) == 1 || Math.abs(newY) == 1)
		{
		if(piece.getColor() == "Black")
		{
			if(board[newX][newY] == null)
			{
				return true;
			}
			else
			{
				if(board[newX][newY].getColor() == "Black")
				{
					return false;
				}
			}
		}
		if(piece.getColor() == "White")
		{
			if(board[newX][newY] == null)
			{
				return true;
			}
			else
			{
				if(board[newX][newY].getColor() == "White")
				{
					return false;
				}
			}
		}
		}
		else
		{
			return false;
		}
		
		if(Math.abs(newX) == 2 || Math.abs(newY) == 2)
		{
			if(piece.getColor() == "Black")
			{
				
			}
		}
		
		
		return false;
	}
	
	
	/*
	 * Finally you will write the method makeMove.  This method will
	 * take a CompSciChecker piece and a new x and y as arguments.  
	 * move the desired piece ONLY IF the move is valid.  If an opposing
	 * piece is "jumped" remove it from the board and update the
	 * appropriate field.
	 * 
	 */
	
	public void makeMove(CompSciChecker piece, int x, int y)
	{
		//TODO PART C Gitterdone!!!
	}
	
	
	


	
	/**
	 * 
	 * @param x x coordinate of board
	 * @param y y coordinate of board
	 * @return the piece at (x,y) or null if no piece
	 *         is located at (x,y)
	 */
	public CompSciChecker getPiece(int x, int y)
	{
		return board[y][x];
	}
	
	/**
	 * 
	 * @return the field board
	 */
	public CompSciChecker[][] getBoard()
	{
		return board;
	}
	
	
	/**
	 * returns a string representation of the board
	 */
	public String toString()
	{
		String str = "  _ _ _ _ _ _ _ _\n";
		for(int i = 0; i<board.length; i++)
		{
			str+= i + "|";
			for(int j = 0; j<board[i].length; j++)
			{
				if(board[i][j] != null)
					str+=board[i][j].getColor();
				else
				{
					if(i<board.length-1) str+=" ";
					else str+= "_";
				}
				if(j<board[i].length-1) str+= " ";
			}
			str+="|\n";
		}
		str+= "  0 1 2 3 4 5 6 7\n";
		return str;
	}
	
	
	
	
	

}
