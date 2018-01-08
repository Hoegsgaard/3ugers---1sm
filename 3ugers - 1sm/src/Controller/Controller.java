package Controller;

import java.awt.Color;

import Game.Dice;
import Game.Game;
import Game.GameBoard;
import Game.Player;
import View.Display;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Controller {
	boolean turn = true;
	boolean gameOver = false;
	GameBoard board = new GameBoard();
	Display view = new Display();
	Game game = new Game();
	Player[] players;
	DiceController diceController = new DiceController();
	Dice d1 = new Dice(6);
	Dice d2 = new Dice(6);

	public void runGame() {
		board.createBoard();
		GUI gui = new GUI(board.getFields());
		addPlayers(gui);		
		initPlayers(gui);
		while(!gameOver) {
			takeRound(gui);
		}
		
		
	}

	
	
	
	
	public void addPlayers(GUI gui) {
		int AmountOfPlayers = view.enterPlayers(gui);
		
		while (AmountOfPlayers > 6 || AmountOfPlayers < 2) {
			AmountOfPlayers = (gui.getUserInteger("How many players? Min. 2 and Max. 6."));
		}
		
		players = new Player[AmountOfPlayers];
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
	private void initPlayers(GUI gui) {
		
		for(int i = 0; i < players.length; i++) {
			gui.getFields()[0].setCar(players[i].getCarObject(), true);
		}
	}
	
	private void takeTurn(Player player, GUI gui) {
		if(turn) {
			view.rollDiceButton(gui);
			
		}
		
		int sum = diceController.roll() + diceController.roll();
		if ((player.getCurrentField() + sum) > 39) {
			sum -= 40;
			player.changeBalance(2);
		}
		gui.setDice(d1.getFaceValue(), d2.getFaceValue());
		movePlayer(player, gui, sum);
		buyField(player);
		
	}
	
	
	private void takeRound(GUI gui) {
		for (int i = 0; i < players.length; i++) {
			if (!gameOver) {
				takeTurn(players[i], gui);
			}
		}
	}
	
	
	public void movePlayer(Player player, GUI gui, int dist) {
		// Removes the brick from the current field.
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
		// Updates the player object.
		player.setCurrentField(player.getCurrentField() + dist);
		// Places the player's brick on the new field.
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
		//Checks if they player has to go to jail or draw a chancecard.
//		if (gui.getFields()[player.getCurrentField()] == fields[18]) {
//			goToJail(player, gui);
//		} else if (player.getCurrentField() == 3 || player.getCurrentField() == 9 || player.getCurrentField() == 15
//				|| player.getCurrentField() == 21) {
//			cd.drawCard(player, players);
//		}
	}
	

	public void setOwner(Player player) {
			board.getStreet(player.getCurrentField()).setOwnableLabel("Owner : ");
			board.getStreet(player.getCurrentField()).setOwnerName(player.getName());
					
	}
	
	public void buyField(Player player) {
		int field = player.getCurrentField();
		if(board.getOwnable(field)) {
		setOwner(player);
		board.getStreet(field).setBorder(player.getCarObject().getPrimaryColor());
		board.setOwnable(field, false);
		
		}
	}



	
	
}
