package ui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

import model.Game;

//import model.Grid;

/*public class Main {

	public static void main(String[] args) {
		//Grid grid =new Grid(null, 0, 0, 5, 4);
		//System.out.println(grid);
		//System.out.println(grid.getFinalSquare());
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
		int option = 0;
		do{
			option = objMain.menu();
		} while(option!= 3);
		bw.flush();
		br.close();
		bw.close();
	}
	
	public int menu() throws IOException{
		int option = 0;
		boolean menu = true;
		boolean pass = true;
		do {
			try {
				while(menu){
					bw.write(
						"\n**********************************************************************************\n"+
						"                         Seleccione una opcion para continuar"+
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
							pass = false;
							break;
						case 2:
							showPositionsBoard();
							menu = false;
							pass = false;
							break;
						case 3:
							bw.write("\n**********************************************************************************\n"+"Gracias por jugar"+"\n**********************************************************************************\n");
							menu = false;
							pass = false;
							break;
						default:
							bw.write("Ingrese una opcion valida");
							menu = false;
							pass = false;
							break;	
					}		
				} 
			}catch(NumberFormatException num) {
				bw.write("Debe ingresar un numero entero que corresponda con las opciones presentadas.");
			}
		}while(pass);
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
					verifyData(rows, cols, snakes, ladders, players);
				}
			}
		}
	}
	
	private void verifyData(int rows, int cols, int snakes, int ladders, String players) throws IOException {
		if((rows<0 || rows==0)||(cols<0 || cols==0)||(snakes<0 || snakes==0)||(ladders<0 || ladders==0)||(((snakes*2)+(ladders*2))>(rows*cols))) {
			if(((snakes*2)+(ladders*2))>(rows*cols)){
				bw.write("De acuerdo con las dimensiones del tablero inrgesadas no es posible colocar el numero de serpientes o escaleras digitado");
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
