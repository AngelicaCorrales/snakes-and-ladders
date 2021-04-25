package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	
	//Attributes
	public final static String SAVE_PATH_FILE = "data/winners.ackl";
	private String players;
	private String listOfWinners;
	private String gameSettings;
	private int winnerPosition;
	private int playerPosition;
	
	//Relationships
	private Grid grid;
	private Winner winnerRoot;
	
	/**
	* Builder method <br>
	* <b>name</b>: Game <br>
	* <b>post</b>: All the attributes of the class were initialized. <br>
	*/
	
	public Game() {
		playerPosition = 0;
		winnerPosition = 0;
		players = "";
		listOfWinners = "";
		gameSettings="";
	}
	
	/**
	* This method serializes or saves all the information about the winner of each round in the game.<br>
	* <b>name</b>: saveWinners <br>
	* <b>post</b>: The winner of a round was saved. <br>
	* @throws IOException: <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
	*/
	
	private void saveWinners() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE));
	    oos.writeObject(winnerRoot);
	    oos.close();
	}
	
	/**
	* This method loads all the information about the winners of the game.<br>
	* <b>name</b>: loadWinners <br>
	* <b>post</b>: The winners of the game were loaded. <br>
	* @throws IOException: <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
    * @throws ClassNotFoundException: <br>
    *		thrown if the path of the file wasn't found. <br> 
    * @return a <code> boolean </code> specifying loaded, a variable that indicates if the file with the given path was found.  
	*/
	
	public boolean loadWinners() throws IOException, ClassNotFoundException {
		File f = new File(SAVE_PATH_FILE);
		boolean loaded = false;
		 if(f.exists()){
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			 winnerRoot = (Winner)ois.readObject();
			 ois.close();
			 loaded = true;
		 }
		 return loaded;
	}
	
	/**
	* This method creates a game board depending on the information provided. <br>
	* <b>name</b>: startGame <br>
	* <b>pre</b>: the variables rows, cols, snakes, ladders and p are already initialized. <br>
	* <b>post</b>: The game board was created. <br>
	* @param snakes Is an Integer variable that contains the number of snakes for the game. snakes greater than 0.<br>
	* @param ladders Is an Integer variable that contains the number of ladders for the game. ladders greater than 0.<br>
	* @param rows Is an Integer variable that contains the number of rows for the game. rows greater than 1.<br>
	* @param columns Is an Integer variable that contains the number of columns for the game. columns greater than 1.<br>
	* @param p Is a String variable that contains the players for the game. p!="" && p!=null.<br>
	*/

	public void startGame(int rows, int cols, int snakes, int ladders, String p) {
		int playersN = -1;
		int cont = 0;
		String py = "";
		String playersS = "";
		try {
			playersN = Integer.parseInt(p);
			String playersA = assignSymbol(py, playersN, cont);
			grid = new Grid(playersA, snakes, ladders, rows, cols);
			players = playersA;
			gameSettings=rows+" "+cols+" "+snakes+" "+ladders+" "+p;
		}catch(NumberFormatException num) {
			playersS = p;
			grid = new Grid(playersS, snakes, ladders, rows, cols);
			players = playersS;
		}
	}

	/**
	* This method assigns a symbol to each player in a random way. <br>
	* <b>name</b>: assignSymbol <br>
	* <b>pre</b>: the variables p, playersN and cont are already initialized. <br>
	* <b>post</b>: Each player has an assigned symbol. <br>
	* @param playersN Is an Integer variable that contains the number of players for the game. playersN greater than 0.<br>
	* @param cont Is an Integer variable that will contain the number of players that have already been assigned a symbol.<br>
	* @param p Is a String variable that will contain each player's symbols for the game.<br>
	* @return a <code> String </code> specifying p, a variable with the players' symbols for the game. 
	*/
	
	private String assignSymbol(String p, int playersN, int cont) {
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

	/**
	* This method searches for a specific symbol within the text string that contains the symbols of the other players. <br>
	* <b>name</b>: searchSymbol <br>
	* <b>pre</b>: the variables p, s, cont and times are already initialized. <br>
	* <b>post</b>: True or false was returned depending of the result of the verification. <br>
	* @param times Is an Integer variable that will contains the number of times that a given symbol is found in the text string.<br>
	* @param cont Is an Integer variable that will contain the position of a letter within the text string.<br>
	* @param p Is a String variable that contains the symbols of all the players for the game.<br>
	* @param s Is a char variable that contains a specific symbol of a player. p!='' p!=null.<br>
	* @return a <code> boolean </code> specifying find, a variable that indicates if a certain symbol has already been assigned to a player. 
	*/
	
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

	/**
	* This method randomly chooses a number from 1 to 6 that indicates the box to which a player should go. <br>
	* <b>name</b>: throwDie <br>
	* <b>post</b>: A number was chosen and a message is returned indicating the player's score or the number of moves that the player made to win the game. <br>
	* @return a <code> String </code> specifying msg, a variable that contains the score of a player or the number of moves that the player made to win the game. 
	*/
	
	public String throwDie() {
		int num = ThreadLocalRandom.current().nextInt(1, 7);
		grid.movePlayer(num, returnPlayer());
		String msg = "\nEl jugador "+returnPlayer()+" ha lanzado el dado y obtuvo el puntaje"+" "+num;
		if(grid.getWinner()!=null) {
			msg+="\nEl jugador "+grid.getWinner().getSymbol()+" ha ganado el juego, con "+ grid.getWinner().getMovements()+" movimientos";
		}
		playerPosition+=1;
		return msg;
	}
	
	/**
	* This method returns the symbol of the player who is playing. <br>
	* <b>name</b>: returnPlayer <br>
	* <b>post</b>: The symbol of the player who is playing at the moment was returned. <br>
	* @return a <code> char </code> specifying p, a variable that contains the player who is playing at the moment. 
	*/
	
	private char returnPlayer() {
		char p = ' ';
		if(playerPosition!=players.length()) {
			p = players.charAt(playerPosition);
		}else {
			playerPosition = 0;
			p = players.charAt(playerPosition);
		}
		return p;
	}
	
	/**
	* This method indicates if the game is over or not. <br>
	* <b>name</b>: endGame <br>
	* <b>post</b>: True or false was returned depending on the state of the game. <br>
	* @return a <code> boolean </code> specifying end, a variable that indicates if the game is over or not. 
	*/
		
	public boolean endGame() {
		boolean end=false;
		if(grid.getWinner()!=null) {
			end=true;
		}
		return end;
	}
	
	/**
	* This method adds a winner to the binary tree.<br>
	* <b>name</b>: addWinner <br>
	* <b>pre</b>: The variable nickname is already initialized. <br>
	* <b>post</b>: The winner player was added. <br>
	* @param nickname Is a String variable that contains the name of a winner player. p!="" && p!=null.<br>
	* @throws IOException: <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
	*/
	
	public void addWinner(String nickname) throws IOException {
		int score=grid.getWinner().getMovements()*grid.getRows()*grid.getColumns();
		Winner winner=new Winner(grid.getWinner().getSymbol(), nickname, score, gameSettings, players);
		if(winnerRoot==null) {
			setWinnerRoot(winner);
			saveWinners();
		}else {
			addWinner(winnerRoot, winner);
			saveWinners();
		}
	}
	
	/**
	* This method adds a winner to the binary tree in case the root of the binary tree already has a value assigned to it.<br>
	* <b>name</b>: addWinner <br>
	* <b>pre</b>: The objects current and newWinner are already initialized. <br>
	* <b>post</b>: The winner player was added. <br>
	* @param current Is a Winner object that represents the root of the binary tree of winners. current!=null.<br>
	* @param newWinner Is a Winner object that represents the new winner player that is going to be added to the binary tree. newWinner!=null.<br>
	*/
	
	private void addWinner(Winner current, Winner newWinner) {
		if(newWinner.getScore()<current.getScore()){
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
	
	/**
	* This method returns the binary tree of winners.<br>
	* <b>name</b>: listWinnersInOrder <br>
	* <b>post</b>: All the winners that are in the binary tree were returned. <br>
	* @return a <code> String </code> specifying listOfWinners, a variable that contains all the winners that are in the binary tree. 
	*/
	
	public String listWinnersInorder() {
		winnerPosition = 0;
		listOfWinners = "";
		listWinnersInorder(winnerRoot, winnerRoot.getParent());
		return listOfWinners;
	}

	/**
	* This method searches and concatenates the winners in an inorder way.<br>
	* <b>name</b>: listWinnersInOrder <br>
	* <b>pre</b>: The objects like current and parent are already initialized. <br>
	* <b>post</b>: The winners were concatenated in an inorder way. <br>
	* @param current Is a Winner object that represents the root of the binary tree of winners. <br>
	* @param parent Is a Winner object that represents the object that is up of another winner object.<br>
	*/
	
	private void listWinnersInorder(Winner current, Winner parent) {
		if(current!=null) {
			if(current.getLeft()!=parent) {
				listWinnersInorder(current.getLeft(), current);
			}
			winnerPosition+=1;
			listOfWinners+="\n                                           "+winnerPosition+".   "+current.toString();
			if(current.getRight()!=parent) {
				listWinnersInorder(current.getRight(), current);
			}
		}else {
			return;
		}
	}
	
	//Getters and Setters
	
	/**
	* This method returns the board game. <br>
	* <b>name</b>: getGrid <br>
	* <b>post</b>: the board game has been gotten. <br>
	* @return a <code> Grid </code> object specifying grid, the board game.
	*/
	
	public Grid getGrid() {
		return grid;
	}

	/**
	* This method modifies the board game. <br>
	* <b>name</b>: setGrid. <br>
	* <b>post</b>: the boardGame has been changed. <br>
	* @param grid is an object of type Grid.
	*/
	
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	/**
	* This method returns the root of the binary tree of winners. <br>
	* <b>name</b>: getWinnerRoot <br>
	* <b>post</b>: the root of the binary tree of winners has been gotten. <br>
	* @return a <code> Winner </code> object specifying winnerRoot, the root of the binary tree of winners.
	*/
	
	public Winner getWinnerRoot() {
		return winnerRoot;
	}

	/**
	* This method modifies the root of the binary tree of winners. <br>
	* <b>name</b>: setWinnerRoot<br>
	* <b>post</b>: the root of the binary tree of winners has been changed. <br>
	* @param winnerRoot is an object of type Winner.
	*/
	
	public void setWinnerRoot(Winner winnerRoot) {
		this.winnerRoot = winnerRoot;
	}
	
}
