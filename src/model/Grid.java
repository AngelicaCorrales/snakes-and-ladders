package model;

import java.util.concurrent.ThreadLocalRandom;

public class Grid {
	//Attributes
	private int rows;
	private int columns;
	
	//Relationships
	private Square firstSquare;
	private Square finalSquare;
	private Square zeroSquare;
	
	
	/**
	*This is the constructor of the class. <br>
	*<b>name:</b> Grid. <br>
	*<b>pre</b>: the variables players, snakes, ladders,rows, columns are already initialized. <br>
	*<b>post:</b> the attributes and relationships of the class have been initialized. The grid has been created. The snakes and ladders have been added to the grid.<br>
	*@param players Is a String variable that contains the symbols of the players for the game. players!=null and players!="".<br>
	*@param snakes Is an integer variable that contains the number of snakes for the game. snakes greater than 0.<br>
	*@param ladders Is an integer variable that contains the number of ladders for the game. ladders greater than 0.<br>
	*@param rows Is an integer variable that contains the number of rows for the game. rows greater than 2.<br>
	*@param columns Is an integer variable that contains the number of columns for the game. columns greater than 2.<br>
	*/
	public Grid(String players, int snakes, int ladders, int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		createGrid();
		int cont = 0;
		firstSquare.addPlayers(players, cont);
		addLadders(ladders);
		addSnakes(snakes);
	}
	
	/**
	*This method gets the number of rows of the grid. <br>
	*<b>name:</b> getRows.<br>
	*<b>post:</b> the number of rows has been gotten. <br>
	*@return an <code>integer</code> specifying rows, the number of rows of the grid.
	*/
	public int getRows() {
		return rows;
	}
	
	/**
	*This method gets the number of columns of the grid. <br>
	*<b>name:</b> getColumns.<br>
	*<b>post:</b> the number of columns has been gotten. <br>
	*@return an <code>integer</code> specifying columns, the number of columns of the grid.
	*/
	public int getColumns() {
		return columns;
	}
	
	/**
	*This method gets the winner of the game. <br>
	*<b>name:</b> getWinner.<br>
	*<b>post:</b> the winner of the game has been gotten. <br>
	*@return a <code>Player</code> specifying winner, the winner of the game.
	*/
	public Player getWinner() {
		Player winner=null;
		if(finalSquare.getFirstPlayer()!=null) {
			winner=finalSquare.getFirstPlayer();
		}
		return winner;
	}
	
	/**
	*This method adds snakes to the grid. <br>
	*<b>name:</b> addSnakes.<br>
	*<b>pre</b>: snakes is already initialized.   <br>
	*<b>post:</b> snakes have been added to the grid. <br>
	*@param snakes Is an integer variable that contains  the number of snakes for the game. snakes greater than 0.<br>
	*/
	private void addSnakes(int snakes) {

		if(snakes==0) {
			return;
		}else {

			int i1 = ThreadLocalRandom.current().nextInt(0, rows);
			int i2 = ThreadLocalRandom.current().nextInt(0, rows);
			int j1 = ThreadLocalRandom.current().nextInt(0, columns);
			int j2 = ThreadLocalRandom.current().nextInt(0, columns);
			Square square1= searchSquare(i1,j1, zeroSquare);
			Square square2= searchSquare(i2,j2, zeroSquare);

			if(i1==i2 || square1==finalSquare || square2==finalSquare || square1.getLadder()!=0 || square2.getLadder()!=0 || square1.getSnake()!=0 || square2.getSnake()!=0) {
				addSnakes(snakes);
			}else {
				if(i1<i2) {
					square1.setFinalSnake(square2);
				}else {
					square2.setFinalSnake(square1);
				}
				square1.setSnake((char) ('A'+(snakes-1)));
				square2.setSnake((char) ('A'+(snakes-1)));
				addSnakes(snakes-1);
			}			

		}

	}
	
