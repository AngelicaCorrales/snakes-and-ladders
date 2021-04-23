package model;

import java.util.concurrent.ThreadLocalRandom;

public class Grid {
	private Square firstSquare;
	private Square finalSquare;
	private Square zeroSquare;
	private int rows;
	private int columns;
	
	public Grid(String players, int snakes, int ladders, int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		createGrid();

		int cont = 0;
		firstSquare.addPlayers(players, cont);
	
		addLadders(ladders);
		addSnakes(snakes);
	}
	
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
				square1.setSnake((char) ('A'+(snakes-1)));
				square2.setSnake((char) ('A'+(snakes-1)));
				
				addSnakes(snakes-1);

			}			

		}

	}
	
	

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
				square1.setLadder(ladders);
				square2.setLadder(ladders);

				addLadders(ladders-1);

			}			

		}
		

	}
	
	
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

	private void createGrid() {
		firstSquare = new Square((rows-1),0);
		firstSquare.setNum(1);
		createRow((rows-1),0,firstSquare);
	}

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
			if(rows%2!=0) { //NUMERO CASILLA PRIMERA DE UNA FILA
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
			if(rows%2!=0) {//NUMERO DE CASILLA FILA
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
	
	public String toString() {
		String msg;
		msg = toStringRow(zeroSquare);
		return msg;
	}

	private String toStringRow(Square firstRow) {
		String msg = "";
		if(firstRow!=null) {
			msg = toStringCol(firstRow) + "\n";
			msg += toStringRow(firstRow.getDown());
		}
		return msg;
	}

	private String toStringCol(Square current) {
		String msg = "";
		if(current!=null) {
			msg = current.toString();
			msg += toStringCol(current.getNext());
		}
		return msg;
	}
	
	public String toString2() {
		String msg = "";
		
		return msg;
	}
	public Square getFinalSquare() {
		return finalSquare;
	}

	
}
