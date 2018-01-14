package Game;


import Controller.DiceController;
import Controller.MoveController;
import View.Display;
import gui_main.GUI;

public class Jail {
	boolean inJail = false;
	Display view = new Display();
	DiceController diceController = new DiceController();
	DiceController diceController2 = new DiceController();
	
	public void goToJail(Player player, GUI gui) {
		if(player.getCurrentField() == 30) {
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
			player.setCurrentField(10);
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
			if (player.getHasJailCard()) {
				player.setHasJailCard(false);
			}
			else {
				player.setInJail(true);
			}
		}
	}	
	public void getOutOfJail(Player player, GUI gui) {
		if (view.getOutBut(gui)) {
			player.setInJail(false);
			player.changeBalance(-100);
		}
		else {
			int rollOne = diceController.roll();
			int rollTow = diceController2.roll();
			gui.setDice(diceController.getFaceValue(), diceController2.getFaceValue());
			if (rollOne == rollTow) {
				player.setInJail(false);			
			}
		}
	}
}
