package ui;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

import model.Game;
=======
//import model.Grid;

public class Main {

	public static void main(String[] args) {
		//Grid grid =new Grid(null, 0, 0, 5, 4);
		//System.out.println(grid);
		//System.out.println(grid.getFinalSquare());
>>>>>>> 1e7b118100bb7b96d57be879e137086f4275a77d

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
			int rows = Integer.parseInt(info[0]);
			int cols = Integer.parseInt(info[1]);
			int snakes = Integer.parseInt(info[2]);
			int ladders = Integer.parseInt(info[3]);
			String players = info[4];
			mainGame.startGame(rows, cols, snakes, ladders, players);
		}
		/*while(line!=null){
			int availableBooks = Integer.parseInt(line);
			String[] prices = br.readLine().split(" ");
			int peterMoney = Integer.parseInt(br.readLine());
			arrayOfPrices = new int[availableBooks];
			for(int k = 0;k<prices.length;k++) {
				arrayOfPrices[k] = Integer.parseInt(prices[k]);
			}
			Arrays.sort(arrayOfPrices);
			String message = findBooks(peterMoney);
			bw.write(message+"\n\n");
			line = br.readLine();
			line = br.readLine();
		}*/
	}
	
	public void showPositionsBoard() {
		
	}
}
