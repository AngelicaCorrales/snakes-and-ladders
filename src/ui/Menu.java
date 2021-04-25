package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import model.Game;

public class Menu {
	
	public BufferedReader br;
	public BufferedWriter bw;
	private Game mainGame;
	
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
	
	public void chooseOption(int op) throws IOException, InterruptedException {
		if(op!=3) {
			chooseOption(menuOptions());
		}
	}

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

	private boolean verifyData(int rows, int cols, int snakes, int ladders, String players) throws IOException, InterruptedException {
		boolean verify=false;
		if(rows<=2 || cols<=2 || rows<=0 || cols<=0 || snakes<=0 || ladders<=0 || (((snakes*2)+(ladders*2))>(rows*cols)) ) {
			verify=true;
			if(rows<=2 ||cols<=2||((snakes*2)+(ladders*2))>(rows*cols)){
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

	public void showPositionsBoard() throws IOException {
		bw.write("\n                                 **************************************************************************************************");
		bw.write("\n                                                                   Tablero de posiciones                                           ");
		bw.write("\n                                 **************************************************************************************************");
		bw.write("\n                                             Nickname        *            Simbolo               *               Puntaje            ");
		bw.write("\n                                 **************************************************************************************************");
		bw.write(mainGame.listWinnersInorder());
	}

	public void showGrid() throws IOException {
		bw.write("\n"+mainGame.getGrid().toString()+"\n");
	}

	public void showSimul() throws IOException, InterruptedException {
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

	public void registerWinner() throws IOException {
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
