package model;

/**
 * This class contains attributes, relationships, and methods of a square.
 * @version 1
 * @author Angelica Corrales Quevedo, https://github.com/AngelicaCorrales
 * @author Keren Lopez Cordoba, https://github.com/KerenLopez
 */
public class Square {
	//Attributes
	private int num;
	private char snake;
	private int ladder;
	private int col;
	private int row;
	
	//Relationships
	private Player firstPlayer;
	private Player finalPlayer;
	private Square next;
	private Square prev;
	private Square up;	
	private Square down;
	private Square finalLadder;
	private Square finalSnake;

	/**
	*This is the constructor of the class. <br>
	*<b>name:</b> Square. <br>
	*<b>pre</b>: the variables row and col are already initialized. <br>
	*<b>post:</b> the attributes of the class have been initialized.<br>
	*@param row Is an integer variable that contains the number of the row for the square in the grid. row greater than or equal to 0.<br>
	*@param col Is an integer variable that contains the number of the column for the square in the grid. col greater than or equal to 0.<br>
	*/
	public Square(int row, int col) {
		this.col = col;
		this.row = row;
	}
	
	/**
	*This method gets the respective next square in the linked matrix of squares. <br>
	*<b>name:</b> getNext.<br>
	*<b>post:</b> the next square has been gotten. <br>
	*@return an <code>Square</code> specifying next, the respective next square in the linked matrix of squares.
	*/
	public Square getNext() {
		return next;
	}

	/**
	*This method gets the respective previous square in the linked matrix of squares. <br>
	*<b>name:</b> getPrev.<br>
	*<b>post:</b> the previous square has been gotten. <br>
	*@return an <code>Square</code> specifying prev, the respective previous square in the linked matrix of squares.
	*/
	public Square getPrev() {
		return prev;
	}

	/**
	*This method gets the respective upper square in the linked matrix of squares. <br>
	*<b>name:</b> getUp.<br>
	*<b>post:</b> the upper square has been gotten. <br>
	*@return an <code>Square</code> specifying up, the respective upper square in the linked matrix of squares.
	*/
	public Square getUp() {
		return up;
	}

	/**
	*This method gets the respective down square in the linked matrix of squares. <br>
	*<b>name:</b> getDown.<br>
	*<b>post:</b> the down square has been gotten. <br>
	*@return an <code>Square</code> specifying down, the respective down square in the linked matrix of squares.
	*/
	public Square getDown() {
		return down;
	}
	
	/**
	*This method sets the respective previous square in the linked matrix of squares. <br>
	*<b>name:</b> setPrev.<br>
	*<b>post:</b> the previous square has been set. <br>
	*@param p Is a Square object that references the respective previous square in the linked matrix of squares.<br>
	*/
	public void setPrev(Square p) {
		prev = p;
	}

	/**
	*This method sets the respective next square in the linked matrix of squares. <br>
	*<b>name:</b> setNext.<br>
	*<b>post:</b> the next square has been set. <br>
	*@param n Is a Square object that references the respective next square in the linked matrix of squares.<br>
	*/
	public void setNext(Square n) {
		next = n;
	}

	/**
	*This method sets the respective upper square in the linked matrix of squares. <br>
	*<b>name:</b> setUp.<br>
	*<b>post:</b> the upper square has been set. <br>
	*@param u Is a Square object that references the respective upper square in the linked matrix of squares.<br>
	*/
	public void setUp(Square u) {
		up = u;
	}

	/**
	*This method sets the respective down square in the linked matrix of squares. <br>
	*<b>name:</b> setDown.<br>
	*<b>post:</b> the down square has been set. <br>
	*@param d Is a Square object that references the respective down square in the linked matrix of squares.<br>
	*/
	public void setDown(Square d) {
		down = d;
	}
	
	/**
	*This method gets the number of the square on the grid. <br>
	*<b>name:</b> getNum.<br>
	*<b>post:</b> the number of the square has been gotten. <br>
	*@return an <code>integer</code> specifying num, the number of the square in the grid.
	*/
	public int getNum() {
		return num;
	}

	/**
	*This method sets the number of the square on the grid. <br>
	*<b>name:</b> setNum.<br>
	*<b>post:</b> the number of the square has been set. <br>
	*@param num Is an integer variable that contains the number for the square in the grid. num greater than or equal to 1.<br>
	*/
	public void setNum(int num) {
		this.num = num;
	}

	/**
	*This method gets the snake in the square. <br>
	*<b>name:</b> getSnake.<br>
	*<b>post:</b> the snake has been gotten. <br>
	*@return a <code>char</code> specifying snake, the snake in the square.
	*/
	public char getSnake() {
		return snake;
	}

