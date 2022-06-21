package il.co.chessgame;

abstract public class Piece 
{

	public String pieceName;
	public String pieceColor;
	public boolean firstTurn=true;
	public Piece(String pieceName, String pieceColor) 
	{
		super();
		this.pieceName = pieceName;
		this.pieceColor = pieceColor;
	}

	@Override
	public String toString() {
		return pieceName + "\'" + pieceColor+" ";
	}

	protected boolean isNotFriend(int xFrom,int yFrom,int xTo,int yTo,Board b){

		if(b.myBoard[yTo][xTo] == null || !b.myBoard[yTo][xTo].pieceColor.equals(b.myBoard[yFrom][xFrom].pieceColor))
			return true;
		else
			return false;


	}


	abstract boolean isValidMove(int xFrom,int yFrom,int xTo,int yTo,Board b);

}





























