package Controller;

import Game.ChanceCard;
import Game.GameBoard;
import Game.Player;
import gui_main.GUI;


public class MoveController {
	GameBoard board = new GameBoard();
	GUI gui = new GUI(board.getFields());
	ChanceCard cc = new ChanceCard();
	Controller controller = new Controller();
	
	private static MoveController instance;
	
	public static MoveController getInstance() {
		if(instance == null) {
			instance = new MoveController();
		}
		return instance;
		
	}

	public void movePlayer(Player player, GUI gui, int dist) {
		int field = player.getCurrentField();
		// Removes the brick from the current field.
		gui.getFields()[ player.getCurrentField()].setCar(player.getCarObject(), false);
		// Updates the player object.
		player.setCurrentField( player.getCurrentField() + dist);
		// Places the player's brick on the new field.
		gui.getFields()[ player.getCurrentField()].setCar(player.getCarObject(), true);
		//Checks if they player has to go to jail or draw a chancecard.
		if(field == 2 || field == 7 || field == 17 || field == 22 || field == 33 || field == 36) {
			cc.drawCard(player, controller.getPlayers());
		} 
//		else if (gui.getFields()[player.getCurrentField()] == fields[18]) {
//				goToJail(player, gui);
//		}
	}
	
}
