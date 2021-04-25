package model;

import java.io.Serializable;

public class Winner implements Serializable{
	
	//Attributes
	private static final long serialVersionUID = 1;
	private String nickname;
	private char symbol;
	private int score;
	private String gameSettings;
	private String players;
	
	//Relationships
	private Winner left;
	private Winner right;
	private Winner parent;
	
	/**
	* Builder method <br>
	* <b>name</b>: Winner <br>
	* <b>pre</b>: the variables symbol, nickname and score are already initialized. <br>
	* <b>post</b>: All the attributes of the class were initialized. <br>
	* @param symbol Is a char variable that contains the symbol of a winner player. symbol=='*' or symbol== '!' or  symbol== 'O' or symbol== 'X' or symbol=='%' or	 symbol== '$' or symbol=='#' or symbol== '+' or symbol=='&'.<br>
	* @param nickname Is a String variable that contains the name of a winner player. nickname!=null && nickname!= "".<br>
	* @param score Is an integer variable that contains the score of a winner player in the game. score!=0.<br>
	*/
	
	public Winner(char symbol, String nickname, int score, String gameSettings, String players) {
		this.symbol=symbol;
		this.nickname=nickname;
		this.score=score;
		this.gameSettings=gameSettings;
		this.players=players;
	}
	
	//Getters and Setters
	
	/**
	* This method returns the nickname of a winner player. <br>
	* <b>name</b>: getNickname <br>
	* <b>post</b>: the nickname of a winner player has been gotten. <br>
	* @return a <code> String </code> specifying nickname, the name of a winner player.
	*/
	
	public String getNickname() {
		return nickname;
	}
	
	/**
	* This method returns the symbol of a winner player. <br>
	* <b>name</b>: getSymbol <br>
	* <b>post</b>: the symbol of a winner player has been gotten. <br>
	* @return a <code> char </code> specifying symbol, the symbol of a winner player.
	*/
	
	public char getSymbol() {
		return symbol;
	}

	/**
	* This method returns the score of a winner player. <br>
	* <b>name</b>: getScore <br>
	* <b>post</b>: the score of a winner player has been gotten. <br>
	* @return an <code> Integer </code> specifying score, the score of a winner player.
	*/
	
	public int getScore() {
		return score;
	}
	
	/**
	* This method returns the element to the left of a winning player in the binary tree. <br>
	* <b>name</b>: getLeft <br>
	* <b>post</b>: the element to the left of a winning player in the binary tree has been gotten. <br>
	* @return a <code> Winner </code> specifying left, the element to the left of a winning player in the binary tree.
	*/
	
	public Winner getLeft() {
		return left;
	}
	
	/**
	* This method returns the element to the right of a winning player in the binary tree. <br>
	* <b>name</b>: getRight <br>
	* <b>post</b>: the element to the right of a winning player in the binary tree has been gotten. <br>
	* @return a <code> Winner </code> specifying right, the element to the right of a winning player in the binary tree.
	*/
	
	public Winner getRight() {
		return right;
	}
	
	/**
	* This method returns the parent element of a winning player in the binary tree. <br>
	* <b>name</b>: getParent <br>
	* <b>post</b>: the parent element of a winning player in the binary tree has been gotten. <br>
	* @return a <code> Winner </code> specifying parent, the element above of a winning player in the binary tree.
	*/
	
	public Winner getParent() {
		return parent;
	}
	
	/**
	* This method modifies the element to the left of a winning player in the binary tree. <br>
	* <b>name</b>: setLeft<br>
	* <b>post</b>: the element to the left of a winning player in the binary tree has been changed. <br>
	* @param left is an object of type Winner.
	*/

	public void setLeft(Winner left) {
		this.left = left;
	}
	
	/**
	* This method modifies the element to the right of a winning player in the binary tree. <br>
	* <b>name</b>: setRight<br>
	* <b>post</b>: the element to the right of a winning player in the binary tree has been changed. <br>
	* @param right is an object of type Winner.
	*/

	public void setRight(Winner right) {
		this.right = right;
	}
	
	/**
	* This method modifies the parent element of a winning player in the binary tree. <br>
	* <b>name</b>: setParent<br>
	* <b>post</b>: the element above of a winning player in the binary tree has been changed. <br>
	* @param parent is an object of type Winner.
	*/

	public void setParent(Winner parent) {
		this.parent = parent;
	}
	
	/**
	* This method returns the game settings. <br>
	* <b>name</b>: getGameSettings <br>
	* <b>post</b>: the game settings have been gotten. <br>
	* @return a <code> String </code> specifying gameSettings, the game settings.
	*/
	public String getGameSettings() {
		return gameSettings;
	}

	/**
	* This method returns the player symbols of the game. <br>
	* <b>name</b>: getPlayers <br>
	* <b>post</b>: the player symbols have been gotten. <br>
	* @return a <code> String </code> specifying players, the player symbols of the game.
	*/
	public String getPlayers() {
		return players;
	}

	
	
	/**
	* This method produces a String with all the information about Winner. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: All the information of a Winner was returned. <br>
 	* @return out in a <code> String </code> variable all the information about a Winner.
 	*/ 
	
	public String toString() {
		return symbol+"                "+"         "+nickname+"         "+"                           "+score+"         ";
	}

	
	
}
