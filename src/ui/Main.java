package ui;

import java.io.IOException;
/**
 * This is the Main class.
 * @version 1
 * @author Angelica Corrales Quevedo, https://github.com/AngelicaCorrales
 * @author Keren Lopez Cordoba, https://github.com/KerenLopez
 */
public class Main {
	
	//Relationship
	private static Menu objMenu;

	public static void main(String[] args) throws IOException, InterruptedException {
		objMenu = new Menu();
		objMenu.mainMethod();;
	}
}

