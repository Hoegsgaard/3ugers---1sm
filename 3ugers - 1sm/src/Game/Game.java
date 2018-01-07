package Game;

import java.awt.Color;

import gui_fields.GUI_Player;
import gui_main.GUI;

public class Game {
	public Game() {
	}
	
	GameBoard board = new GameBoard();

	public void runGame() {
		board.createBoard();
		
		
		
	}

// Method that accepts amount of players, and their names.
private void enterPlayers(GUI gui) {
	//Accepts a number of players and keeps trying until the
	//Entered number is between 2 and 4.
	int AmountOfPlayers = (gui.getUserInteger("How many players? Min. 2 and Max. 4."));
	
	
	Player[] players = new Player[AmountOfPlayers];
	//Creates one player at a time
	for (int i = 0; i < players.length; i++) {
		players[i] = new Player();
		//Asks the user for a name.
		players[i].setName(gui.getUserString(("Enter the name of player " + (i + 1))));
		players[i].setCarObject(new GUI_Player(players[i].getName(), 20 - ((AmountOfPlayers - 2) * 2)));
		
		//Sets the players balance. 20 - ((AmountOfPlayers - 2) * 2) is an equation that gives the following results:
		//16 if AmountOfPlayers = 4.
		//18 if AmountOfPlayers = 3.
		//20 if AmountOfPlayers = 2.
		players[i].changeBalance(20 - ((AmountOfPlayers - 2) * 2));
		//Sets the colour of the cars manually, so they dont end up the same by chance.
		switch (i) {
		case 0:
			players[i].getCarObject().getCar().setPrimaryColor(Color.GREEN);
			break;
		case 1:
			players[i].getCarObject().getCar().setPrimaryColor(Color.RED);
			break;
		case 2:
			players[i].getCarObject().getCar().setPrimaryColor(Color.BLUE);
			break;
		case 3:
			players[i].getCarObject().getCar().setPrimaryColor(Color.YELLOW);
			break;
		case 4:
			players[i].getCarObject().getCar().setPrimaryColor(Color.MAGENTA);
			break;
		case 5:
			players[i].getCarObject().getCar().setPrimaryColor(Color.CYAN);
			break;
		}
		gui.addPlayer(players[i].getCarObject());
		
		
	}
	
}
}
