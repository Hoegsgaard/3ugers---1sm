package Game;

import View.Display;
import gui_fields.GUI_Brewery;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class Trade {
	public Trade() {
	}
	
	public void trade(GUI gui, Player[] players, Player player, Display view) {
		String[] playersName = new String[players.length]; // makes a string array of based on the amount of plauers
		for (int i = 0; i < players.length; i++) {
			playersName[i] = players[i].getName();  //indexing the names in the string array
		}
		String tradeWhit = view.tradeWith(gui, playersName); // the player who wants to trade
		int traderNumOffField = 0;
		for (int i = 0; i < 40; i++) {
			if (i != 2 && i != 7 && i != 17 && i != 22 && i != 33 && i != 36 && i != 10 && i != 20 && i != 30 && i != 0
					&& i != 4 && i != 38) {
				if (i == 12 || i == 28) {
					if (player.getName().equals(((GUI_Brewery) gui.getFields()[i]).getOwnerName())) {
						traderNumOffField++;
					}
				} else if (i == 5 || i == 15 || i == 25 || i == 35) {
					if (player.getName().equals(((GUI_Shipping) gui.getFields()[i]).getOwnerName())) {
						traderNumOffField++;
					}
				} else {
					if (player.getName().equals(((GUI_Street) gui.getFields()[i]).getOwnerName())) {
						traderNumOffField++;
					}
				}
			}
		}
		String[] traderField = new String[traderNumOffField]; // an array of field he wants to trade
		int tradeCounter = 0;
		for (int i = 0; i < 40; i++) {
			if (i != 2 && i != 7 && i != 17 && i != 22 && i != 33 && i != 36 && i != 10 && i != 20 && i != 30 && i != 0
					&& i != 4 && i != 38) {
				String fieldName = "";
				if (i == 12 || i == 28) {
					if (player.getName().equals(((GUI_Brewery) gui.getFields()[i]).getOwnerName())) {
						fieldName = ((GUI_Brewery) gui.getFields()[i]).getTitle();
					}
				} else if (i == 5 || i == 15 || i == 25 || i == 35) {
					if (player.getName().equals(((GUI_Shipping) gui.getFields()[i]).getOwnerName())) {
						fieldName = ((GUI_Shipping) gui.getFields()[i]).getTitle();
					}
				} else {
					if (player.getName().equals(((GUI_Street) gui.getFields()[i]).getOwnerName())) {
						fieldName = ((GUI_Street) gui.getFields()[i]).getTitle();
					}
				}
				if (tradeCounter < traderField.length && fieldName != "") { //find all the fields he owns
					traderField[tradeCounter] = fieldName;
					tradeCounter++;
				}
			}
		}
		int tradeWhitsNumOffField = 0;
		for (int i = 0; i < 40; i++) {
			if (i != 2 && i != 7 && i != 17 && i != 22 && i != 33 && i != 36 && i != 10 && i != 20 && i != 30 && i != 0
					&& i != 4 && i != 38) {
				if (i == 12 || i == 28) {
					if (tradeWhit.equals(((GUI_Brewery) gui.getFields()[i]).getOwnerName())) {
						tradeWhitsNumOffField++;
					}
				} else if (i == 5 || i == 15 || i == 25 || i == 35) {
					if (tradeWhit.equals(((GUI_Shipping) gui.getFields()[i]).getOwnerName())) {
						tradeWhitsNumOffField++;
					}
				} else {
					if (tradeWhit.equals(((GUI_Street) gui.getFields()[i]).getOwnerName())) {
						tradeWhitsNumOffField++;
					}
				}
			}
		}
		String[] tradeWhitsFields = new String[tradeWhitsNumOffField];
		int tradeWhitsCounter = 0;
		for (int i = 0; i < 40; i++) {
			String fieldName = "";
			if (i != 2 && i != 7 && i != 17 && i != 22 && i != 33 && i != 36 && i != 10 && i != 20 && i != 30 && i != 0
					&& i != 4 && i != 38) {
				if (i == 12 || i == 28) {
					if (tradeWhit.equals(((GUI_Brewery) gui.getFields()[i]).getOwnerName())) {
						fieldName = ((GUI_Brewery) gui.getFields()[i]).getTitle();
					}
				} else if (i == 5 || i == 15 || i == 25 || i == 35) {
					if (tradeWhit.equals(((GUI_Shipping) gui.getFields()[i]).getOwnerName())) {
						fieldName = ((GUI_Shipping) gui.getFields()[i]).getTitle();
					}
				} else {
					if (tradeWhit.equals(((GUI_Street) gui.getFields()[i]).getOwnerName())) {
						fieldName = ((GUI_Street) gui.getFields()[i]).getTitle();
					}
				}
				if (tradeWhitsCounter < tradeWhitsFields.length && fieldName != "") {
					tradeWhitsFields[tradeWhitsCounter] = fieldName;
					tradeWhitsCounter++;
				}
			}
		}
		String iTrade = view.iTrade(gui, traderField); // the list with the fields he wants to trade
		String iWant = view.iWant(gui, tradeWhitsFields);	//the list of fields he can choose from
		boolean deal = view.deal(gui, "Vil du bytte: " + iTrade + " For: " + iWant); //del button 
		//if the deal takes place will the owner of the fields swap
		if (deal) {
			for (int i = 0; i < 40; i++) {
				if (i != 2 && i != 7 && i != 17 && i != 22 && i != 33 && i != 36 && i != 10 && i != 20 && i != 30
						&& i != 0 && i != 4 && i != 38) {
					//
					if (i == 12 || i == 28) {
						if (iWant.equals(((GUI_Brewery) gui.getFields()[i]).getTitle())) {
							((GUI_Brewery) gui.getFields()[i]).setOwnerName(player.getName());
							((GUI_Brewery) gui.getFields()[i]).setBorder(player.getCarObject().getPrimaryColor());
						}
					} else if (i == 5 || i == 15 || i == 25 || i == 35) {
						if (iWant.equals(((GUI_Shipping) gui.getFields()[i]).getTitle())) {
							((GUI_Shipping) gui.getFields()[i]).setOwnerName(player.getName());
							((GUI_Shipping) gui.getFields()[i]).setBorder(player.getCarObject().getPrimaryColor());
						}
					} else {
						if (iWant.equals(((GUI_Street) gui.getFields()[i]).getTitle())) {
							((GUI_Street) gui.getFields()[i]).setOwnerName(player.getName());
							((GUI_Street) gui.getFields()[i]).setBorder(player.getCarObject().getPrimaryColor());
						}
					}
				}
				Player tradePlayer = player;
				for (int x = 0; x < players.length; x++) {
					if (players[x].getName().equals(tradeWhit)) {
						tradePlayer = players[x];
					}
				}			
				if (i != 2 && i != 7 && i != 17 && i != 22 && i != 33 && i != 36 && i != 10 && i != 20 && i != 30
						&& i != 0 && i != 4 && i != 38) {
					if (i == 12 || i == 28) {
						if (iTrade.equals(((GUI_Brewery) gui.getFields()[i]).getTitle())) {
							((GUI_Brewery) gui.getFields()[i]).setOwnerName(tradePlayer.getName());
							((GUI_Brewery) gui.getFields()[i]).setBorder(tradePlayer.getCarObject().getPrimaryColor());
						}
					} else if (i == 5 || i == 15 || i == 25 || i == 35) {
						if (iTrade.equals(((GUI_Shipping) gui.getFields()[i]).getTitle())) {
							((GUI_Shipping) gui.getFields()[i]).setOwnerName(tradePlayer.getName());
							((GUI_Shipping) gui.getFields()[i]).setBorder(tradePlayer.getCarObject().getPrimaryColor());
						}
					} else {
						if (iTrade.equals(((GUI_Street) gui.getFields()[i]).getTitle())) {
							((GUI_Street) gui.getFields()[i]).setOwnerName(tradePlayer.getName());
							((GUI_Street) gui.getFields()[i]).setBorder(tradePlayer.getCarObject().getPrimaryColor());
						}
					}
				}
			}
		}
	}
}
