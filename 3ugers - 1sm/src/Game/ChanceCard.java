package Game;

import gui_main.GUI;

public class ChanceCard {

	public ChanceCard() {
	}

	String[] chanceCard = { "moveToRådhuspladsen", "moveToGrønningen", "takeØresundsbanen", "goThreeStepsBack",
			"goThreeStepsBack", "goToStart", "goToNextShippingCompany", "sammenskudsgilde", "nyttehaven", "klude",
			"abonnementskort", "manufakturvarer", "assistenthus", "aktier", "legater", "præmieoblikation",
			"gageforhøjelse", "coalPrices", "propertyTax", "tire", "fullStop", "vash", "vash", "cigarettes",
			"parkeringTicket", "parkeringTicket", "goToJail", "goToJail", "goToJail", "getOutOfJail", "getOutOfJail" };

	private GUI gui;

	public ChanceCard(GUI gui) {
		this.gui = gui;
		shuffle(chanceCard);
	}

	public void shuffle(String[] chanceCard) {

		for (int i = 0; i < chanceCard.length; i++) { // goes length of array times

			int currentValue = 0;

			boolean run = true;

			// runs until different index than current index
			while (run) {
				currentValue = (int) (Math.random() * chanceCard.length); // returns 0- max index value of array
				if (currentValue != i) {
					run = false;
				}
			}
			// change position between values in array
			String a = chanceCard[i]; // pre-defined
			String b = chanceCard[currentValue]; // random

			chanceCard[i] = b;
			chanceCard[currentValue] = a;
		}
	}

	// Work in progress

	// Trækker et kort, kalder metoden og lægger det nederst i bunken
	public void drawCard(Player player, Player[] players) {
		String card = chanceCard[0];
		for (int i = 1; i < chanceCard.length; i++) {
			chanceCard[i - 1] = chanceCard[i];
		}
		chanceCard[chanceCard.length - 1] = card;

		// Switch case
		switch (card) {

		// Move cards
		case "moveToRådhuspladsen":
			moveTo(player, 39, gui, "Tag ind til Rådhuspladsen");
			break;
		case "moveToGrønningen":
			moveTo(player, 24, gui, "Ryk frem til Grønningen. Hvis du passerer >>Start<< indkasser da kr. 200.");
			break;
		case "takeØresundsbåden":
			moveTo(player, 5, gui,
					"Tag med Øresundsbåden.. Flyt brikken frem, og hvis du passerer >>Start<< indkasser kr. 200.");
			break;
		case "goThreeStepsBack":
			moveSteps(player, -3, gui, "Ryk tre felter tilbage");
			break;
		case "goToStart":
			moveTo(player, 0, gui, "Ryk frem til >>Start<<");
			break;
		case "goToNextShippingCompany":
			goToNextShippingCompany(player, gui,
					"Ryk brikken frem til det nærmeste dampskibsselskab "
							+ "og betal ejeren to gange den leje, han ellers er berettiget til. "
							+ "Hvis selskabet ikke er ejet af nogen, kan De købe det af banken.");
			break;

		// Get money
		case "sammenskudsgilde":
			getMoney(player, gui, 25, "De har lagt penge ud til sammenskudsgilde. "
					+ "Mærkværdigvis betaler alle straks. Modtag kr. 25 fra hver medspiller.");
			break;
		case "nyttehaven":
			getMoney(player, gui, 200, "Værdien af egen avl fra nyttehaven udgør kr. 200, som du modtager af Banken.");
			break;
		case "klude":
			getMoney(player, gui, 20, "Du har solgt dine gamle klude. Modtag kr. 20.");
			break;
		case "abonnementskort":
			getMoney(player, gui, 1,
					"Du har rettidigt afleveret dine abonnementskort. Et depositum på kr. 1 udbetales til dig af banken.");
			break;
		case "manufakturvarer":
			getMoney(player, gui, 50,
					"Manufakturvarerne er blevet billigere og bedre, herved sparer du kr. 50, som du modtager af banken.");
			break;
		case "assistenthus":
			getMoney(player, gui, 108,
					"Efter auktionen på Assistenshuset, hvor du har pantsat dit tøj, modtag de ekstra kr. 108.");
			break;
		case "aktier":
			getMoney(player, gui, 50, "Modtag udbytte af dine aktier: kr. 50");
			break;
		case "legater":
			scholarship(player, gui, 2000, "Du modtager >>Matador-legater for værdig trængende<< kr. 2000."
					+ "Ved værdig trængende forstås, at din formue, d. v. s. dine kontante penge + skøder + bygninger, ikke overstiger kr. 750.");
			break;
		case "præmieoblikation":
			getMoney(player, gui, 100, "Din præmieobligation er kommet ud. De Modtager kr. 100 af banken.");
			break;
		case "gageforhøjelse":
			getMoney(player, gui, 25, "Grundet på dyrtiden har du fået gageforhøjelse. Modtag kr. 25.");
			break;
		
			// Pay money
		case "coalPrices":
			coalPrices(player, gui, player.houseOwned(), player.hotelOwned(), "Kul og kokspriserne er steget, og De skal betale: kr. 25 pr hus og kr. 125 per Hotel.");
			break;
		case "propertyTax":
			propertyTax(player, gui, player.houseOwned(), player.hotelOwned(), "Ejendomsskat er steget, ekstraudgifterne er: kr. 50 per hus og kr. 125 per Hotel.");
			break;
		case "tire":
			payMoney(player, gui, 100, "Du har anskaffet et nyt dæk til din bil. Indbetal kr. 100.");
			break;
		case "fullStop":
			payMoney(player, gui, 100, "Du har kørt frem for >Fuld Stop<. Betal kr. 100 i bøde.");
			break;
		case "vash":
			payMoney(player, gui, 100, "Betal for vogn vask og smørning kr. 100.");
			break;
		case "cigarettes":
			payMoney(player, gui, 20,
					"Du har været en tur i udlandet og har haft for mange cigaretter med hjem. Betal told kr. 20.");
			break;
		case "parkeringTicket":
			payMoney(player, gui, 20, "Du har måttet vedtage en parkeringsbøde. Betal kr. 20 til banken.");
			break;

//		// Go to jail
//		case "goToJail":
//			goToJail(player, 30, gui,
//					"Gå i fængsel. Ryk direkte til fængsel. Selv om De passerer >>Start<<, indkasserer du ikke kr. 200.");
//			break;
//
//		// Get out of jail
//		case "getOutOfJail":
//			getOutOfJail(player,
//					"I anledning af Kongens fødelsdag benådes du herved for fængsel. Dette kort kan opbevares, indtil du får brug for det eller du kan sælge det.");
//			break;
		}
	}

