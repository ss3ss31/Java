package il.co.chessgame;

public class Rook extends Piece
{
	public Rook(String pieceName, String pieceColor) 
	{
		super(pieceName, pieceColor);
	}

	boolean isValidMove(int xFrom, int yFrom, int xTo, int yTo, Board b)
	{		

		if(isNotFriend(xFrom, yFrom, xTo, yTo, b)){

			//  left 
			if(xFrom==xTo && yFrom < yTo){

				int steps = yTo - yFrom - 1;

				for(int i = steps; i > 0 ;i-- ){
					if(b.myBoard[xFrom][yFrom+i] != null)
						return false;
				}

				return true;
				//Right
			}else if(xFrom==xTo && yFrom > yTo){

				int steps = yFrom - yTo - 1;

				for(int i = steps; i > 0 ;i-- ){
					if(b.myBoard[xFrom][yFrom-i] != null)
						return false;
				}
				return true;
				//	up
			}else if(yFrom==yTo && xFrom > xTo){

				int steps = xFrom - xTo - 1;

				for(int i = steps; i > 0 ;i-- ){
					if(b.myBoard[xFrom-i][yFrom] != null)
						return false;
				}
				return true;
				// down	
			}else if(yFrom==yTo && xFrom < xTo){

				int steps = xTo - xFrom - 1;

				for(int i = steps; i > 0 ;i-- ){
					if(b.myBoard[xFrom+i][yFrom] != null)
						return false;
				}
				return true;

				// default	
			}else
				return false;
		}else
			return false;
	}

}
