/*
 * A CompSciCheckerBoard represents a playing board for a 
 * CompSciChecker game.  In this game a board is 8x8 and starts 
 * with black and white CompSciChecker pieces.  The fields
 * numWPieces and numBPieces track the appropriate 
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
public class CompSciCheckerBoard {

	private CompSciChecker[][] board;
	private int numWPieces;
	private int numBPieces;

	/*
	 * Create a Constructor for the CompSciCheckerBoard Once created the board
	 * should look like this:
	 * 
	 * _ _ _ _ _ _ _ _ |W W W W | | W W W W| |W W W W | | | | | | B B B B| |B B B B
	 * | |_ B _ B _ B _ B|
	 * 
	 * Empty Spaces have a value of null
	 * 
	 * 
	 */

	public CompSciCheckerBoard() {
		// TODO PART A GitterDone!
		board = new CompSciChecker[8][8];

		CompSciChecker black1 = new CompSciChecker("B", 1, 7);
		board[7][1] = black1;
		CompSciChecker black2 = new CompSciChecker("B", 3, 7);
		board[7][3] = black2;
		CompSciChecker black3 = new CompSciChecker("B", 5, 7);
		board[7][5] = black3;
		CompSciChecker black4 = new CompSciChecker("B", 7, 7);
		board[7][7] = black4;
		CompSciChecker black5 = new CompSciChecker("B", 0, 6);
		board[6][0] = black5;
		CompSciChecker black6 = new CompSciChecker("B", 2, 6);
		board[6][2] = black6;
		CompSciChecker black7 = new CompSciChecker("B", 4, 6);
		board[6][4] = black7;
		CompSciChecker black8 = new CompSciChecker("B", 6, 6);
		board[6][6] = black8;
		CompSciChecker black9 = new CompSciChecker("B", 1, 5);
		board[5][1] = black9;
		CompSciChecker black10 = new CompSciChecker("B", 3, 5);
		board[5][3] = black10;
		CompSciChecker black11 = new CompSciChecker("B", 5, 5);
		board[5][5] = black11;
		CompSciChecker black12 = new CompSciChecker("B", 7, 5);
		board[5][7] = black12;

		CompSciChecker white1 = new CompSciChecker("W", 0, 0);
		board[0][0] = white1;
		CompSciChecker white2 = new CompSciChecker("W", 2, 0);
		board[0][2] = white2;
		CompSciChecker white3 = new CompSciChecker("W", 4, 0);
		board[0][4] = white3;
		CompSciChecker white4 = new CompSciChecker("W", 6, 0);
		board[0][6] = white4;
		CompSciChecker white5 = new CompSciChecker("W", 1, 1);
		board[1][1] = white5;
		CompSciChecker white6 = new CompSciChecker("W", 3, 1);
		board[1][3] = white6;
		CompSciChecker white7 = new CompSciChecker("W", 5, 1);
		board[1][5] = white7;
		CompSciChecker white8 = new CompSciChecker("W", 7, 1);
		board[1][7] = white8;
		CompSciChecker white9 = new CompSciChecker("W", 0, 2);
		board[2][0] = white9;
		CompSciChecker white10 = new CompSciChecker("W", 2, 2);
		board[2][2] = white10;
		CompSciChecker white11 = new CompSciChecker("W", 4, 2);
		board[2][4] = white11;
		CompSciChecker white12 = new CompSciChecker("W", 6, 2);
		board[2][6] = white12;

		// Null spaces in the first three rows (black territory)
		for (int i = 7; i <= 5; i++) {
			if (i == 7 || i == 5) {
				for (int j = 0; j <= 7; j += 2) {
					board[i][j] = null;
				}
			}
			if (i == 6) {
				for (int k = 1; k <= 7; k += 2) {
					board[i][k] = null;
				}
			}
		}

		// null spaces in the middle (no man's land)
		for (int i = 3; i <= 4; i++) {
			for (int j = 0; j <= 7; j++) {
				board[i][j] = null;
			}
		}

		// null spaces in white territory

		for (int i = 0; i <= 2; i++) {
			if (i == 0 || i == 2) {
				for (int j = 1; j <= 7; j += 2) {
					board[i][j] = null;
				}
			}
			if (i == 1) {
				for (int k = 0; k <= 7; k += 2) {
					board[i][k] = null;
				}
			}
		}

	}

	/*
	 * Next you will write the method isValidMove which will take a CompSciChecker
	 * piece and a new x and y value and determine if the move to the new space is
	 * legal.
	 * 
	 * A CompSciChecker piece can move one space in any direction including
	 * diagonally, so long as the space is not occupied.
	 * 
	 * A CompSciChecker piece can move two spaces in any direction ONLY IF there is
	 * an opposing piece being "jumped" and the new space is not occupied.
	 * 
	 * write the method isValidMove. return true if the desired move is valid and
	 * false if it is not.
	 */

	public boolean isValidMove(CompSciChecker piece, int newX, int newY) {
		int currentX = piece.getX();
		int currentY = piece.getY();

		// IF THE PIECE IS NOT TRYING TO JUMP
		if (piece != null) {
			if ((newX < 8 && newX >= 0) && (newY < 8 && newY >= 0)) {
				if (board[newY][newX] == null) {
					if ((Math.abs(currentX - newX) <= 2) && (Math.abs(currentY - newY) <= 2)
							&& (Math.abs(currentY - newY) != 0 || Math.abs(currentX - newX) != 0)) {
						// Left or Right
						if (Math.abs(newY - currentY) == 0) {
							// right
							if (newX > currentX) {
								if (Math.abs(currentX - newX) == 1) {
									return true;
								} else {
									if (board[currentY][currentX + 1] != null) {
										if (board[currentY][currentX + 1].getColor() != piece.getColor())
											return true;
									}
								}
							}
							// left
							if (newX < currentX) {
								if (Math.abs(currentX - newX) == 1) {
									return true;
								} else {
									if (board[currentY][currentX - 1] != null) {
										if (board[currentY][currentX - 1].getColor() != piece.getColor())
											return true;
									}
								}
							}
						}
						// Up or Down
						if (Math.abs(newX - currentX) == 0) {
							// Down
							if (newY > currentY) {
								if (Math.abs(currentY - newY) == 1) {
									return true;
								} else {
									if (board[currentY + 1][currentX] != null) {
										if (board[currentY + 1][currentX].getColor() != piece.getColor())
											return true;
									}
								}
							}
							// Up
							if (newY < currentY) {
								if (Math.abs(currentY - newY) == 1) {
									return true;
								} else {
									if (board[currentY - 1][currentX] != null) {
										if (board[currentY - 1][currentX].getColor() != piece.getColor())
											return true;
									}
								}
							}
						}
						// Diagonal
						if (Math.abs(newX - currentX) == 2 && Math.abs(newY - currentY) == 2) {
							if (Math.abs(currentX - newX) == 1 || Math.abs(currentY - newY) == 1) {
								return true;
							} else {
								if (board[currentY + ((newY - currentY) / 2)][currentX
										+ ((newX - currentX) / 2)] != null) {
									if (board[currentY + ((newY - currentY) / 2)][currentX + ((newX - currentX) / 2)]
											.getColor() != piece.getColor())
										return true;
								}
							}
						}
					}
				}
			}
		}

		return false;
	}

	/*
	 * Finally you will write the method makeMove. This method will take a
	 * CompSciChecker piece and a new x and y as arguments. move the desired piece
	 * ONLY IF the move is valid. If an opposing piece is "jumped" remove it from
	 * the board and update the appropriate field.
	 * 
	 */

	public void makeMove(CompSciChecker piece, int x, int y) {
		if (isValidMove(piece, x, y)) {
			int currentX = piece.getX();
			int currentY = piece.getY();
			int newX = x;
			int newY = y;
			board[newY][newX] = piece;
			piece.setX(newX);
			piece.setY(newY);

			if((Math.abs(newX-currentX)==2 || Math.abs(newX-currentX) == 0) && (Math.abs(newY-currentY)==2 || Math.abs(newY-currentY) == 0))
				{
				  board[currentY+(newY-currentY)/2][currentX+(newX-currentX)/2] = null;
				  
				}
		}

	}

	/**
	 * 
	 * @param x x coordinate of board
	 * @param y y coordinate of board
	 * @return the piece at (x,y) or null if no piece is located at (x,y)
	 */
	public CompSciChecker getPiece(int x, int y) {
		return board[y][x];
	}

	/**
	 * 
	 * @return the field board
	 */
	public CompSciChecker[][] getBoard() {
		return board;
	}

	/**
	 * returns a string representation of the board
	 */
	public String toString() {
		String str = "  _ _ _ _ _ _ _ _\n";
		for (int i = 0; i < board.length; i++) {
			str += i + "|";
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != null)
					str += board[i][j].getColor();
				else {
					if (i < board.length - 1)
						str += " ";
					else
						str += "_";
				}
				if (j < board[i].length - 1)
					str += " ";
			}
			str += "|\n";
		}
		str += "  0 1 2 3 4 5 6 7\n";
		return str;
	}

}
