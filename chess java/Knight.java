package il.co.chessgame;

public class Knight  extends Piece
{

	public Knight(String pieceName, String pieceColor) 
	{
		super(pieceName, pieceColor);
	}

	@Override
	boolean isValidMove(int xFrom, int yFrom, int xTo, int yTo, Board b) {

		if(isNotFriend(xFrom, yFrom, xTo, yTo, b)){

			// up and right  // up and left
			if((xFrom- 2 ==xTo && yFrom+1 == yTo) ||(xFrom- 2 ==xTo && yFrom-1 == yTo))
				return true;
			// down and right  // down and left
			else if( (xFrom+ 2 ==xTo && yFrom+1 == yTo) ||(xFrom+2 ==xTo && yFrom-1 == yTo))
				return true;
			//down and right   //up and right
			else if((xFrom+1==xTo && yFrom+2==yTo) || (xFrom-1==xTo && yFrom+2==yTo))
				return true;
			//down and left   //up and left
			else if((xFrom+1==xTo && yFrom-2==yTo) || (xFrom-1==xTo && yFrom-2==yTo))
				return true;

		}

		return false;






		/*
		if( (  (Math.abs(xFrom - xTo) + Math.abs(yFrom - yTo) == 3) && ( Math.abs(yFrom - yTo) ==1  || Math.abs(xFrom - xTo)==1 ) ))
				return true;
		else
			return false;
		 */
	}


}
