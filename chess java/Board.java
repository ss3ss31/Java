package il.co.chessgame;

public class Board 
{	

	Piece [][] myBoard = new Piece[8][8];


	public void initBoard()
	{
		//Up Lines!
		//White line 1
		myBoard[0][0]=new Rook("R","W");
		myBoard[0][7]=new Rook("R","W");

		myBoard[0][2]=new Knight("N","W");
		myBoard[0][5]=new Knight("N","W");

		myBoard[0][1]=new Bishop("B","W");
		myBoard[0][6]=new Bishop("B","W");

		myBoard[0][4]=new Queen("Q","W");

		myBoard[0][3]= new King("K","W");

		//White line 2
		myBoard[1][0]=new Pawn("P","W");
		myBoard[1][1] = new Pawn("P", "W");
		myBoard[1][2]=new Pawn("P","W");
		myBoard[1][3] = new Pawn("P", "W");
		myBoard[1][4]=new Pawn("P","W");
		myBoard[1][5] = new Pawn("P", "W");
		myBoard[1][6]=new Pawn("P","W");
		myBoard[1][7] = new Pawn("P", "W");


		//Down Lines!
		//Black line 1
		myBoard[7][0]=new Rook("R","B");
		myBoard[7][7]=new Rook("R","B");

		myBoard[7][2]=new Knight("N","B");
		myBoard[7][5]=new Knight("N","B");

		myBoard[7][1]=new Bishop("B","B");
		myBoard[7][6]=new Bishop("B","B");

		myBoard[7][4]=new Queen("Q","B");

		myBoard[7][3]= new King("K","B");

		//Black line 2

		myBoard[6][0] = new Pawn("P", "B");
		myBoard[6][1]=new Pawn("P", "B");
		myBoard[6][2] = new Pawn("P", "B");
		myBoard[6][3]=new Pawn("P", "B");
		myBoard[6][4] = new Pawn("P", "B");
		myBoard[6][5]=new Pawn("P", "B");
		myBoard[6][6] = new Pawn("P", "B");
		myBoard[6][7]= new Pawn("P", "B");


		///TODO----
	}

	public void printBoard()
	{
		System.out.println("     a    b    c    d    e    f    g    h");
		System.out.println("  ========================================");


		for(int i=0;i<myBoard.length;i++)
		{

			System.out.print((i+1)+" |");

			for(int j=0;j<myBoard[i].length;j++)
			{
				if(myBoard[i][j] !=null )
					System.out.print(myBoard[i][j].toString()+"|");
				else
					System.out.print("    |");

			}
			System.out.println(" "+(i+1));
		}


		System.out.println("  ========================================");
		System.out.println("     a    b    c    d    e    f    g    h");


	}





	public void movePiece(int xFrom, int yFrom, int xTo, int yTo, boolean isWhite) {
		
		myBoard[yTo][xTo] = myBoard[yFrom][xFrom];
		myBoard[yTo][xTo].firstTurn=false;
		myBoard[yFrom][xFrom] = null;

		for(int i=0;i<myBoard.length;i++)
		{
			for(int j=0;j<myBoard.length;j++)
			{
				if(myBoard[i][j]!=null && myBoard[i][j].pieceName=="K" &&((isWhite && myBoard[i][j].pieceColor=="B")||(!isWhite && myBoard[i][j].pieceColor=="W")) )
					if( myBoard[yTo][xTo].isValidMove(xTo, yTo, i, j, this))
					{
						System.out.println("Chess!");
					}
			}
				
		}

	}

}