	/**
	*This method sets the snake in the square. <br>
	*<b>name:</b> setSnake.<br>
	*<b>post:</b> the snake has been set. <br>
	*@param snake Is a char variable that contains the snake for the square. snake greater than or equal to 'A'.<br>
	*/
	public void setSnake(char snake) {
		this.snake = snake;
	}

	/**
	*This method gets the ladder in the square. <br>
	*<b>name:</b> getLadder.<br>
	*<b>post:</b> the ladder has been gotten. <br>
	*@return an <code>integer</code> specifying ladder, the ladder in the square.
	*/
	public int getLadder() {
		return ladder;
	}

	/**
	*This method sets the ladder in the square. <br>
	*<b>name:</b> setLadder.<br>
	*<b>post:</b> the ladder has been set. <br>
	*@param ladder Is an integer variable that contains the ladder for the square. ladder greater than or equal to 1.<br>
	*/
	public void setLadder(int ladder) {
		this.ladder = ladder;
	}

	/**
	*This method gets the first player in the square.<br>
	*<b>name:</b> getFirstPlayer.<br>
	*<b>post:</b> the first player has been gotten. <br>
	*@return a <code>Player</code> specifying firstPlayer, the first player in the square.
	*/
	public Player getFirstPlayer() {
		return firstPlayer;
	}
	
	/**
	*This method gets the number of the column for the square in the grid. <br>
	*<b>name:</b> getCol.<br>
	*<b>post:</b> the number of the column for the square has been gotten. <br>
	*@return an <code>integer</code> specifying col, the number of the column for the square in the grid.
	*/
	public int getCol() {
		return col;
	}

	/**
	*This method gets the number of the row for the square in the grid. <br>
	*<b>name:</b> getRow.<br>
	*<b>post:</b> the number of the row for the square has been gotten. <br>
	*@return an <code>integer</code> specifying row, the number of the row for the square in the grid.
	*/
	public int getRow() {
		return row;
	}
	
	/**
	*This method gets the square where the ladder ends in the linked matrix of squares. <br>
	*<b>name:</b> getFinalLadder.<br>
	*<b>post:</b> the square where the ladder ends has been gotten. <br>
	*@return an <code>Square</code> specifying finalLadder, the square where the ladder ends in the linked matrix of squares.
	*/
	public Square getFinalLadder() {
		return finalLadder;
	}

	/**
	*This method sets the square where the ladder ends in the linked matrix of squares. <br>
	*<b>name:</b> setFinalLadder.<br>
	*<b>post:</b> the square where the ladder ends has been set. <br>
	*@param finalLadder Is a Square object that references the square where the ladder ends in the linked matrix of squares.<br>
	*/
	public void setFinalLadder(Square finalLadder) {
		this.finalLadder = finalLadder;
	}

	/**
	*This method gets the square where the snake ends in the linked matrix of squares. <br>
	*<b>name:</b> getFinalLadder.<br>
	*<b>post:</b> the square where the snake ends has been gotten. <br>
	*@return an <code>Square</code> specifying finalLadder, the square where the snake ends in the linked matrix of squares.
	*/
	public Square getFinalSnake() {
		return finalSnake;
	}

	/**
	*This method sets the square where the snake ends in the linked matrix of squares. <br>
	*<b>name:</b> setFinalSnake.<br>
	*<b>post:</b> the square where the snake ends has been set. <br>
	*@param finalSnake Is a Square object that references the square where the snake ends in the linked matrix of squares.<br>
	*/
	public void setFinalSnake(Square finalSnake) {
		this.finalSnake = finalSnake;
	}
	
	/**
	*This method adds a player to the linked list of players in the square. <br>
	*<b>name:</b> addPlayer.<br>
	*<b>pre</b>: player is already initialized.   <br>
	*<b>post:</b> the player has been added to the square. <br>
	*@param player Is a Player object that references the player that wants to be added to the square. player!=null<br>
	*/
	private void addPlayer(Player player) {
		//AT THE TOP OF THE LIST
		if(player!=firstPlayer || player!=finalPlayer) {
			player.setNext(firstPlayer);
			if(firstPlayer==null) {
				finalPlayer=player;
			}else {
				firstPlayer.setPrev(player);
			}
			firstPlayer=player;
			if(firstPlayer.getNext()==null) {
				finalPlayer=firstPlayer;
			}
		}
	}
	
	/**
	*This method removes a player from the linked list of players in the square. <br>
	*<b>name:</b> removePlayer.<br>
	*<b>pre</b>: player is already initialized.   <br>
	*<b>post:</b> the player has been removed from the square. <br>
	*@param player Is a Player object that references the player that wants to be removed from the square. player!=null<br>
	*/
	private void removePlayer(Player player) {
		if(player.getSymbol()==finalPlayer.getSymbol()) {
			Player prev=player.getPrev();
			if(prev!=null) {
				prev.setNext(null);
				
			}
			if(player==firstPlayer) {
				
				if(prev!=null && prev.getPrev()==null) {
					firstPlayer=prev;
				}
				if(prev==null) {
					firstPlayer=prev;
				}
			}
			player.setPrev(null);
			finalPlayer=prev;
		}
	}
	
