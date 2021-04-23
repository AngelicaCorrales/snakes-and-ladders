package model;

import java.util.concurrent.ThreadLocalRandom;

public class Game {

	private Grid grid;

	public Game() {

	}

	public void startGame(int rows, int cols, int snakes, int ladders, String players) {
		int playersN = -1;
		int cont = 0;
		String p = "";
		String playersS = "";
		try {
			playersN = Integer.parseInt(players);
		}catch(NumberFormatException num) {
			playersS = players;
		}
		if(playersN!=-1) {
			String playersA = assignSymbol(p, playersN, cont);
			grid = new Grid(playersA, snakes, ladders, rows, cols);
		}
		if(!playersS.equals("")) {
			grid = new Grid(playersS, snakes, ladders, rows, cols);
		}
	}

	public String assignSymbol(String p, int playersN, int cont) {
		boolean add = true;
		char symbol1 = '*';
		char symbol2 = '!';
		char symbol3 = 'O';
		char symbol4 = 'X';
		char symbol5 = '%';
		char symbol6 = '$';
		char symbol7 = '#';
		char symbol8 = '+';
		char symbol9 = '&';
		int c = 0;
		int times = 0;
		int codeNum = 0;
		codeNum = ThreadLocalRandom.current().nextInt(1, 10);
		switch(codeNum) {
		case 1:
			add = searchSymbol(p, symbol1, c, times);
			if(add==false) {
				p += symbol1;
			}
			break;
		case 2:
			add = searchSymbol(p, symbol2, c, times);
			if(add==false) {
				p += symbol2;
			}
			break;
		case 3:
			add = searchSymbol(p, symbol3, c, times);
			if(add==false) {
				p += symbol3;
			}
			break;
		case 4:
			add = searchSymbol(p, symbol4, c, times);
			if(add==false) {
				p += symbol4;
			}
			break;
		case 5:
			add = searchSymbol(p, symbol5, c, times);
			if(add==false) {
				p += symbol5;
			}
			break;
		case 6:
			add = searchSymbol(p, symbol6, c, times);
			if(add==false) {
				p += symbol6;
			}
			break;
		case 7:
			add = searchSymbol(p, symbol7, c, times);
			if(add==false) {
				p += symbol7;
			}
			break;
		case 8:
			add = searchSymbol(p, symbol8, c, times);
			if(add==false) {
				p += symbol8;
			}
			break;
		case 9:
			add = searchSymbol(p, symbol9, c, times);
			if(add==false) {
				p += symbol9;
			}
			break;	
		}
		cont+=1;
		if(cont!=playersN) {
			assignSymbol(p, (playersN-cont), cont);
		}
		return p;
	}

	private boolean searchSymbol(String p, char s, int cont, int times) {
		boolean find = false;
		if(times<=1 && cont!=p.length()) {
			if(s!=p.charAt(cont)) {
				searchSymbol(p, s, (cont+=1), times);
			}else {
				times+=1;
				find = true;
				return find;
			}
		}
		return find;
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
