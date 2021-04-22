package model;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
	
	private Grid grid;

	public Game() {
		
	}
	
	public void startGame(int rows, int cols, int snakes, int ladders, String players) {
		int playersN = -1;
		String playersS = "";
		try {
			playersN = Integer.parseInt(players);
		}catch(NumberFormatException num) {
			playersS = players;
		}
		if(playersN!=-1) {
			String playersA = assignSymbol(playersN);
			grid = new Grid(playersA, ladders, rows, cols);
		}
		if(!playersS.equals("")) {
			grid = new Grid(playersS, snakes, ladders, rows, cols);
		}
	}
	
	public String assignSymbol(int playersN) {
		String symbol1 = "*";
		String symbol2 = "!";
		String symbol3 = "O";
		String symbol4 = "X";
		String symbol5 = "%";
		String symbol6 = "$";
		String symbol7 = "#";
		String symbol8 = "+";
		String symbol9 = "&";
		String players = "";
		int cont = 0;
		int codeNum = 0;
		if(cont!=playersN) {
			codeNum = ThreadLocalRandom.current().nextInt(1, 10);
		}
		return players;
	}
	
	public void moveGame() {
		
	}
	
	public void throwDie() {
		
	}
}
