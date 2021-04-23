package model;

public class Grid {
	private Square firstSquare;
	private Square finalSquare;
	private Square zeroSquare;
	private int rows;
	private int columns;
	
	public Grid(String players, int snakes, int ladders, int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		//pendiente escaleras y serpientes
		createGrid();
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
