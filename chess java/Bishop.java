package il.co.chessgame;


public class Bishop extends Piece
{

	public Bishop(String pieceName, String pieceColor) 
	{
		super(pieceName, pieceColor);
	}
	boolean isValidMove(int xFrom, int yFrom, int xTo, int yTo, Board b)
	{
		//down and right
		if((xFrom+1==xTo && yFrom+1==yTo)||(xFrom+2==xTo && yFrom+2==yTo)||(xFrom+3==xTo && yFrom+3==yTo)||(xFrom+4==xTo && yFrom+4==yTo))
			return true;
		//up and left
		else if((xFrom-1==xTo && yFrom-1==yTo)||(xFrom-2==xTo && yFrom-2==yTo)||(xFrom-3==xTo && yFrom-3==yTo)||(xFrom-4==xTo && yFrom-4==yTo))
			return true;
		//up and right
		else if((xFrom-1==xTo && yFrom+1==yTo)||(xFrom-2==xTo && yFrom+2==yTo)||(xFrom-3==xTo && yFrom+3==yTo)||(xFrom-4==xTo && yFrom+4==yTo))
			return true;
		//down and left
		else if((xFrom+1==xTo && yFrom-1==yTo)||(xFrom+2==xTo && yFrom-2==yTo)||(xFrom+3==xTo && yFrom-3==yTo)||(xFrom+4==xTo && yFrom-4==yTo))
			return true;		
		return false;
	}
}