package Game;

import Controller.Controller;
import Controller.DiceController;
import gui_main.GUI;

public class Jail {
	boolean inJail = false;
	Controller controller = new Controller();
	DiceController diceController = new DiceController();
	DiceController diceController2 = new DiceController();
	
	public void inJail(Player player, int sum, GUI gui) {
		while(inJail) {
			if(diceController.getFaceValue() == diceController2.getFaceValue()){
				inJail = false;
				controller.movePlayer(player, gui, sum);
			}
			controller.movePlayer(player, gui, 0);
		}
		
		
	}
	public void goToJail(Player player, GUI gui, int dist) {
		controller.movePlayer(player, gui, dist);
		
	}

}
