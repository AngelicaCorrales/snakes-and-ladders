package model;

public class Player {

	private char symbol;
	private int movements;
	
	private Player next;
	private Player prev;
	

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
	
	
	public Player getNext() {
		return next;
	}

	public void setNext(Player next) {
		this.next = next;
	}

	public Player getPrev() {
		return prev;
	}

	public void setPrev(Player prev) {
		this.prev = prev;
	}
}
