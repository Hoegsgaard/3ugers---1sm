package Controller;

import java.awt.Color;

import Game.ChanceCard;
import Game.Dice;
import Game.Game;
import Game.GameBoard;
import Game.Jail;
import Game.Player;
import Game.BuyProperty;
import View.Display;
import gui_fields.GUI_Brewery;
import gui_fields.GUI_Player;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class Controller {
	boolean turn = true;
	boolean turnchoice = true;
	GameBoard board = new GameBoard();
	Display view = new Display();
	Game game = new Game();
	Player[] players;
	DiceController diceController = new DiceController();
	DiceController diceController2 = new DiceController();
	ChanceCard cc;
	MoveController move = new MoveController();
	Jail jail = new Jail();
	boolean winner = false;
	boolean rollCounter = false;
	BuyProperty Buy = new BuyProperty();

	public void runGame() {
		board.createBoard();
		GUI gui = new GUI(board.getFields());
		cc = new ChanceCard(gui);
		addPlayers(gui);
		initPlayers(gui);
		while (!winner) {
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

	public Player getPlayerOwner(Player player) {
		return player;

	}

	private void initPlayers(GUI gui) {

		for (int i = 0; i < players.length; i++) {
			gui.getFields()[0].setCar(players[i].getCarObject(), true);
			
		}
	}

	private void takeTurn(Player player, GUI gui) {
		if (player.getBankrupt() == false) {
			if (player.getInJail()) {
				jail.getOutOfJail(player, gui);
			}
			if (!player.getInJail()) {
				player.changeTotalValue();
				turn = true;
				rollCounter = false;
				while (turn) {
					turnchoice = true;
					while (turnchoice) {
						switch (view.rollDiceButton(gui, player)) {
						case "Rul":
							if (!rollCounter) {
								rollCounter = true;
								//int sum = diceController.roll() + diceController2.roll();
								int sum = 1;
								if ((player.getCurrentField() + sum) > 39) {
									sum -= 40;
									player.changeBalance(200);
								}
								gui.setDice(diceController.getFaceValue(), diceController2.getFaceValue());
								move.movePlayer(player, gui, sum);
								move.moveToJail(player, gui);
								if (board.getOwnable(player.getCurrentField())) {
									buyField(player, gui);
								} else {
									if (player.getCurrentField() != 2 && player.getCurrentField() != 7
											&& player.getCurrentField() != 17 && player.getCurrentField() != 22
											&& player.getCurrentField() != 33 && player.getCurrentField() != 36
											&& player.getCurrentField() != 10 && player.getCurrentField() != 20
											&& player.getCurrentField() != 30 && player.getCurrentField() != 0
											&& player.getCurrentField() != 4 && player.getCurrentField() != 38) {
										payRent(player, gui, sum);
									}
								}
								if (player.getCurrentField() == 2 || player.getCurrentField() == 7
										|| player.getCurrentField() == 17 || player.getCurrentField() == 22
										|| player.getCurrentField() == 33 || player.getCurrentField() == 36) {
									cc.drawCard(player, players);
								} else if (gui.getFields()[player.getCurrentField()] == gui.getFields()[38]) {
									eksTax(player, gui);
								} else if (gui.getFields()[player.getCurrentField()] == gui.getFields()[4]) {
									stageTax(player, gui);
								}

								turnchoice = false;
								break;
							}else {
								gui.displayChanceCard("Byg et Hus eller slut din tur");
							}	break;
						case "Byg hus":
							try {
							String test = view.buildOnColor(gui);
							Buy.choiceOfArea(test, gui, player, board);
							//Buy.isAllOwendInSameColor(gui, player);
							}catch(NullPointerException e) {
								gui.displayChanceCard("Du ejer ikke Alle de felter");
							}
							turnchoice = false;
							break;
						case "Slut tur":
							turnchoice = false;
							turn = false;
							break;

						}
						bankrupt(player, gui);
						haveWeAWinner(player, gui);
					}
				}
			}
		}
	}

	public void buyField(Player player, GUI gui) {
		if (player.getCurrentField() == 12 || player.getCurrentField() == 28) {
			if (view.buyBut(gui)) {
				setOwner(player);
				board.getBrewery(player.getCurrentField()).setBorder(player.getCarObject().getPrimaryColor());
				board.setOwnable(player.getCurrentField(), false);
				player.changeBalance(-150);
				player.setFieldValue(150);
			}
		} else if (player.getCurrentField() == 5 || player.getCurrentField() == 15 || player.getCurrentField() == 25
				|| player.getCurrentField() == 35) {
			if (view.buyBut(gui)) {
				setOwner(player);
				board.getShipping(player.getCurrentField()).setBorder(player.getCarObject().getPrimaryColor());
				board.setOwnable(player.getCurrentField(), false);
				player.changeBalance(-200);
				player.setFieldValue(200);
			}
		} else {
			if (view.buyBut(gui)) {
				setOwner(player);
				board.getStreet(player.getCurrentField()).setBorder(player.getCarObject().getPrimaryColor());
				board.setOwnable(player.getCurrentField(), false);
				int price = board.getPrice(player.getCurrentField());
				player.changeBalance(-price);
				player.setFieldValue(price);
				
			}
		}
	}

	private void payRent(Player player, GUI gui, int diceSum) {
		int rent = 0;
		String OOwner = "";

		if (player.getCurrentField() == 12 || player.getCurrentField() == 28) {
			String owner = ((GUI_Brewery) gui.getFields()[player.getCurrentField()]).getOwnerName();
			OOwner = owner;
			int countBrew = 0;
			if (owner.equals(((GUI_Brewery) gui.getFields()[12]).getOwnerName())
					&& owner.equals(((GUI_Brewery) gui.getFields()[28]).getOwnerName())) {
				countBrew = 2;
			} else {
				countBrew = 1;
			}

			rent = board.getRentBrewery(diceSum, countBrew);
		} else if (player.getCurrentField() == 5 || player.getCurrentField() == 15 || player.getCurrentField() == 25
				|| player.getCurrentField() == 35) {
			String owner = ((GUI_Shipping) gui.getFields()[player.getCurrentField()]).getOwnerName();
			OOwner = owner;
			int countShip = 0;

			for (int i = 5; i < 39; i = i + 10) {
				if (owner.equals(((GUI_Shipping) gui.getFields()[i]).getOwnerName())) {
					countShip++;
				}
			}
			rent = board.getRentShipping(countShip);
		} else {
			String owner = ((GUI_Street) gui.getFields()[player.getCurrentField()]).getOwnerName();
			OOwner = owner;
			rent = board.getRentStreet(player.getCurrentField());
		}
		// Leje betales, fra spiller til ejer
		player.changeBalance(-rent);
		for (int i = 0; i < players.length; i++) {
			if (OOwner.equals(players[i].getName())) {
				players[i].changeBalance(rent);
			}
		}
	}

	private void takeRound(GUI gui) {
		for (int i = 0; i < players.length; i++) {
			if (!winner) {
				takeTurn(players[i], gui);
			}
		}
	}

	public void setOwner(Player player) {
		if (player.getCurrentField() == 12 || player.getCurrentField() == 28) {
			board.getBrewery(player.getCurrentField()).setOwnableLabel("Owner : ");
			board.getBrewery(player.getCurrentField()).setOwnerName(player.getName());
		} else if (player.getCurrentField() == 5 || player.getCurrentField() == 15 || player.getCurrentField() == 25
				|| player.getCurrentField() == 35) {
			board.getShipping(player.getCurrentField()).setOwnableLabel("Owner : ");
			board.getShipping(player.getCurrentField()).setOwnerName(player.getName());
		} else {
			board.getStreet(player.getCurrentField()).setOwnableLabel("Owner : ");
			board.getStreet(player.getCurrentField()).setOwnerName(player.getName());
		}

	}

	// Bankrupt
	public void bankrupt(Player player, GUI gui) {
		for (int i = 0; i < players.length; i++) {
			if (player.getBalance() < 0) {
				gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
				player.setBalance(0);
				player.setTotalValue(0);
				player.setBankrupt(true);
				turn = false;
			}
		}
	}

	//
	public void findWinner(Player player, GUI gui) {
		String winner = "";
		for (int i = 0; i < players.length; i++) {
			if (players[i].getBankrupt() == false) {
				winner = players[i].getName();
				gui.displayChanceCard("Tillykke! " + winner + " har vundet");
			}
		}
	}

	//
	public void haveWeAWinner(Player player, GUI gui) {
		int count = 0;
		for (int i = 0; i < players.length; i++) {
			if (players[i].getBankrupt() == true) {
				count++;
			}
		}
		if (count == players.length - 1) {
			winner = true;
			findWinner(player, gui);
		}
	}

	// TAX
	public void eksTax(Player player, GUI gui) {
		player.changeBalance(-100);
		gui.displayChanceCard("Ekatraordinær skat, betal 100kr.");
	}

	public void stageTax(Player player, GUI gui) {
		if (view.stageTax(gui)) {
			player.changeBalance(-200);
		} else {
			int tax = player.getTotalValue() * 10 / 100;
			player.changeBalance(-tax);
		}
	}
}
