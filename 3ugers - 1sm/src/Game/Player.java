package Game;

import gui_fields.GUI_Player;

public class Player { 
	private int currentField = 0;
	private static int playerCounter = 1;
	private int playerNumber;
	private int balance = 0;
	private int fieldvalue = 0;
	private int housevalue = 0;
	private int totalValue = 0;
	private String name = "";
	private GUI_Player carObject;
	private boolean inJail = false;
	private boolean hasJailCard = false;
	private int houseOwned = 0;
	private int hotelOwned = 0;
	private boolean bankrupt = false;

	public Player() {
		playerNumber = playerCounter++;
	}
	public int houseOwned() {	
		return houseOwned;	   
	}
	public int hotelOwned() {
		return hotelOwned;
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
	public void setBalance(int val) {
		balance = val;
	}
	public void changeBalance(int balance) {	// change the balance of the player
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
	public boolean getInJail() {
		return inJail;
	}	
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}	
	public int getTotalValue() {
		return totalValue;
	}	
	public void setTotalValue(int val) {
		totalValue = val;
	}	
	public void changeTotalValue() {
		totalValue = getBalance() + getFieldValue() + getHouseValue();
	}	
	public int setFieldValue(int val) {
		return fieldvalue = fieldvalue + val;
	}
	public int getFieldValue() {
		return fieldvalue;
	}
	public void setBankrupt(boolean bank) {
		bankrupt = bank;
	}
	public boolean getBankrupt() {
		return bankrupt;
	}
	public int getHouseValue() {
		return fieldvalue;
	}
	public void setHouseValue(int val) {
		housevalue = housevalue + val;
	}
}


