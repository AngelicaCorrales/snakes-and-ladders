package model;

public class Square {
	private int num;
	private char snake;
	private int ladder;
	private int col;
	private int row;
	private Player firstPlayer;

	private Square next;
	private Square prev;
	private Square up;	
	private Square down;

	public Square(int row, int col) {
		this.col = col;
		this.row = row;
	}

	public Square getNext() {
		return next;
	}

	public Square getPrev() {
		return prev;
	}

	public Square getUp() {
		return up;
	}

	public Square getDown() {
		return down;
	}

	public void setPrev(Square p) {
		prev = p;
	}

	public void setNext(Square n) {
		next = n;
	}

	public void setUp(Square u) {
		up = u;
	}

	public void setDown(Square d) {
		down = d;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public char getSnake() {
		return snake;
	}

	public void setSnake(char snake) {
		this.snake = snake;
	}

	public int getLadder() {
		return ladder;
	}

	public void setLadder(int ladder) {
		this.ladder = ladder;
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public String toString() {
		return "["+row+","+col+"]";
	}
}
