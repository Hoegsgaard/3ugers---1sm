package Controller;

import java.awt.Color;

import Game.ChanceCard;
import Game.Dice;
import Game.Game;
import Game.GameBoard;
import Game.Player;
import View.Display;
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
	DiceController diceController2 = new DiceController();
	ChanceCard cc;

	public void runGame() {
		board.createBoard();
		GUI gui = new GUI(board.getFields());
		cc = new ChanceCard(gui);
		addPlayers(gui);
		initPlayers(gui);
		while (!gameOver) {
			takeRound(gui);
		}

	}

	public Player[] getPlayers() {
		return players;
	}

	public void addPlayers(GUI gui) {
		int AmountOfPlayers = view.enterPlayers(gui);

		while (AmountOfPlayers > 6 || AmountOfPlayers < 2) {
			AmountOfPlayers = (gui.getUserInteger("How many players? Min. 2 and Max. 6."));
		}

		players = new Player[AmountOfPlayers];
		// Creates one player at a time
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player();
			// Asks the user for a name.
			players[i].setName(gui.getUserString(("Enter the name of player " + (i + 1))));
			players[i].setCarObject(new GUI_Player(players[i].getName()));

			// Sets the players balance. 20 - ((AmountOfPlayers - 2) * 2) is an equation
			// that gives the following results:
			// 16 if AmountOfPlayers = 4.
			// 18 if AmountOfPlayers = 3.
			// 20 if AmountOfPlayers = 2.
			players[i].changeBalance(1500);
			// Sets the colour of the cars manually, so they dont end up the same by chance.
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

		for (int i = 0; i < players.length; i++) {
			gui.getFields()[0].setCar(players[i].getCarObject(), true);
		}
	}

	private void takeTurn(Player player, GUI gui) {
		if (turn) {
			view.rollDiceButton(gui);

		}

		int sum = diceController.roll() + diceController2.roll();
		if ((player.getCurrentField() + sum) > 39) {
			sum -= 40;
			player.changeBalance(200);
		}
		gui.setDice(diceController.getFaceValue(), diceController2.getFaceValue());
		movePlayer(player, gui, sum);
		buyField(player);
		//
	}

	private void takeRound(GUI gui) {
		for (int i = 0; i < players.length; i++) {
			if (!gameOver) {
				takeTurn(players[i], gui);
			}
		}
	}

	public void setOwner(Player player) {
		board.getStreet(player.getCurrentField()).setOwnableLabel("Owner : ");
		board.getStreet(player.getCurrentField()).setOwnerName(player.getName());

	}

	public void buyField(Player player) {
		int field = player.getCurrentField();
		if (board.getOwnable(field)) {
			if (field == 12 || field == 28) {
				// setOwner(player);
				board.getBrewery(field).setBorder(player.getCarObject().getPrimaryColor());
				board.setOwnable(field, false);
				player.changeBalance(-150);
			} else if (field == 5 || field == 15 || field == 25 || field == 35) {
				// setOwner(player);
				board.getShipping(field).setBorder(player.getCarObject().getPrimaryColor());
				board.setOwnable(field, false);
				player.changeBalance(-200);
			} else {
				setOwner(player);
				board.getStreet(field).setBorder(player.getCarObject().getPrimaryColor());
				board.setOwnable(field, false);
				player.changeBalance(-board.getPrice(field));
			}

		}

	}

	public void setPlayerPos(Player player, int field, GUI gui) {
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
		player.setCurrentField(field);
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
	}

	public void movePlayer(Player player, GUI gui, int dist) {
		// Removes the brick from the current field.
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
		// Updates the player object.
		player.setCurrentField(player.getCurrentField() + dist);
		// Places the player's brick on the new field.
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
		// Checks if they player has to go to jail or draw a chancecard.
		if (player.getCurrentField() == 2 || player.getCurrentField() == 7 || player.getCurrentField() == 17 || player.getCurrentField() == 22 || player.getCurrentField() == 33 || player.getCurrentField() == 36) {
			cc.drawCard(player, players);
		} else if (gui.getFields()[player.getCurrentField()] ==gui.getFields()[30]) {
			goToJail(player, gui);
		}
	}

	public void goToJail(Player player, GUI gui) {
		setPlayerPos(player, 10, gui);
	}

	public void payRent(Player player) {

	}

}
