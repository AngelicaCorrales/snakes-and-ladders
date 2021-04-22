package model;

public class Player {

	private String symbol;
	private int movements;
	
	public Player(String symbol, int movements) {
		this.setSymbol(symbol);
		this.setMovements(movements);
	}

	public int getMovements() {
		return movements;
	}

	public void setMovements(int movements) {
		this.movements = movements;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}
