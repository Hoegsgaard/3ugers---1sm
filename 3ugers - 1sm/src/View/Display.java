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
	
	public Boolean stageTax(GUI gui) {
		Boolean choice = gui.getUserLeftButtonPressed("Stats skat! betal 200kr eller 10% af din samlede indtægt", "200kr", "10%");
		return choice;
	}
	
	public Boolean buyBut(GUI gui) {
		return gui.getUserLeftButtonPressed("Vil du købe dette felt?", "Ja", "Nej");
	}
	
	public Boolean getOutBut(GUI gui) {
		return gui.getUserLeftButtonPressed("Hvordan vil du komme ud af fængsel", "100 kr", "Slå 2 ens");
	}
}