	// Move to (this chance card sets a player on a field)
	public void moveTo(Player player, int field, GUI gui, String message) {
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
		player.setCurrentField(field);
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
		gui.displayChanceCard(message);
		ifPassStart(player, field);
	}

	// Go to next Shipping Company
	public void goToNextShippingCompany(Player player, GUI gui, String message) {
		if (player.getCurrentField() > 35 && player.getCurrentField() < 5) {
			if (player.getCurrentField() > 35) {
				player.changeBalance(200);
			}
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
			player.setCurrentField(5);
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
		} else if (player.getCurrentField() > 5 && player.getCurrentField() < 14) {
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
			player.setCurrentField(15);
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
		} else if (player.getCurrentField() > 16 && player.getCurrentField() < 24) {
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
			player.setCurrentField(25);
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
		} else if (player.getCurrentField() > 26 && player.getCurrentField() < 34) {
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
			player.setCurrentField(35);
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
		}
		gui.displayChanceCard(message);
	}

	// // Move steps (this chance card moves a player forwards or backwards on the
	// board)
	public void moveSteps(Player player, int steps, GUI gui, String message) {
		movePlayerDist(player, gui, steps);
		gui.displayChanceCard(message);
	 }

	// Get money (this chance card adds money to the players balance)
	public void getMoney(Player player, GUI gui, int money, String message) {
		player.changeBalance(money);
		gui.displayChanceCard(message);
	}

	// Scholarships
	public void scholarship(Player player, GUI gui, int money, String message) {
		if (player.getTotalValue() <= 750) {
			player.changeBalance(money);
		} else if (player.getTotalValue() > 750) {
			player.changeBalance(0);
		}
		gui.displayChanceCard(message);
	}
	
	// Coal prices
	public void coalPrices(Player player, GUI gui, int houseOwned, int hotelOwned, String message) {
		if (player.houseOwned() > 0 || player.hotelOwned() > 0) {
			player.changeBalance(- (25 * player.houseOwned()));
			player.changeBalance(- (125 * player.hotelOwned()));
		}
		else if (player.houseOwned() == 0 && player.hotelOwned() == 0) {
			player.changeBalance(0);
		}
			
	}
	
	// Property tax
	public void propertyTax(Player player, GUI gui, int houseOwned, int hotelOwned, String message) {
		if (player.houseOwned() > 0 || player.hotelOwned() > 0) {
			player.changeBalance(- (50 * player.houseOwned()));
			player.changeBalance(- (125 * player.hotelOwned()));
		}
		else if (player.houseOwned() == 0 && player.hotelOwned() == 0) {
			player.changeBalance(0);
		}
	}

	// Pay money (this chance card draws money from the players balance)
	public void payMoney(Player player, GUI gui, int money, String message) {
		player.changeBalance(money);
		gui.displayChanceCard(message);
	}

	// Go to jail
	public void goToJail(Player player, int field, GUI gui, String message) {
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
		player.setCurrentField(field);
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
		gui.displayChanceCard(message);
	}

	// Get out of jail
	public void getOutOfJail(Player player, String message) {
		player.setHasJailCard(true);
		gui.displayChanceCard(message);
	}

	/////////////////
	// Move funktions
	public void movePlayerDist(Player player, GUI gui, int dist) {
		// Removes the brick from the current field.
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
		// Updates the player object.
		if (player.getCurrentField() + dist > 39) {
			dist -= 40;
			player.changeBalance(200);
		}
		player.setCurrentField(player.getCurrentField() + dist);
		// Places the player's brick on the new field.
		gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
	}

	public void ifPassStart(Player player, int field) {
		if (player.getCurrentField() > field) {
			player.changeBalance(200);
		}
	}
}
