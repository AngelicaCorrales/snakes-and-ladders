package model;

public class Winner {
	
	private String nickname;
	private String symbol;
	private int score;
	
	private Winner left;
	private Winner right;
	
	public Winner(String symbol, String nickname, int score) {
		this.symbol=symbol;
		this.nickname=nickname;
		this.score=score;
	}
	
	public String getNickname() {
		return nickname;
	}

	public String getSymbol() {
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
	
	/*public String toString() {
		
	}*/
}
