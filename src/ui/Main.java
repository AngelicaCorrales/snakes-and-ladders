package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


import model.Game;
/*
import model.Grid;

public class Main {

	public static void main(String[] args) {

		Grid grid =new Grid(null, 2, 2, 5, 4);

		System.out.println(grid);

	}
}

*/

public class Main {

	private static BufferedReader br;
	private static BufferedWriter bw;
	private Game mainGame;

	public Main(){
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		mainGame = new Game();
	}

	public static void main(String[] args) throws IOException {
		bw.write("*******************************************************************************************************************************************************************");
		bw.write("\n                                                             ¡Bienvenido a Snakes and Ladders!                                                                     ");
		bw.write("\n*******************************************************************************************************************************************************************");
		Main objMain = new Main(); 
		correctOption(objMain,objMain.menu());
		bw.flush();
		br.close();
		bw.close();
	}

	public static void correctOption(Main m, int op) throws IOException {
		if(op!=3) {
			correctOption(m, m.menu());
		}
	}

	public int menu() throws IOException{
		int option = 0;
		boolean menu = true;
		try {
			bw.write(
					"\n**********************************************************************************\n"+
							"                         Seleccione una opcion para continuar                         "+
							"\n**********************************************************************************\n"+
							"      1. Comenzar juego\n"+
							"      2. Ver el tablero de posiciones\n"+
							"      3. Finalizar el programa\n"
					);
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
				bw.write("\n**********************************************************************************\n"+"Gracias por jugar"+"\n**********************************************************************************\n");
				menu = false;
				break;
			default:
				bw.write("Ingrese una opcion valida");
				break;	
			}		
			if(menu==true) {
				menu(); 
			}
		}catch(NumberFormatException num) {
			bw.write("Debe ingresar un numero entero que corresponda con las opciones presentadas.");
		}
		return option;
	}

	public void startGame() throws IOException {
		bw.write("\nPor favor ingrese el tamaño del tablero seguido de el numero de serpientes, escaleras y jugadores. Puede incluir los simbolos de los jugadores si lo desea, de lo contrario seran asignados aleatoriamente.");
		String line = br.readLine();
		if(line!=null && !line.equals("")) {
			String[] info = br.readLine().split(" ");
			if(info.length!=5) {
				bw.write("Debe ingresar toda la informacion solicitada");
				startGame();
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
						startGame();
					}else {
						verifyData(rows, cols, snakes, ladders, players);
					}
				}catch(NumberFormatException num) {
					if(players.length()>9) {
						bw.write("Lo sentimos, esta version del juego no esta disponible para mas de 9 jugadores");
						startGame();
					}else {
						int cont = 0;
						boolean correct = verifySymbols(players, cont); 
						if(correct==true) {
							verifyData(rows, cols, snakes, ladders, players);
						}else {
							bw.write("Los signos de los jugadores no coinciden con los predeterminados (* ! O X % $ # + &) o los simbolos de los jugadores se encuentran repetidos");
							startGame();
						}
					}
				}
			}
		}
	}

	private boolean verifySymbols(String players, int cont) {
		boolean correct = false;
		int c = 0;
		int times = 0;
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
			if(s!=symbol1 || s!=symbol2 || s!=symbol3 || s!=symbol4 || s!=symbol5 || s!=symbol6 || s!=symbol7 || s!=symbol8 || s!=symbol9) {
				return correct;
			}else {
				correct = searchPlayer(players, s, c, times);
				cont+=1;
				if(correct==false) {
					verifySymbols(players,cont);
				}
			}
		}
		return correct;
	}

	private boolean searchPlayer(String p, char s, int cont, int times) {
		boolean find = false;
		if(times<=1 && cont!=p.length()) {
			if(s!=p.charAt(cont)) {
				searchPlayer(p, s, (cont+=1), times);
			}else {
				times+=1;
				find = true;
				return find;
			}
		}
		return find;
	}

	private void verifyData(int rows, int cols, int snakes, int ladders, String players) throws IOException {
		if(rows<=0 || cols<=0 || snakes<=0 || ladders<=0 || (((snakes*2)+(ladders*2))>(rows*cols)) ) {
			if(((snakes*2)+(ladders*2))>(rows*cols)){
				bw.write("De acuerdo con las dimensiones del tablero ingresadas no es posible colocar el numero de serpientes o escaleras digitado");
			}else {
				bw.write("Las filas, columnas, serpientes o escaleras no pueden ser cero");
			}
			startGame();
		}else {
			mainGame.startGame(rows, cols, snakes, ladders, players);
		}
	}

	public void showPositionsBoard() {

	}
}

