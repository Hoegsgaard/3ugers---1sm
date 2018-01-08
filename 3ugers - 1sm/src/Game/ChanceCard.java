package Game;

import gui_main.GUI;

public class ChanceCard {
	
	public ChanceCard() {}
	
	String[] chanceCard = { "moveToRådhuspladsen", "moveToGrønningen", "takeØresundsbanen", "goThreeStepsBack", 
			"goThreeStepsBack", "goToStart", "goToNextShippingCompany", "sammenskudsgilde", "nyttehaven", "klude",
			"abonnementskort", "manufakturvarer", "assistenthus", "aktier", "legater", "præmieoblikation", "gageforhøjelse", 
			"kokspriser", "ejendomsskat", "dæk", "fullStop", "vask", "vask", "smøger", "parkeringsbøde", "parkeringsbøde", 
			"goToJail", "goToJail", "goToJail", "getOutOfJail", "getOutOfJail" };
	
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
				moveTo(player, 39, gui, message[?]);
				break;
			case "moveToGrønningen":
				moveTo(player, 24, gui, message[?]);
				break;
			case "takeØresundsbanen":
				moveTo(player, 5, gui, message[?]);
				break;
			case "goThreeStepsBack":
				moveSteps(player, gui, -3, message[?]);
				break;
			case "goToStart":
				moveTo(player, 0, gui, message[?]);
				break;
			case "goToNextShippingCompany":
				goToNextShippingCompany(player, gui, message[?]);
				break;
				
			// Get money
			case "sammenskudsgilde":
				sammenskudsgilde(player);
				break;
			case "nyttehaven":
				nyttehaven(player);
				break;
			case "klude":
				klude(player);
				break;
			case "abonnementskort":
				abonnementskort(player);
				break;
			case "manufakturvarer":
				manufakturvarer(player);
				break;
			case "assistenthus":
				assistenthus(player);
				break;
			case "aktier":
				aktier(player);
				break;
			case "legater":
				legater(player);
				break;
			case "præmieoblikation":
				præmieoblikation(player);
				break;
			case "gageforhøjelse":
				gageforhøjelse(player);
				break;
			
			// Pay money
			case "kokspriser":
				kokspriser(player);
				break;
			case "ejendomsskat":
				ejendomsskat(player);
				break;
			case "dæk":
				dæk(player);
				break;
			case "fullStop":
				fullStop(player);
				break;
			case "vask":
				vask(player);
				break;
			case "smøger":
				smøger(player);
				break;
			case "parkeringsbøde":
				parkeringsbøde(player);
				break;
				
			// Go to jail
			case "goToJail":
				goToJail(player);
				break;
			
			// Get out of jail
			case "getOutOfJail":
				getOutOfJail(player);
				break;
			}	
		}
		
		// Move to (this chance card sets a player on a field)
		public void moveTo(Player player, int field, GUI gui, String message) {
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
			player.setCurrentField(field);
			gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
		}
		
		/* Udkommenteret.. kig på disse funktioner senere! */
//		// Move to Rådhuspladsen
//		public void moveToRådhuspladsen(Player player) {
//			
//		}
//		
//		// Move to Grønningen
//		public void moveToGrønningen(Player player) {
//			
//		}
//		
//		// Take Øresundsbanen
//		public void takeØresundsbanen(Player player) {
//			
//		}
		
//		// Go to start
//		public void goToStart(Player player) {
//			
//		}
		
		// Go to next Shipping Company
		public void goToNextShippingCompany(Player player, GUI gui, String message) {
			if (player.getCurrentField() > 35 && player.getCurrentField() < 5) {
				gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
				player.setCurrentField(5);
				gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
			}
			else if (player.getCurrentField() > 5 && player.getCurrentField() < 14) {
				gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
				player.setCurrentField(15);
				gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
			}
			else if (player.getCurrentField() > 16 && player.getCurrentField() < 24) {
				gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
				player.setCurrentField(25);
				gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
			}
			else if (player.getCurrentField() > 26 && player.getCurrentField() < 34) {
				gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), false);
				player.setCurrentField(35);
				gui.getFields()[player.getCurrentField()].setCar(player.getCarObject(), true);
			}
		}
		
		// Move steps (this chance card moves a player forwards or backwards on the board)
		public void moveSteps(Player player, int steps, GUI gui, String message) {
			movePlayer(player, gui, steps);
			gui.displayChanceCard(message);
		}
		
//		// Go three steps back
//		public void goThreeStepsBack(Player player) {
//			
//		}
		
		// Get money (this chance card adds money to the players balance)
		public void getMoney(Player player, ) {
			
		}
		
//		// Sammenskudsgilde
//		public void sammenskudsgilde(Player player) {
//			
//		}
//		
//		// Nyttehaven
//		public void nyttehaven(Player player) {
//			
//		}
//		
//		// Klude
//		public void klude(Player player) {
//			
//		}
//		
//		// Abonnementskort
//		public void abonnementskort(Player player) {
//			
//		}
//		
//		// Manufakturvarer
//		public void manufakturvarer(Player player) {
//			
//		}
//		
//		// Assistenthus
//		public void assistenthus(Player player) {
//			
//		}
//		
//		// Aktier
//		public void aktier(Player player) {
//			
//		}
//		
//		// Legater
//		public void legater(Player player) {
//			
//		}
//		
//		// Præmieoblikation
//		public void præmieoblikation(Player player) {
//			
//		}
//		
//		// Gageforhøjelse
//		public void gageforhøjelse(Player player) {
//			
//		}
		
		// Kokspriser
		public void kokspriser(Player player) {
			
		}
		
		// Ejendomsskat
		public void ejendomsskat(Player player) {
			
		}
		
		// Dæk
		public void dæk(Player player) {
			
		}
		
		// Full stop
		public void fullStop(Player player) {
			
		}
		
		// Vask
		public void vask(Player player) {
			
		}
		
		// Smøger
		public void smøger(Player player) {
			
		}
		
		// Parkeringsbøde
		public void parkeringsbøde(Player player) {
			
		}
		
		// Go to jail
		public void goToJail(Player player) {
			
		}
		
		// Get out of jail
		public void getOutOfJail(Player player) {
			
		}
}
