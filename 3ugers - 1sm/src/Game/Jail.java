package Game;


import Controller.DiceController;
import Controller.MoveController;
import gui_main.GUI;

public class Jail {
	boolean inJail = false;
	MoveController move = new MoveController();
	DiceController diceController = new DiceController();
	DiceController diceController2 = new DiceController();
	
	

	
	public void goToJail(Player player, GUI gui) {
		if(player.getCurrentField() == 30) {
			move.setPlayerPos(player, player.getCurrentField(), gui);
			
		}
		
	}	

}