	/**
	*This method adds ladders to the grid. <br>
	*<b>name:</b> addLadders.<br>
	*<b>pre</b>: ladders is already initialized.   <br>
	*<b>post:</b> ladders have been added to the grid. <br>
	*@param ladders Is an integer variable that contains the number of ladders for the game. ladders greater than 0.<br>
	*/
	private void addLadders(int ladders) {
		
		if(ladders==0) {
			return;
		}else {
			
			int i1 = ThreadLocalRandom.current().nextInt(0, rows);
			int i2 = ThreadLocalRandom.current().nextInt(0, rows);
			int j1 = ThreadLocalRandom.current().nextInt(0, columns);
			int j2 = ThreadLocalRandom.current().nextInt(0, columns);
			
			Square square1= searchSquare(i1,j1, zeroSquare);
			Square square2= searchSquare(i2,j2, zeroSquare);
			if(i1==i2 || square1==firstSquare || square2==firstSquare || square1.getLadder()!=0 || square2.getLadder()!=0) {
				addLadders(ladders);
			}else {
				if(i1>i2) {
					square1.setFinalLadder(square2);
				}else {
					square2.setFinalLadder(square1);
				}
				square1.setLadder(ladders);
				square2.setLadder(ladders);

				addLadders(ladders-1);
			}
		}
	}
	
	/**
	*This method  searches the square according to specified coordinates.<br>
	*<b>name:</b> searchSquare.<br>
	*<b>pre</b>: i, j, square are already initialized.   <br>
	*<b>post:</b> the searched square has been found. <br>
	*@param i Is an integer variable that contains the row of the searched square. i greater than or equal to 0.<br>
	*@param j Is an integer variable that contains the column of the searched square. j greater than or equal to 0.<br>
	*@param square Is a Square object that references the first square of the row. square!=null.<br>
	*@return a <code>Square</code> specifying square, the searched square.
	*/
	private Square searchSquare(int i, int j, Square square) {
		
		if(i==square.getRow() && j==square.getCol()) {
			return square;
		}else {
			if(i==square.getRow()) {
				return searchSquare(i, j,square.getNext());
			}else {
				return searchSquare(i, j,square.getDown());
			}
		}
	}

	/**
	*This method creates the grid for the game. <br>
	*<b>name:</b> createGrid.<br>
	*<b>post:</b> the grid has been created. <br>
	*/
	private void createGrid() {
		firstSquare = new Square((rows-1),0);
		firstSquare.setNum(1);
		createRow((rows-1),0,firstSquare);
	}

	/**
	*This method creates rows of the grid. <br>
	*<b>name:</b> createRow.<br>
	*<b>pre</b>: i, j, currentFirstRow are already initialized.   <br>
	*<b>post:</b> rows have been created. <br>
	*@param i Is an integer variable that contains the row for the new square in the column of the row. i greater than or equal to 0.<br>
	*@param j Is an integer variable that contains the column for the first square in the row. j equal to 0.<br>
	*@param currentFirstRow Is a Square object that references the first square of the row. currentFirstRow!=null.<br>
	*/
	private void createRow(int i, int j, Square currentFirstRow) {
		createCol(i,j+1,currentFirstRow,currentFirstRow.getDown());
		if((i-1)>=0) {
			Square upFirstRow = new Square((i-1),j);
			
			if((i-1)==0) {
				zeroSquare=upFirstRow;
				if(rows%2==0) {
					finalSquare=upFirstRow;
				}
			}
			
			upFirstRow.setDown(currentFirstRow);
			currentFirstRow.setUp(upFirstRow);
			if(rows%2!=0) { //NUMBER OF THE FIRST SQUARE OF A ROW
				if((i-1)%2!=0) {
					upFirstRow.setNum((rows-i+1)*columns);
				}else {
					upFirstRow.setNum(currentFirstRow.getNum()+1);
				}
			}else {
				if((i-1)%2==0) {
					upFirstRow.setNum((rows-i+1)*columns);
				}else {
					upFirstRow.setNum(currentFirstRow.getNum()+1);
				}
			}
			
			createRow((i-1),j,upFirstRow);
		}
	}

