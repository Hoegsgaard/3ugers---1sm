package Game;

import gui_fields.GUI_Player;
//import gui_main.GUI;

public class Player { 
	private int currentField = 0;
	private static int playerCounter = 1;
	private int playerNumber;
	private int balance = 0;
	private int totalValue = 1000;
	private String name = "";
	private GUI_Player carObject;
	private boolean hasJailCard = false;
	private int house = 0;
	private int hotel = 0;

	public Player() {
		playerNumber = playerCounter++;

	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	public GUI_Player getCarObject() {
		return carObject;
	}
	
	public void setCarObject(GUI_Player obj) {
		this.carObject = obj;
	}

	public int getCurrentField() {
		return currentField;
	}

	public void setCurrentField(int currentField) {
		this.currentField = currentField;
	}

	public int getBalance() {
		return balance;
	}

	public void changeBalance(int balance) {
		this.balance += balance;
		carObject.setBalance(this.balance);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}

	public boolean getHasJailCard() {
		return hasJailCard;
	}

	public void setHasJailCard(boolean hasJailCard) {
		this.hasJailCard = hasJailCard;
	}
	
	public int getTotalValue() {
		return totalValue;
	}
	
	public void setTotalValue(int val) {
		totalValue = totalValue + val;
	}
	
}


