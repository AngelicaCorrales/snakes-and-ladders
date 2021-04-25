package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import model.Game;

/**
 * This class contains attributes, relationship and methods of the menu .
 * @version 1
 * @author Angelica Corrales Quevedo, https://github.com/AngelicaCorrales
 * @author Keren Lopez Cordoba, https://github.com/KerenLopez
 */
public class Menu {
	
	//Attributes
	public BufferedReader br;
	public BufferedWriter bw;
	
	//Relationship
	private Game mainGame;
	
	/**
	* Builder method <br>
	* <b>name</b>: Menu <br>
	* <b>post</b>: The attributes and relationship of the class were initialized. <br>
	* @throws IOException <br>
	*/
	
	public Menu() throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		mainGame = new Game();
		boolean loadData;
		try {
			loadData = mainGame.loadWinners();
		} catch (ClassNotFoundException | IOException e) {
			loadData = false;
			if(!loadData) {
				bw.write("Error al cargar los ganadores del juego");
				bw.flush();
			}
		}
	}
	
	/**
	* This method calls the menu and sends the option chosen by the user to another method.<br>
	* <b>name</b>: mainMethod <br>
	* <b>post</b>: The menu was called and the option chosen by the user was sent to another method. <br>
	* @throws IOException <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
    * @throws InterruptedException <br>
	* 		thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity. <br>       
	*/
	
	public void mainMethod() throws IOException, InterruptedException {
		bw.write("\n*******************************************************************************************************************************************************************");
		bw.flush();
		bw.write("\n                                                             ¡Bienvenido a Snakes and Ladders!                                                                     ");
		bw.flush();
		bw.write("\n*******************************************************************************************************************************************************************"); 
		bw.flush();
		chooseOption(menuOptions());
		br.close();
		bw.close();
	}
	
	/**
	* This method calls the menu in case that the user chose an incorrect option.<br>
	* <b>name</b>: chooseOption <br>
	* <b>post</b>: The menu was called again if the option chosen by the user was incorrect. <br>
	* @param op Is an Integer variable that contains the number of the option chosen by the user. <br>
	* @throws IOException <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
    * @throws InterruptedException <br>
	* 		thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity. <br>       
	*/
	
	public void chooseOption(int op) throws IOException, InterruptedException {
		if(op!=3) {
			chooseOption(menuOptions());
		}
	}

	/**
	* This method shows the options available to the user.<br>
	* <b>name</b>: menuOptions <br>
	* <b>post</b>: All the options of the program were displayed to the user. <br>
	* @throws IOException <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
    * @throws InterruptedException <br>
	* 		thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity. <br>       
	 * @return an <code> Integer </code> specifying option, a variable that contains the number of the option chosen by the user.
	*/
	
	public int menuOptions() throws IOException, InterruptedException{
		int option = 0;
		boolean menu = true;
		try {
			bw.write(
					"\n*******************************************************************************************************************************************************************\n"+
							"                                                            Seleccione una opcion para continuar                         "+
							"\n*******************************************************************************************************************************************************************\n"+
							"      1. Comenzar juego\n"+
							"      2. Ver el tablero de posiciones\n"+
							"      3. Finalizar el programa\n"
					);
			bw.flush();
			option = Integer.parseInt(br.readLine());
			switch(option){
			case 1:
				startGame();
				menu = false;
				break;
			case 2:
				showPositionsBoard();
				menu = false;
				break;
			case 3:
				bw.write("\n*******************************************************************************************************************************************************************\n"+"Gracias por jugar"+"\n*******************************************************************************************************************************************************************\n");
				bw.flush();
				menu = false;
				break;
			default:
				bw.write("Ingrese una opcion valida");
				bw.flush();
				break;	
			}		
			if(menu==true) {
				menuOptions(); 
			}
		}catch(NumberFormatException num) {
			bw.write("Debe ingresar un numero entero que corresponda con las opciones presentadas.");
			bw.flush();
		}
		return option;
	}

	/**
	* This method allows the user to enter the text string that contains all the information about the game (number of rows and columns of the board, plus the snakes, ladders and players).<br>
	* <b>name</b>: startGame <br>
	* <b>post</b>: The user was able to enter the text string with all its features. <br>
	* @throws IOException <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
    * @throws InterruptedException <br>
	* 		thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity. <br>       
	*/
	
	public void startGame() throws IOException, InterruptedException {
		bw.write("\nPor favor ingrese las filas y columnas tablero seguido de el numero de serpientes, escaleras y jugadores. Puede incluir los simbolos de los jugadores si lo desea, de lo contrario seran asignados aleatoriamente.\n");
		bw.flush();
		String line = br.readLine();
		if(line!=null) {
			line = line.trim();
			String[] info = line.split(" ");
			if(info.length!=5) {
				bw.write("Debe ingresar toda la informacion solicitada correctamente");
				bw.flush();
				startGame();
				return;
			}else {
				int rows = Integer.parseInt(info[0]);
				int cols = Integer.parseInt(info[1]);
				int snakes = Integer.parseInt(info[2]);
				int ladders = Integer.parseInt(info[3]);
				String players = info[4];
				int p = 0;
				try {
					p = Integer.parseInt(players);
					if(p>9) {
						bw.write("Lo sentimos, esta version del juego no esta disponible para mas de 9 jugadores");
						bw.flush();
						startGame();
					}else if(p<=0) {
						bw.write("El numero de jugadores no puede ser menor o igual a cero");
						bw.flush();
						startGame();
						return;
					}
					if(verifyData(rows, cols, snakes, ladders, players)) {
						startGame();
						return;
					}
				}catch(NumberFormatException num) {
					if(players.length()>9) {
						bw.write("Lo sentimos, esta version del juego no esta disponible para mas de 9 jugadores");
						bw.flush();
						startGame();
						return;
					}else {
						int cont = 0;
						int times = 0;
						boolean correct = verifySymbols(players, cont, times); 
						if(correct==false) {
							if(verifyData(rows, cols, snakes, ladders, players)) {
								startGame();
								return;
							}
						}else {
							bw.write("Los signos de los jugadores no coinciden con los predeterminados (* ! O X % $ # + &) o los simbolos de los jugadores se encuentran repetidos");
							bw.flush();
							startGame();
							return;
						}
					}
				}
			}
			showGrid();
			bw.write("Presione enter para continuar");
			bw.flush();
			line = br.readLine();
			if(line!=null) {
				showGameBoard();
			}
		}
	}

	/**
	* This method displays the board throughout the game and allows the user to enter commands such as num, simul or menu.<br>
	* <b>name</b>: showGameBoard <br>
	* <b>post</b>: The game board was displayed throughout the game and the user could enter commands if he/she desired. <br>
	* @throws IOException <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
    * @throws InterruptedException <br>
	* 		thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity. <br>       
	*/
	
	private void showGameBoard() throws IOException, InterruptedException {
		bw.write("\n"+mainGame.getGrid().toString2()+"\n");
		bw.write("Presione enter para continuar o digite los comandos num, simul o menu si lo desea.\n");
		bw.flush();
		String line = br.readLine();
		if(line!=null) {
			if(line.equals("")) {
				String msg = mainGame.throwDie();
				bw.write(msg);
				bw.flush();
				if(mainGame.endGame()==false) {
					showGameBoard();
				}else {
					bw.write("\n"+mainGame.getGrid().toString2()+"\n");
					bw.flush();
					registerWinner();
				}
			}else if(line.equalsIgnoreCase("num")) {
					showGrid();
					bw.write("Presione enter para continuar");
					bw.flush();
					line = br.readLine();
					if(line!=null) {
						showGameBoard();
					}
			}else if(line.equalsIgnoreCase("simul")){
				showSimul();
			}else if(line.equalsIgnoreCase("menu")) {
				menuOptions();
			}else {
				bw.write("El comando ingresado no es valido\n");
				bw.flush();
				showGameBoard();
			}
		}
	}

	/**
	* This method verifies that the symbols entered by the user are correct (that they correspond to the default signs and that they are not repeated). <br>
	* <b>name</b>: verifySymbols <br>
	* <b>pre</b>: The variables players, cont and times are already initialized. <br>
	* <b>post</b>: True or false was returned depending of the verifications carried out with the symbols. <br>
	* @param times Is an Integer variable that will contains the number of times that a given symbol is encountered in the text string.<br>
	* @param cont Is an Integer variable that will contain the position of a letter within the text string.<br>
	* @param players Is a String variable that contains all the symbols of the players. players!="", players!=null.<br>
	* @return a <code> boolean </code> specifying correct, a variable that indicates if all the symbols that were entered are correct. 
	*/
	
	private boolean verifySymbols(String players, int cont, int times) {
		boolean correct = false;
		int c = 0;
		char s = players.charAt(cont);
		char symbol1 = '*';
		char symbol2 = '!';
		char symbol3 = 'O';
		char symbol4 = 'X';
		char symbol5 = '%';
		char symbol6 = '$';
		char symbol7 = '#';
		char symbol8 = '+';
		char symbol9 = '&';
		if(cont!=players.length()) {
			if(s!=symbol1 && s!=symbol2 && s!=symbol3 && s!=symbol4 && s!=symbol5 && s!=symbol6 && s!=symbol7 && s!=symbol8 && s!=symbol9) {
				return correct;
			}else {
				correct = searchPlayer(players, s, c, times);
				cont+=1;
				if(correct==false && cont!=players.length()) {
					verifySymbols(players,cont, times);
				}
			}
		}
		return correct;
	}

	/**
	* This method verifies that a certain symbol isn't repeated (that another player has the same) in the whole text string. <br>
	* <b>name</b>: searchPlayer <br>
	* <b>pre</b>: The variables p, s, cont and times are already initialized. <br>
	* <b>post</b>: True or false was returned depending of the result of the verification. <br>
	* @param times Is an Integer variable that will contains the number of times that a given symbol is encountered in the text string.<br>
	* @param cont Is an Integer variable that will contain the position of a letter within the text string.<br>
	* @param p Is a String variable that contains all the symbols of the players. p!="" p!=null.<br>
	* @param s Is a char variable that contains all the symbols of the players. p!='' p!=null.<br>
	* @return a <code> boolean </code> specifying find, a variable that indicates if a certain symbol that was entered is correct. 
	*/
	
	private boolean searchPlayer(String p, char s, int cont, int times) {
		boolean find = false;
		if(times<=1 && cont!=p.length()) {
			if(s!=p.charAt(cont)) {
				find = searchPlayer(p, s, (cont+=1), times);
			}else {
				times+=1;
				find = searchPlayer(p, s, (cont+=1), times);
			}
		}else if(times==2) {
			find = true;
		}
		return find;
	}
	
	/**
	* This method verifies that the number of rows, columns, snakes and ladders entered by the user is correct. <br>
	* <b>name</b>: verifyData <br>
	* <b>pre</b>: The variables rows, cols, snakes, ladders and players are already initialized. <br>
	* <b>post</b>: True or false was returned according to the verification. <br>
	* @param snakes Is an Integer variable that contains the number of snakes for the game.<br>
	* @param ladders Is an Integer variable that contains the number of ladders for the game.<br>
	* @param rows Is an Integer variable that contains the number of rows for the game.<br>
	* @param cols Is an Integer variable that contains the number of columns for the game.<br>
	* @param players Is a String variable that contains the players for the game. p!="" and p!=null.<br>
	* @throws IOException <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
    * @throws InterruptedException <br>
	* 		thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity. <br>       
	* @return a <code> boolean </code> specifying verify, a variable that indicates if the number of rows, columns, snakes and ladders are correct. 
	*/

	private boolean verifyData(int rows, int cols, int snakes, int ladders, String players) throws IOException, InterruptedException {
		boolean verify=false;
		if((rows<=2 && cols<=2) || rows<=1 || cols<=1 || snakes<=0 || ladders<=0 || (((snakes*2)+(ladders*2))>(rows*cols)) ) {
			verify=true;
			if((rows<=2 && cols<=2) || rows<=1 || cols<=1||((snakes*2)+(ladders*2))>(rows*cols)){
				bw.write("De acuerdo con las dimensiones del tablero ingresadas no es posible colocar el numero de serpientes o escaleras digitado");
				bw.flush();
			}else {
				bw.write("Las filas, columnas, serpientes o escaleras no pueden ser menores o iguales a cero");
				bw.flush();
			}
			
		}else {
			mainGame.startGame(rows, cols, snakes, ladders, players);
		}
		return verify;
	}

	/**
	* This method displays the leaderboard of winners according to their score.<br>
	* <b>name</b>: showPositionsBoard <br>
	* <b>post</b>: The leaderboard of winners was displayed. <br>
	* @throws IOException <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
	*/
	
	public void showPositionsBoard() throws IOException {
		bw.write("\n                                 **************************************************************************************************");
		bw.write("\n                                                                   Tablero de posiciones                                           ");
		bw.write("\n                                 **************************************************************************************************");
		bw.write("\n                                             Nickname        *            Simbolo               *               Puntaje            ");
		bw.write("\n                                 **************************************************************************************************");
		bw.write(mainGame.listWinnersInorder());
	}

	/**
	* This method displays the game board with the players, snakes, leaders and boxes listed.<br>
	* <b>name</b>: showGrid <br>
	* <b>post</b>: The game board was displayed with all the required features. <br>
	* @throws IOException <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
	*/
	
	private void showGrid() throws IOException {
		bw.write("\n"+mainGame.getGrid().toString()+"\n");
	}
	
	/**
	* This method allows the game to run automatically without waiting for a line break by the user and within two seconds between each move.<br>
	* <b>name</b>: showSimul <br>
	* <b>post</b>: The game automatically ran successfully. <br>
	* @throws IOException <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
    * @throws InterruptedException <br>
	* 		thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity. <br>       
	*/

	private void showSimul() throws IOException, InterruptedException {
		String msg = mainGame.throwDie();
		bw.write(msg);
		bw.flush();
		bw.write("\n"+mainGame.getGrid().toString2()+"\n");
		bw.flush();
		if(mainGame.endGame()==false) {
			Thread.sleep(2000);
			showSimul();
		}else {
			registerWinner();
		}
	}

	/**
	* This method allows the user to enter the name or nickname of the winning player to be added to the leaderboard.<br>
	* <b>name</b>: registerWinner <br>
	* <b>post</b>: The user was able to enter the name or nickname of the winner player. <br>
	* @throws IOException <br>
	* 		thrown if...
	* 		1. A local file that was no longer available is being read.<br>
    *       2. Any process closed the stream while a stream is being used to read data.<br>
    *       3. The disk space was no longer available while trying to write to a file.<br>
	*/
	
	private void registerWinner() throws IOException {
		bw.write("\nPor favor ingrese el apodo o nombre del jugador ganador: \n");
		bw.flush();
		String line = br.readLine();
		if(line!=null && !line.equals("")) {
			mainGame.addWinner(line);
		}else{
			registerWinner();
		}
	}
}
