package model;

import java.io.Serializable;

public class Winner implements Serializable{
	
	private static final long serialVersionUID = 1;
	private String nickname;
	private char symbol;
	private int score;
	
	private Winner left;
	private Winner right;
	private Winner parent;

	public Winner(char symbol, String nickname, int score) {
		this.symbol=symbol;
		this.nickname=nickname;
		this.score=score;
	}
	
	public String getNickname() {
		return nickname;
	}

	public char getSymbol() {
		return symbol;
	}

	public int getScore() {
		return score;
	}
	
	public Winner getLeft() {
		return left;
	}

	public void setLeft(Winner left) {
		this.left = left;
	}

	public Winner getRight() {
		return right;
	}

	public void setRight(Winner right) {
		this.right = right;
	}
	
	public String toString() {
		return "\n                                                "+symbol+"                "+"         "+nickname+"         "+"                        "+score+"         ";
	}

	public Winner getParent() {
		return parent;
	}

	public void setParent(Winner parent) {
		this.parent = parent;
	}
	
}