	/**
	*This method moves a player from the current square to the player's destination square. <br>
	*<b>name:</b> movePlayer.<br>
	*<b>pre</b>: square and player are already initialized.   <br>
	*<b>post:</b> the player has been moved from the current square to the player's destination square. <br>
	*@param square Is a Square object that references the player's destination square. square!=null<br>
	*@param player Is a Player object that references the player that wants to be moved. player!=null<br>
	*/
	public void movePlayer(Square square, Player player) {
		
		removePlayer(player);
		square.addPlayer(player);
		player.setMovements(player.getMovements()+1);
	}

	/**
	*This method adds all the players to the linked list of players in the first square of the grid. <br>
	*<b>name:</b> addPlayers.<br>
	*<b>pre</b>: players and cont are already initialized.   <br>
	*<b>post:</b> players have been added to the first square of the grid. <br>
	*@param players Is a String variable that contains the symbols of the players for the game. players!=null and players!="".<br>
	*@param cont Is an integer variable that contains the index to obtain each player from the string of players. cont greater than or equal to 0.<br>
	*/
	public void addPlayers(String players, int cont) {
		if(cont!=players.length()) {
			Player player = new Player(players.charAt(cont));
			addPlayer(player);
			cont+=1;
			addPlayers(players, cont);
			
		}
	}

	
	/**
	*This method searches the player in the current square.<br>
	*<b>name:</b> searchPlayer.<br>
	*<b>pre</b>: player is already initialized.   <br>
	*<b>post:</b> the searched player could have been found. <br>
	*@param player Is a char variable that contains the player's symbol. player=='*' or player== '!' or  player== 'O' or player== 'X' 
		 or player=='%' or	 player== '$' or player=='#' or player== '+' or player==38.<br>
	*@return a <code>Player</code> that might correspond to the searched player.
	*/
	public Player searchPlayer(char player) {
		
		return searchPlayer( finalPlayer, player);
	}
	
	/**
	*This method searches the player in the linked list of players of the current square.<br>
	*<b>name:</b> searchPlayer.<br>
	*<b>pre</b>: player is already initialized.   <br>
	*<b>post:</b> the searched player could have been found. <br>
	*@param player Is a char variable that contains the player's symbol. player=='*' or player== '!' or  player== 'O' or player== 'X' 
		 or player=='%' or	 player== '$' or player=='#' or player== '+' or player==38.<br>
	*@param current Is a Player object that references a player in the linked list of players.<br>
	*@return a <code>Player</code> specifying p, that might correspond to the searched player.
	*/
	private Player searchPlayer(Player current, char player) {
		Player p=null;
		if(current!=null && p==null) {
			if(current.getSymbol()==player) {
				 p=current;
			}else {
				current=current.getPrev();
				p=searchPlayer(current, player);
			}
		}
		return p;
	}
	
	/**
	* This method obtains a String with players on the square. <br>
	* <b>name</b>: playerString.<br>
 	* <b>post</b>: players have been obtained. <br>
	*@param player Is a Player object that references a player in the linked list of players.<br>
 	* @return a <code> String </code> specifying s, players on the square.
 	*/ 
	private String playerString(Player player) {
		String s="";
		if(player!=null) {
			s+=String.valueOf(player.getSymbol());
			if(player.getPrev()!=null){
						
				s+=playerString(player.getPrev());
			}
		}
		return s;
	}
	
	/**
	* This method obtains a String with players on the square. <br>
	* <b>name</b>: playerString.<br>
 	* <b>post</b>: players have been obtained. <br>
 	* @return a <code> String </code> that obtains players on the square.
 	*/ 
	private String playerString() {
		return playerString(finalPlayer);
	}
	
	/**
	* This method obtains a String with the numbered square, with its snake or ladder. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the square has been obtained. <br>
 	* @return a <code> String </code> specifying the numbered square, with its snake or ladder.
 	*/ 
	public String toString() {
		String ladderString="";
		if(ladder!=0) {
			ladderString=String.valueOf(ladder);
		}
		return "["+num+ladderString+snake+"]";
	}
	
	/**
	* This method obtains a String with the square, with its snake or ladder. <br>
	* <b>name</b>: toString2.<br>
 	* <b>post</b>: the square has been obtained. <br>
 	* @return a <code> String </code> specifying the square, with its snake or ladder.
 	*/ 
	public String toString2() {
		String ladderString="";
		if(ladder!=0) {
			ladderString=String.valueOf(ladder);
		}
		return "["+ladderString+snake+playerString()+"]";
	}
		
	
}
