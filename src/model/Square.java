package model;

public class Square {
	private int num;
	private char snake;
	private int ladder;
	private int col;
	private int row;
	private Player firstPlayer;
	private Player finalPlayer;

	

	private Square next;
	private Square prev;
	private Square up;	
	private Square down;

	public Square(int row, int col) {
		this.col = col;
		this.row = row;
	}
	
	public void addPlayer(Player player) {
		//AL INICIO DE LA LISTA
		player.setNext(firstPlayer);
		if(firstPlayer==null) {
			finalPlayer=player;
		}
		if(firstPlayer.getNext()==null) {
			finalPlayer=firstPlayer;
		}
		
		firstPlayer=player;
		
	}
	
	public void removePlayer(Player player) {
		if(player==finalPlayer) {
			Player prev=player.getPrev();
			prev.setNext(null);
			finalPlayer=prev;
		}
	}

	public void movePlayer(Square square, Player player) {
		//PASO POR PARAMETRO LA CASILLA EN LA QUE SE VA A UBICAR EL JUGADOR
		removePlayer(player);
		square.addPlayer(player);
		player.setMovements(player.getMovements()+1);
	}

	public void addPlayers(String players, int cont) {
		if(cont!=players.length()) {
			Player player = new Player(players.charAt(cont), 0);
			addPlayer(player);
			cont+=1;
			addPlayers(players, cont);
			
		}
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
	
	public Player getFinalPlayer() {
		return finalPlayer;
	}

	public void setFinalPlayer(Player finalPlayer) {
		this.finalPlayer = finalPlayer;
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
		String ladderString="";
		if(ladder!=0) {
			ladderString=String.valueOf(ladder);
		}
		return "["+num+ladderString+snake+"]";
	}
	
	public String toString2() {
		String ladderString="";
		if(ladder!=0) {
			ladderString=String.valueOf(ladder);
		}
		return "["+ladderString+snake+"]";
	}
}
