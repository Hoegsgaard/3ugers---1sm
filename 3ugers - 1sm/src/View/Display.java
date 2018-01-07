package View;

import gui_main.GUI;

public class Display {
	
	


	public int enterPlayers(GUI gui) {
		//Accepts a number of players and keeps trying until the
		//Entered number is between 2 and 6.
		int amountOfPlayers = gui.getUserInteger("How many players? Min. 2 and Max. 6.");
		return amountOfPlayers;
	}
	
	
	public void rollDiceButton(GUI gui) {
		gui.getUserButtonPressed("Press Enter", "Roll");
		
		
	}
	

		
}
