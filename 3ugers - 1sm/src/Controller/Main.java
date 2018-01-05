package Controller;

import Game.Dice;
import Game.Game;

public class Main {

	public static void main(String[] args) {
		DiceController dice1 = new DiceController();
		dice1.roll();
		Game matador = new Game();
		matador.runGame();
		
		

	}
}
