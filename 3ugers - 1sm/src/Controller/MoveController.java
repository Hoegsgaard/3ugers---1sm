package Controller;

import gui_main.GUI;
import Game.Jail;
import Game.Player;

public class MoveController {
	Jail jail = new Jail();
	public void movePlayer(Player player, GUI gui, int dist) {
		// Removes the brick from the current field.
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
		// Updates the player object.
		player.setCurrentField(player.getCurrentField() + dist);
		// Places the player's brick on the new field.
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
	}
	public void moveToJail(Player player, GUI gui) {
		jail.goToJail(player, gui);
	}
	
	public void setPlayerPos(Player player, int field, GUI gui) { //set's the position of the player
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false); //removes the car
		player.setCurrentField(field);
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);  //draws the car
	}
}