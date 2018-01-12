package View;

import Game.Player;
import gui_main.GUI;

public class Display {

	public int enterPlayers(GUI gui) {
		// Accepts a number of players and keeps trying until the
		// Entered number is between 2 and 6.
		int amountOfPlayers = gui.getUserInteger("How many players? Min. 2 and Max. 6.");
		return amountOfPlayers;
	}

	public String rollDiceButton(GUI gui, Player player) {
		return gui.getUserButtonPressed("Det er " + player.getName() + "'s tur!", "Rul","Byg hus", "Byt", "Slut tur");
	}

	public Boolean stageTax(GUI gui) {
		Boolean choice = gui.getUserLeftButtonPressed("Stats skat! betal 200kr eller 10% af din samlede indtægt",
				"200kr", "10%");
		return choice;
	}

	public Boolean buyBut(GUI gui) {
		return gui.getUserLeftButtonPressed("Vil du købe dette felt?", "Ja", "Nej");
	}
	
	public Boolean getOutBut(GUI gui) {
		return gui.getUserLeftButtonPressed("Hvordan vil du komme ud af fængsel", "100 kr", "Slå 2 ens");
	}
	
	public String buildOnColor(GUI gui) {
		return gui.getUserSelection("Hvor vil du bygge?", "Cyan", "Pink", "Grøn", "Grå", "Rød", "Hvid", "Gul", "Lilla");
	}
	
	public String tradeWith(GUI gui, String[] player)  {
		return gui.getUserSelection("hvem vil du bytte med", player);
	}
	public String iTrade(GUI gui, String[] fields) {
		return gui.getUserSelection("Hvad vi du afgive?", fields);
	}
	public String iWant(GUI gui, String[] fields) {
		return gui.getUserSelection("Jeg vil gerne have!", fields);
	}
	public boolean deal(GUI gui, String msg) {
		return gui.getUserLeftButtonPressed(msg, "Ja", "Nej");
	}
}
