package Controller;

import Game.Dice;
import Game.Game;

public class Main {

	
	public static void main(String[] args) {
		DiceController dice1 = new DiceController();
		Controller controller = new Controller();
		dice1.roll();
		Game matador = new Game();
		controller.runGame();
	}
}
