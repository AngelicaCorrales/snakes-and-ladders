package model;

public class Player {

	private char symbol;
	private int movements;
	
	public Player(char symbol, int movements) {
		this.symbol = symbol;
		this.movements = movements;
	}

	public int getMovements() {
		return movements;
	}

	public void setMovements(int movements) {
		this.movements = movements;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
}
