package model;

public class Square {
	private int num;
	private char snake;
	private int ladder;
	private String players;

	private Square next;
	private Square prev;
	private Square up;	
	private Square down;

	public Square(int num, char snake, int ladder) {
		this.num = num;
		this.snake = snake;
		this.ladder = ladder;
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

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}
}
