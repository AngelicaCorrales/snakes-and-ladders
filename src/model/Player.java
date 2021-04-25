package model;

public class Player {

	//Attributes
	private char symbol;
	private int movements;
	
	//Relationships
	private Player next;
	private Player prev;
	
	/**
	*This is the constructor of the class. <br>
	*<b>name:</b> Player.<br>
	*<b>pre</b>: the variable symbol is already initialized. <br>
	*<b>post:</b> the attributes and relationships of the class have been initialized.<br>
	*@param symbol Is a char variable that contains the player's symbol. symbol=='*' or symbol== '!' or  symbol== 'O' or symbol== 'X' 
		 or symbol=='%' or	 symbol== '$' or symbol=='#' or symbol== '+' or symbol=='&'.<br>
	*/
	public Player(char symbol) {
		this.symbol = symbol;
		this.movements = 0;
	}

	/**
	*This method gets the number of movements of the player. <br>
	*<b>name:</b> getMovements.<br>
	*<b>post:</b> the number of movements has been gotten. <br>
	*@return an <code>integer</code> specifying movements, the number of movements of the player.
	*/
	public int getMovements() {
		return movements;
	}

	/**
	*This method sets the number of movements of the player. <br>
	*<b>name:</b> setMovements.<br>
	*<b>post:</b> the number of movements of the player has been set. <br>
	*@param movements Is an integer variable that contains the number of movements of the player. number greater than or equal to 0.<br>
	*/
	public void setMovements(int movements) {
		this.movements = movements;
	}

	/**
	*This method gets the symbol of the player. <br>
	*<b>name:</b> getSymbol.<br>
	*<b>post:</b> the symbol has been gotten. <br>
	*@return a <code>char</code> specifying symbol, the symbol of the player.
	*/
	public char getSymbol() {
		return symbol;
	}

	
	/**
	*This method gets the next player in the linked list.<br>
	*<b>name:</b> getNext.<br>
	*<b>post:</b> the next player has been gotten. <br>
	*@return a <code>Player</code> specifying next, the next player in the linked list.
	*/
	public Player getNext() {
		return next;
	}

	/**
	*This method sets the next player in the linked list. <br>
	*<b>name:</b> setNext.<br>
	*<b>post:</b> the next player in the linked list has been set. <br>
	*@param next Is a Player object that references the next player in the linked list.<br>
	*/
	public void setNext(Player next) {
		this.next = next;
	}

	/**
	*This method gets the previous player in the linked list.<br>
	*<b>name:</b> getPrev.<br>
	*<b>post:</b> the previous player has been gotten. <br>
	*@return a <code>Player</code> specifying prev, the previous player in the linked list.
	*/
	public Player getPrev() {
		return prev;
	}

	/**
	*This method sets the previous player in the linked list. <br>
	*<b>name:</b> setPrev.<br>
	*<b>post:</b> the previous player in the linked list has been set. <br>
	*@param prev Is a Player object that references the previous player in the linked list.<br>
	*/
	public void setPrev(Player prev) {
		this.prev = prev;
	}
	
}
