package il.co.chessgame;

public class Pawn extends Piece
{
	boolean firstMove=true;
	public Pawn(String pieceName, String pieceColor) 
	{
		super(pieceName, pieceColor);
	}

	boolean isValidMove(int xFrom, int yFrom, int xTo, int yTo, Board b)
	{

		if(pieceColor.equals("W"))
		{
			if(yTo==7 && yFrom + 1 == yTo)
			{
				if(pawnOneStepIsGood(b.myBoard[yFrom][xFrom].pieceColor, xFrom, yFrom, xTo, yTo, b))
				{
					switchPiece(yFrom,xFrom,b);
					return true;
				}
			}
			else if(yFrom + 1 == yTo)
			{
				return pawnOneStepIsGood(b.myBoard[yFrom][xFrom].pieceColor, xFrom, yFrom, xTo, yTo, b);
			}
			else if(firstMove && yFrom+2==yTo && xFrom==xTo)
			{
				firstMove=false;
				return true;
			}

		}
		else if(pieceColor.equals("B"))
		{
			if(yTo==0 && yFrom - 1 == yTo)
			{
				if(pawnOneStepIsGood(b.myBoard[yFrom][xFrom].pieceColor, xFrom, yFrom, xTo, yTo, b))
				{
					switchPiece(yFrom,xFrom,b);
					return true;
				}
			}
			else if(yFrom - 1 == yTo)
			{
				return pawnOneStepIsGood(b.myBoard[yFrom][xFrom].pieceColor, xFrom, yFrom, xTo, yTo, b);
			}
			else if(firstMove && yFrom-2==yTo && xFrom==xTo)
			{
				firstMove=false;
				return true;
			}

		}
		return false;
	}

	private void switchPiece(int yFrom, int xFrom, Board b) {
		System.out.println("Congratulation!!!\n Your pawn get to his final step write your new piece");
		String x;
		boolean valid=false;
		while(!valid)
		{
			System.out.println("Q-Queen \nN-Knight \nR-Rook \nB-Bishop");
			x=InputUtility.input();

			switch(x)
			{
			case "Q": case "q": b.myBoard[yFrom][xFrom]=new Queen("Q",b.myBoard[yFrom][xFrom].pieceColor);
			valid=true;
			break;
			case "N": case "n": b.myBoard[yFrom][xFrom]=new Knight("N",b.myBoard[yFrom][xFrom].pieceColor);
			valid=true;
			break;
			case "R": case "r": b.myBoard[yFrom][xFrom]=new Rook("R",b.myBoard[yFrom][xFrom].pieceColor);
			valid=true;
			break;
			case "B": case "b": b.myBoard[yFrom][xFrom]=new Bishop("B",b.myBoard[yFrom][xFrom].pieceColor);
			valid=true;
			break;
			default:System.out.println("Try Again...");

			}
		}
	}

	private boolean pawnOneStepIsGood(String color,int xFrom, int yFrom, int xTo, int yTo, Board b) {

		if(xFrom == xTo && b.myBoard[yTo][xTo]==null)
			return true;			
		else if((xFrom+1==xTo || xFrom-1==xTo) && b.myBoard[yFrom][xFrom].pieceColor.equals(color))
			return true;
		return false;
	}



	/*
	@Override
	void movePiece(int xFrom,int yFrom,int xTo,int yTo) {

	//	boolean isFirstMove=true;
		//isValidMove();

	}
	 */
}