	/**
	*This method creates a row, column by column, of the grid. <br>
	*<b>name:</b> createCol.<br>
	*<b>pre</b>: i, j, prev, rowDown are already initialized.   <br>
	*<b>post:</b> the row has been created. <br>
	*@param i Is an integer variable that contains the row for the new square in the column of the row. i greater than or equal to 0.<br>
	*@param j Is an integer variable that contains the column for the new square in the row. j greater than or equal to 0.<br>
	*@param prev Is a Square object that references the previous square of the row.<br>
	*@param rowDown Is a Square object that references the square down the previous square of the row.<br>
	*/
	private void createCol(int i, int j, Square prev, Square rowDown) {
		if(j<columns) {
			Square current = new Square(i, j);
			current.setPrev(prev);
			prev.setNext(current);
			
			if(rowDown!=null) {
				rowDown = rowDown.getNext();
				current.setDown(rowDown);
				rowDown.setUp(current);
			}
			if(rows%2!=0) {//ROW SQUARE NUMBER
				if(i==0 && j==(columns-1)) {
					finalSquare=current;
				}

				if((i)%2!=0) {

					current.setNum(prev.getNum()-1); 
				}else {
					current.setNum(prev.getNum()+1);
				}
				
			}else {
				if((i)%2==0) {

					current.setNum(prev.getNum()-1);
				}else {
					current.setNum(prev.getNum()+1);
				}
			}
			createCol(i,j+1,current,rowDown);
		}
	}
	
	/**
	*This method moves a player from square to square. <br>
	*<b>name:</b> movePlayer.<br>
	*<b>pre</b>: num, and player are already initialized.   <br>
	*<b>post:</b> the player has been moved on the grid. <br>
	*@param num Is an integer variable that contains the number obtained from throwing the die. num from 1 to 6.<br>
	*@param player Is a char variable that contains the player's symbol. player=='*' or player== '!' or  player== 'O' or player== 'X' 
		 or player=='%' or	 player== '$' or player=='#' or player== '+' or player=='&'.<br>
	*/
	public void movePlayer(int num, char player) {
		Square from =searchPlayerInSquare(player, zeroSquare, zeroSquare.getDown());
		Square to= searchSquareByNumber((num+from.getNum()), zeroSquare,zeroSquare.getDown());
		
		if(to.getFinalSnake()!=null) {
			to=to.getFinalSnake();
			
		}
		if(to.getFinalLadder()!=null) {
			to=to.getFinalLadder();
		}
		from.movePlayer(to, from.searchPlayer(player));
	}
	
	/**
	*This method  searches the square by its square number.<br>
	*<b>name:</b> searchSquareByNumber.<br>
	*<b>pre</b>: num, square, and squareDown are already initialized.   <br>
	*<b>post:</b> the searched square has been found. <br>
	*@param num Is an integer variable that contains the number of the searched square. num greater than 0.<br>
	*@param square Is a Square object that references the first square of the row. square!=null.<br>
	*@param squareDown Is a Square object that references the square down the first square of the row. squareDown!=null.<br>
	*@return a <code>Square</code> specifying square, the searched square.
	*/
	private Square searchSquareByNumber(int num, Square square,Square squareDown) {
		if(num>=rows*columns) {
			return finalSquare;
		}
		if(num==square.getNum()) {
			return square;
		}else {
			if(square.getNext()!=null) {
				return searchSquareByNumber(num,square.getNext(),squareDown);
			}else {
				return searchSquareByNumber(num,squareDown,squareDown.getDown());
			}
		}
	}

