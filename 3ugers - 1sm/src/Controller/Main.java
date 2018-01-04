package Controller;

import Game.Game;
import View.View;
import gui_main.GUI;

public class Main {
	
	

	
	
	public static void main(String[] args) {
		GUI gui = null;
		View matador = new View();
		Game g1 = new Game();
		Controller cont = new Controller(matador, g1 , gui);
		matador.runGame();
		
	}

}
