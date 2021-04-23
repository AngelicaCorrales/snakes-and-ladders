package model;

import java.util.concurrent.ThreadLocalRandom;

public class Game {

	private Grid grid;

	public Game() {

	}

	public void startGame(int rows, int cols, int snakes, int ladders, String players) {
		int playersN = -1;
		int cont = 0;
		String playersS = "";
		try {
			playersN = Integer.parseInt(players);
		}catch(NumberFormatException num) {
			playersS = players;
		}
		if(playersN!=-1) {
			String playersA = assignSymbol(playersN, cont);
			grid = new Grid(playersA, snakes, ladders, rows, cols);
		}
		if(!playersS.equals("")) {
			grid = new Grid(playersS, snakes, ladders, rows, cols);
		}
	}

	public String assignSymbol(int playersN, int cont) {
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
		int codeNum = 0;
		codeNum = ThreadLocalRandom.current().nextInt(1, 10);
		switch(codeNum) {
		case 1:
			players += symbol1;
			break;
		case 2:
			players += symbol2;
			break;
		case 3:
			players += symbol3;
			break;
		case 4:
			players += symbol4;
			break;
		case 5:
			players += symbol5;
			break;
		case 6:
			players += symbol6;
			break;
		case 7:
			players += symbol7;
			break;
		case 8:
			players += symbol8;
			break;
		case 9:
			players += symbol9;
			break;	
		}
		cont+=1;
		if(cont!=playersN) {
			assignSymbol((playersN-cont), cont);
		}
		return players;
	}

	public void moveGame() {

	}

	public void throwDie() {

	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}
}
