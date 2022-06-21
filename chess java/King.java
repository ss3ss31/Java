package il.co.chessgame;

public class King extends Piece
{

	public King(String pieceName, String pieceColor) 
	{
		super(pieceName, pieceColor);
	}

	boolean isValidMove(int xFrom, int yFrom, int xTo, int yTo, Board b)
	{
		//up 				// down
		if((xFrom+1==xTo && yFrom==yTo)||(xFrom-1==xTo && yFrom==yTo))
			return true;
		//left				// right
		else if((xFrom==xTo && yFrom+1==yTo)||(xFrom==xTo && yFrom-1==yTo))
			return true;
		//Up and right      //down and left
		else if((xFrom+1==xTo && yFrom+1==yTo)||(xFrom-1==xTo &&yFrom-1==yTo))
			return true;
		//down and right  	//up and left
		else if((xFrom-1==xTo && yFrom+1==yTo)||(xFrom+1==xTo &&yFrom-1==yTo))
			return true;
		return false;
	}
	
	public boolean isCastling(boolean firstTurnKing,boolean firstTurnRook , Board board,int xFrom,int yFrom,int xTo,int yTo)
	{
		if(board.myBoard[yFrom][xFrom].pieceColor!=board.myBoard[yTo][xTo].pieceColor)
			return false;
		if(board.myBoard[yTo][xTo].pieceName!="R")
			return false;
		
		if(!firstTurnKing || !firstTurnRook)
			return false;
		
			if(xFrom>xTo)
			{
				for(int i=xFrom-1;i>xTo;i--)
				{
					if(board.myBoard[yFrom][i]!=null)
						return false;
				}
			}
			else
			{
				for(int i=xFrom+1;i<xTo;i++)
				{
					if(board.myBoard[yFrom][i]!=null)
						return false;
				}
			}
		return true;
	}
	/*
	
	boolean isDanger()
	{
		
	}
	*/
	
	/*
	@Override
	void movePiece(int xFrom,int yFrom,int xTo,int yTo) 
	{

	}
	 */

}
