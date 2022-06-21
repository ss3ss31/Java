package il.co.chessgame;

public class GameMain 
{
	public void startTheGame() 
	{

		int counter = 1;
		boolean mat = false;	
		boolean isWhite=true;
		boolean rightPiece = false;
		Board bordRef = new Board();

		boolean validInput;
		int yFrom = 0;
		int xFrom = 0;
		int xTo = 0;
		int yTo = 0;

		bordRef.initBoard();



		while(!mat)
		{
			bordRef.printBoard();

			do{
				xFrom = yFrom = xTo = yTo =-1;

				/// input from
				System.out.println("Please select the piece");
				String inputFrom=InputUtility.input();
				if(inputFrom.contentEquals("*"))
					break;
				/// input to 
				System.out.println("Please select valid move");
				String inputTo=InputUtility.input();

				/// is valid input
				if(!inputFrom.equals("") && !inputTo.equals(""))
				{
					xFrom = translate(inputFrom.charAt(1));
					yFrom = translate(inputFrom.charAt(0));
					xTo = translate(inputTo.charAt(1)); 
					yTo = translate(inputTo.charAt(0));
				}

				validInput = yFrom !=-1 && xFrom !=-1 && xTo !=-1  && yTo !=-1;

				if(validInput){

					if((isWhite && bordRef.myBoard[yFrom][xFrom] != null && bordRef.myBoard[yFrom][xFrom].pieceColor.equals("W")) ||  (!isWhite && bordRef.myBoard[yFrom][xFrom].pieceColor.equalsIgnoreCase("B"))) {
						rightPiece = true;
					}
					else{
						System.out.println("not your tool");
					}



					if(rightPiece){
						if(bordRef.myBoard[yFrom][xFrom] != null && bordRef.myBoard[yFrom][xFrom].isValidMove(xFrom, yFrom, xTo, yTo, bordRef)){
							bordRef.movePiece(xFrom, yFrom, xTo, yTo, isWhite);
						}else{
							System.out.println("invalid  move");
							if (bordRef.myBoard[yFrom][xFrom].pieceName=="K" && ((King)bordRef.myBoard[yFrom][xFrom]).isCastling(bordRef.myBoard[yFrom][xFrom].firstTurn,
									bordRef.myBoard[yTo][xTo].firstTurn, bordRef, xFrom, yFrom, xTo, yTo))
							{
								if(xTo>xFrom)
								{
									bordRef.myBoard[yFrom][xTo-1]=bordRef.myBoard[yFrom][xFrom];
									bordRef.myBoard[yFrom][xFrom]=null;
									bordRef.myBoard[yFrom][xFrom+1]=bordRef.myBoard[yTo][xTo];
									bordRef.myBoard[yTo][xTo]=null;
								}
								else
								{
									bordRef.myBoard[yFrom][xTo+1]=bordRef.myBoard[yFrom][xFrom];
									bordRef.myBoard[yFrom][xFrom]=null;
									bordRef.myBoard[yFrom][xFrom-1]=bordRef.myBoard[yTo][xTo];
									bordRef.myBoard[yTo][xTo]=null;
								}
							}
						}
					}
				}else 
					System.out.println("error invalid input!!!");

			}while(!validInput || bordRef.myBoard[yFrom][xFrom]!=null || !rightPiece);

			isWhite = !isWhite;
			rightPiece = false;
			counter++;
		}

	}


	static int translate(char letter){
		switch(letter){
		case 'a': 	case 'A':	case '1': return 0;
		case 'b': 	case 'B':	case '2': return 1;
		case 'c':	case 'C':	case '3': return 2;
		case 'd': 	case 'D':	case '4': return 3;
		case 'e': 	case 'E':	case '5': return 4;
		case 'f': 	case 'F':	case '6': return 5;
		case 'g': 	case 'G':	case '7': return 6;
		case 'h':	case 'H':	case '8': return 7;
		default: return -1;
		}
	}

	//	public String isValidInput(String inputFrom,String inputTo)
	//	{
	//		String validFrom="";
	//		String validTo="";
	//		String[][] inputs={ {"A1","A2","A3","A4","A5","A6","A7","A8"},
	//							{"B1","B2","B3","B4","B5","B6","B7","B8"},
	//							{"C1","C2","C3","C4","C5","C6","C7","C8"},
	//							{"D1","D2","D3","D4","D5","D6","D7","D8"},
	//							{"E1","E2","E3","E4","E5","E6","E7","E8"},
	//							{"F1","F2","F3","F4","F5","F6","F7","F8"},
	//							{"G1","G2","G3","G4","G5","G6","G7","G8"},
	//							{"H1","H2","H3","H4","H5","H6","H7","H8"} };
	//
	//		for(int i=0;i<inputs.length-1;i++)
	//		{
	//			for(int j=0;j<inputs[i].length;j++)
	//			{
	//				if(inputFrom.equalsIgnoreCase(inputs[i][j]))
	//				{
	//					validFrom=i+""+j;
	//				}
	//				else if(inputTo.equalsIgnoreCase(inputs[i][j]))
	//				{
	//					validTo=i+""+j;
	//				}
	//				if(validTo.length()==2&&validFrom.length()==2)
	//				{
	//					return validFrom+validTo;
	//				}
	//			}
	//		}
	//		return "";
	//		
	//	}

}
