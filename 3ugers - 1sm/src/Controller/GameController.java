package Controller;

import java.awt.Color;

import Game.ChanceCard;
import Game.GameBoard;
import Game.Jail;
import Game.Player;
import Game.Trade;
import Game.BuyProperty;
import View.Display;
import gui_fields.GUI_Brewery;
import gui_fields.GUI_Player;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class GameController {
	boolean turn = true;
	boolean turnchoice = true;
	GameBoard board = new GameBoard();
	Display view = new Display();
	Player[] players;
	DiceController diceController = new DiceController();
	DiceController diceController2 = new DiceController();
	ChanceCard cc;
	MoveController move = new MoveController();
	Jail jail = new Jail();
	boolean winner = false;
	boolean rollCounter = false;
	BuyProperty Buy = new BuyProperty();
	boolean start = true;
	Trade trade = new Trade();
	// the method that runs the game
	public void runGame() {
		board.createBoard();
		GUI gui = new GUI(board.getFields());
		cc = new ChanceCard(gui);
		addPlayers(gui);
		initPlayers(gui);
		//keeps going until af winner is found
		while (!winner) {
			takeRound(gui);
		}
	}
	//add the number of players can only bed be between 2-6 players
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
	// initilize the players, and puts them on the gameboards start field
	private void initPlayers(GUI gui) {
		for (int i = 0; i < players.length; i++) {
			gui.getFields()[0].setCar(players[i].getCarObject(), true);
		}
	}
	// takes the turn of the current player
	private void takeTurn(Player player, GUI gui) {
		//if the player is not bankrupt the player is allowed a turn
		if (player.getBankrupt() == false) {
			if (player.getInJail()) {			//if the player is in jail he gets the opptunity to pay or roll out
				jail.getOutOfJail(player, gui); 
			}
			if (!player.getInJail()) {  		//if the player is not in jail he then gets to take his turn
				player.changeTotalValue();
				turn = true;
				rollCounter = false;
				while (turn) {			// the outer loop runs until the player end his turn
					turnchoice = true;
					while (turnchoice) { 	// while this loops control's the type of actions the player can make
						switch (view.rollDiceButton(gui, player)) {
						case "Rul":
							if (!rollCounter) {
								rollCounter = true;
								int sum = diceController.roll() + diceController2.roll();
								if ((player.getCurrentField() + sum) > 39) { 	//when the player need to loop over 
									sum -= 40;									// the start area
									player.changeBalance(200);
								}
								gui.setDice(diceController.getFaceValue(), diceController2.getFaceValue());
								move.movePlayer(player, gui, sum);		//moves the player, based on his roll
								move.moveToJail(player, gui);			//send the player to jail if he landed field 30
								buyOrPayrent(player, gui, sum);		// buy the field if not owned else pay rent
								//checks for card draw fields
								if (player.getCurrentField() == 2 || player.getCurrentField() == 7
										|| player.getCurrentField() == 17 || player.getCurrentField() == 22
										|| player.getCurrentField() == 33 || player.getCurrentField() == 36) {
									cc.drawCard(player, players);	//draws a card
									buyOrPayrent(player,gui, sum);	//buy or payrent if the player has been moved
								} else if (gui.getFields()[player.getCurrentField()] == gui.getFields()[38]) {
									eksTax(player, gui); // pays ekstra tax
								} else if (gui.getFields()[player.getCurrentField()] == gui.getFields()[4]) {
									stageTax(player, gui);	//pay captial tax
								}
								move.moveToJail(player, gui); // move to jail if a car should have send the player to field 30								
								turnchoice = false; // makes it so the player can not roll again
								break;	//
							} else {
								gui.displayChanceCard("Du har rykket");
							}
							break;
						case "Byg hus":
							try {
								String colorChoice = view.buildOnColor(gui);
								Buy.choiceOfArea(colorChoice, gui, player, board);//lets the player choose where to build
							} catch (NullPointerException e) {
								gui.displayChanceCard("Du ejer ikke alle felterne i denne farve");
								//a null pointer will be triggered if a player does not own the fields in the same color
							}
							turnchoice = false;
							break;
						case "Byt":
							try {
								trade.trade(gui, players, player, view);	// calls the trade funktion
							} catch (NullPointerException e) {
								gui.displayChanceCard("Der er ikke noget at bytte med");
							}
							break;
						case "Slut tur": // end the turn of the current player
							turnchoice = false;
							turn = false;
							break;
						}
						bankrupt(player, gui);	// checks to see if we anyone should have gone bankrupt
						haveWeAWinner(player, gui); // checks if there are a winner
					}
				}
			}
		}
	}
	public void buyField(Player player, GUI gui) { //buy field method
		if (player.getCurrentField() == 12 || player.getCurrentField() == 28) {
			if (view.buyBut(gui)) {
				setOwner(player);   //buy brewery if its not owned
				board.getBrewery(player.getCurrentField()).setBorder(player.getCarObject().getPrimaryColor());
				board.setOwnable(player.getCurrentField(), false); // makes it so others cant buy the field
				player.changeBalance(-150);
				player.setFieldValue(150);
			}
		} else if (player.getCurrentField() == 5 || player.getCurrentField() == 15 || player.getCurrentField() == 25
				|| player.getCurrentField() == 35) { //checks if its shipping field and buys if not owned
			if (view.buyBut(gui)) {
				setOwner(player);
				board.getShipping(player.getCurrentField()).setBorder(player.getCarObject().getPrimaryColor());
				board.setOwnable(player.getCurrentField(), false);
				player.changeBalance(-200);
				player.setFieldValue(200);
			}
		} else {
			if (view.buyBut(gui)) {
				setOwner(player); // sets the owner of the street
				//makes it so the boarder matches the color of the player who bought
				board.getStreet(player.getCurrentField()).setBorder(player.getCarObject().getPrimaryColor());
				board.setOwnable(player.getCurrentField(), false);
				int price = board.getPrice(player.getCurrentField());
				player.changeBalance(-price);
				player.setFieldValue(price);

			}
		}
	}
	private void payRent(Player player, GUI gui, int diceSum) { //pay rent
		int rent = 0;
		int field = player.getCurrentField();
		String OOwner = "";
		if (field != 2 && field != 7 && field != 17 && field != 22 && field != 33 && field != 36 && field != 10
				&& field != 20 && field != 30 && field != 0 && field != 4 && field != 38) { //checks for special fields
			if (player.getCurrentField() == 12 || player.getCurrentField() == 28) {  // check if brewery
				String owner = ((GUI_Brewery) gui.getFields()[player.getCurrentField()]).getOwnerName();
				OOwner = owner;
				int countBrew = 0;
				if (owner.equals(((GUI_Brewery) gui.getFields()[12]).getOwnerName())
						&& owner.equals(((GUI_Brewery) gui.getFields()[28]).getOwnerName())) {
					countBrew = 2; // if the owner has 2 brewery then 2 facktor the rent
				} else {
					countBrew = 1; 
				}
				rent = board.getRentBrewery(diceSum, countBrew); // calculate the price of based on current roll and amount of brewery owned
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
				rent = board.getRentShipping(countShip); // calculate rent based on owned shipping
			} else {
				String owner = ((GUI_Street) gui.getFields()[player.getCurrentField()]).getOwnerName();
				OOwner = owner;
				rent = board.getRentStreet(player.getCurrentField());
			}
			// rent gets paid from one player to another
			player.changeBalance(-rent);
			for (int i = 0; i < players.length; i++) {
				if (OOwner.equals(players[i].getName())) {
					players[i].changeBalance(rent);
				}
			}
		}
	}
	private void takeRound(GUI gui) {  
		for (int i = 0; i < players.length; i++) {
			if (!winner) {
				takeTurn(players[i], gui); //when a player is done with a turn, find the next player's turn
			}
		}
	}
	public void setOwner(Player player) { //if a field is bought set a owner
		if (player.getCurrentField() == 12 || player.getCurrentField() == 28) {  
			board.getBrewery(player.getCurrentField()).setOwnableLabel("Owner : ");
			board.getBrewery(player.getCurrentField()).setOwnerName(player.getName()); // set the name of player
		} else if (player.getCurrentField() == 5 || player.getCurrentField() == 15 || player.getCurrentField() == 25
				|| player.getCurrentField() == 35) {
			board.getShipping(player.getCurrentField()).setOwnableLabel("Owner : ");
			board.getShipping(player.getCurrentField()).setOwnerName(player.getName()); //set the name of player
		} else {
			board.getStreet(player.getCurrentField()).setOwnableLabel("Owner : ");
			board.getStreet(player.getCurrentField()).setOwnerName(player.getName()); // set the name of player
		}
	}
	// Bankrupt
	public void bankrupt(Player player, GUI gui) { //bankrupt
		for (int i = 0; i < players.length; i++) { 
			if (player.getBalance() < 0) {		// if players balance is lower than 0 
				gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false); //removes the car
				player.setBalance(0); 	
				player.setTotalValue(0);
				player.setBankrupt(true); // makes him bankrupt so he wont have a turn
				turn = false;			
				board.sellAll(player, gui);		//sell all his field and houses
			}
		}
	}
	public void buyOrPayrent(Player player, GUI gui, int sum) {
		if (board.getOwnable(player.getCurrentField())) {
			buyField(player, gui);		//buy the field if not owned
		}
		else {payRent(player, gui, sum); 	// pay rent if owned
		}
	}
	public void findWinner(GUI gui) {
		String winner = "";
		for (int i = 0; i < players.length; i++) {
			if (players[i].getBankrupt() == false) {	//loops until there only is 1 player left
				winner = players[i].getName();		// find the winners name
				gui.displayChanceCard("Tillykke! " + winner + " har vundet");	//display winner message
			}
		}
	}
	public void haveWeAWinner(Player player, GUI gui) {	
		int count = 0;
		for (int i = 0; i < players.length; i++) {
			if (players[i].getBankrupt() == true) {	
				count++;
			}
		}
		if (count == players.length - 1) {
			winner = true;
			findWinner(gui);
		}
	}
	// TAX
	public void eksTax(Player player, GUI gui) {  // pays tax
		player.changeBalance(-100);
		gui.displayChanceCard("Ekatraordinær skat, betal 100kr.");
	}
	public void stageTax(Player player, GUI gui) { // pays tax based on player choice
		if (view.stageTax(gui)) {
			player.changeBalance(-200);
		} else {
			int tax = player.getTotalValue() * 10 / 100;	// 10% of total value
			player.changeBalance(-tax);
		}
	}
}