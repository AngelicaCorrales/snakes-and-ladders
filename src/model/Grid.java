package model;

public class Grid {
	private Square firstSquare;
	private int rows;
	private int columns;
	
	public Grid(String players, int snakes, int ladders, int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		//pendiente escaleras y serpientes
		createGrid();
	}
	
	private void createGrid() {
		firstSquare = new Square(0,0);
		createRow(0,0,first);
	}

	private void createRow(int i, int j, Square currentFirstRow) {
		createCol(i,j+1,currentFirstRow,currentFirstRow.getUp());
		if(i+1<rows) {
			Square downFirstRow = new Square(i+1,j);
			downFirstRow.setUp(currentFirstRow);
			currentFirstRow.setDown(downFirstRow);
			createRow(i+1,j,downFirstRow);
		}
	}

	private void createCol(int i, int j, Square prev, Square rowPrev) {
		if(j<columns) {
			Square current = new Square(i, j);
			current.setPrev(prev);
			prev.setNext(current);
			
			if(rowPrev!=null) {
				rowPrev = rowPrev.getNext();
				current.setUp(rowPrev);
				rowPrev.setDown(current);
			}
			
			createCol(i,j+1,current,rowPrev);
		}
	}
	
	public String toString() {
		String msg;
		msg = toStringRow(firstSquare);
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
}
}