	/**
	*This method  searches the square that contains the player.<br>
	*<b>name:</b> searchPlayerInSquare.<br>
	*<b>pre</b>: player, square, and squareDown are already initialized.   <br>
	*<b>post:</b> the searched square has been found. <br>
	*@param player Is a char variable that contains the player's symbol. player=='*' or player== '!' or  player== 'O' or player== 'X' 
		 or player=='%' or	 player== '$' or player=='#' or player== '+' or player=='&'.<br>
	*@param square Is a Square object that references the first square of the row. square!=null.<br>
	*@param squareDown Is a Square object that references the square down the first square of the row. squareDown!=null.<br>
	*@return a <code>Square</code> specifying square, the searched square.
	*/
	private Square searchPlayerInSquare(char player, Square square, Square squareDown) {
		if(square.searchPlayer(player)!=null) {
			return square;
		}else {
			if(square.getNext()!=null) {
				return searchPlayerInSquare(player,square.getNext(), squareDown);
			}else {
				return searchPlayerInSquare(player,squareDown, squareDown.getDown());

			}
		}
		
	}
	
	/**
	* This method obtains a String with the numbered grid, with snakes and ladders. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the grid has been obtained. <br>
 	* @return a <code> String </code> specifying msg, the numbered grid, with snakes and ladders.
 	*/ 
	public String toString() {
		String msg;
		msg = toStringRow(zeroSquare);
		return msg;
	}
	
	/**
	* This method obtains a String with numbered rows of the grid, with snakes and ladders. <br>
	* <b>name</b>: toStringRow.<br>
 	*<b>pre</b>: firstRow is already initialized.   <br>
 	* <b>post</b>: rows has been obtained. <br>
 	*@param firstRow Is a Square object that references the first square of the row.<br>
 	* @return a <code> String </code> specifying msg, the numbered rows of the grid, with snakes and ladders.
 	*/ 
	private String toStringRow(Square firstRow) {
		String msg = "";
		if(firstRow!=null) {
			msg = toStringCol(firstRow) + "\n";
			msg += toStringRow(firstRow.getDown());
		}
		return msg;
	}

	/**
	* This method obtains a String with a numbered row of the grid, with snakes and ladders. <br>
	* <b>name</b>: toStringCol.<br>
 	*<b>pre</b>: current is already initialized.   <br>
 	* <b>post</b>: the row has been obtained. <br>
 	*@param current Is a Square object that references the first square of the row.<br>
 	* @return a <code> String </code> specifying msg, the numbered row of the grid, with snakes and ladders.
 	*/ 
	private String toStringCol(Square current) {
		String msg = "";
		if(current!=null) {
			msg = current.toString();
			msg += toStringCol(current.getNext());
		}
		return msg;
	}
	
	
	/**
	* This method obtains a String with the grid from the game, with its players, snakes and ladders. <br>
	* <b>name</b>: toString2.<br>
 	* <b>post</b>: the grid has been obtained. <br>
 	* @return a <code> String </code> specifying msg, the grid from the game, with its players, snakes and ladders.
 	*/ 
	public String toString2() {
		String msg;
		msg = toStringRow2(zeroSquare);
		return msg;
	}
	
	/**
	* This method obtains a String with rows of the grid from the game, with players, snakes and ladders. <br>
	* <b>name</b>: toStringRow.<br>
 	*<b>pre</b>: firstRow is already initialized.   <br>
 	* <b>post</b>: rows has been obtained. <br>
 	*@param firstRow Is a Square object that references the first square of the row.<br>
 	* @return a <code> String </code> specifying msg, rows of the grid from the game, with players, snakes and ladders.
 	*/ 
	private String toStringRow2(Square firstRow) {
		String msg = "";
		if(firstRow!=null) {
			msg = toStringCol2(firstRow) + "\n";
			msg += toStringRow2(firstRow.getDown());
		}
		return msg;
	}

	/**
	* This method obtains a String with a row of the grid from the game, with players, snakes and ladders. <br>
	* <b>name</b>: toStringCol2.<br>
 	*<b>pre</b>: current is already initialized.   <br>
 	* <b>post</b>: the row has been obtained. <br>
 	*@param current Is a Square object that references the first square of the row.<br>
 	* @return a <code> String </code> specifying msg, the row of the grid from the game, with players, snakes and ladders.
 	*/ 
	private String toStringCol2(Square current) {
		String msg = "";
		if(current!=null) {
			msg = current.toString2();
			msg += toStringCol2(current.getNext());
		}
		return msg;
	}

	
}
