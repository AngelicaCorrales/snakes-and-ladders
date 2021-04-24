package model;

/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
*/
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	
	public final static String SAVE_PATH_FILE = "data/winners.ackl";
	private Grid grid;
	private String players;
	private int playerPosition;
	
	private Winner winnerRoot;

	public Game() {
		playerPosition = 0;
		players = "";
	}
	
	/*private void saveWinners() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE));
	    oos.writeObject(winnerRoot);
	    oos.close();
	}*/
	
	/*@SuppressWarnings("unchecked")
	public boolean loadWinners() throws IOException, ClassNotFoundException {
		File f = new File(SAVE_PATH_FILE);
		boolean loaded = false;
		 if(f.exists()){
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			 winnerRoot = (winnerRoot)ois.readObject();
			 ois.close();
			 loaded = true;
		 }
		 return loaded;
	}*/

	public void startGame(int rows, int cols, int snakes, int ladders, String p) {
		int playersN = -1;
		int cont = 0;
		String py = "";
		String playersS = "";
		try {
			playersN = Integer.parseInt(p);
			String playersA = assignSymbol(py, playersN, cont);
			grid = new Grid(playersA, snakes, ladders, rows, cols);
			setPlayers(playersA);
		}catch(NumberFormatException num) {
			playersS = p;
			grid = new Grid(playersS, snakes, ladders, rows, cols);
			setPlayers(playersS);
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
				cont+=1;
			}
			break;
		case 2:
			add = searchSymbol(p, symbol2, c, times);
			if(add==false) {
				p += symbol2;
				cont+=1;
			}
			break;
		case 3:
			add = searchSymbol(p, symbol3, c, times);
			if(add==false) {
				p += symbol3;
				cont+=1;
			}
			break;
		case 4:
			add = searchSymbol(p, symbol4, c, times);
			if(add==false) {
				p += symbol4;
				cont+=1;
			}
			break;
		case 5:
			add = searchSymbol(p, symbol5, c, times);
			if(add==false) {
				p += symbol5;
				cont+=1;
			}
			break;
		case 6:
			add = searchSymbol(p, symbol6, c, times);
			if(add==false) {
				p += symbol6;
				cont+=1;
			}
			break;
		case 7:
			add = searchSymbol(p, symbol7, c, times);
			if(add==false) {
				p += symbol7;
				cont+=1;
			}
			break;
		case 8:
			add = searchSymbol(p, symbol8, c, times);
			if(add==false) {
				p += symbol8;
				cont+=1;
			}
			break;
		case 9:
			add = searchSymbol(p, symbol9, c, times);
			if(add==false) {
				p += symbol9;
				cont+=1;
			}
			break;	
		}
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

	public String throwDie() {
		int num = ThreadLocalRandom.current().nextInt(1, 7);
		grid.movePlayer(num, returnPlayer());
		String msg = "El jugador "+returnPlayer()+" ha lanzado el dado y obtuvo el puntaje"+" "+num;
		if(grid.getWinner()!=null) {
			msg+="\n	El jugador "+grid.getWinner().getSymbol()+" ha ganado el juego, con "+ grid.getWinner().getMovements()+" movimientos";
		}
		playerPosition+=1;
		return msg;
	}
	
	private char returnPlayer() {
		char p = ' ';
		if(playerPosition!=players.length()) {
			p = players.charAt(playerPosition);
		}else {
			setPlayerPosition(0);
			p = players.charAt(playerPosition);
		}
		return p;
	}
		
	public boolean endGame() {
		boolean end=false;
		if(grid.getWinner()!=null) {
			end=true;
		}
		return end;
	}
	
	public void addWinner(String nickname) {
		int score=grid.getWinner().getMovements()*grid.getRows()+grid.getColumns();
		Winner winner=new Winner(grid.getWinner().getSymbol(), nickname, score);
		if(winnerRoot==null) {
			winnerRoot=winner;
		}else {
			addWinner(winnerRoot, winner);
		}
	}
	
	private void addWinner(Winner current, Winner newWinner) {
		if(newWinner.getScore()<=current.getScore()){
			if(current.getRight()==null){
				current.setRight(newWinner);
				newWinner.setParent(current);
			}else{
				addWinner(current.getRight(),newWinner);
			}
		}else{
			if(current.getLeft()==null){
				current.setLeft(newWinner);
				newWinner.setParent(current);
			}else{
				addWinner(current.getLeft(),newWinner);
			}	
			
		}	
	}
	
	public String listWinnersInorder() {
		String list="";
		list+=listWinnersInorder(winnerRoot,list);
		return list;
	}
	
	public String listWinnersInorder(Winner current, String list) {
		
		if(current!=null) {
			list+=listWinnersInorder(current.getLeft(),list);
			list+=current.toString();
			list+=listWinnersInorder(current.getRight(),list);
		}
		return list;
	}
	
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public int getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}
	
	public void showWinners() {
		
	}
	
	public Winner winner() {
		return winnerRoot;
	}
}
