package Game;

import java.awt.Color;

import gui_fields.GUI_Brewery;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_fields.GUI_Tax;
import gui_main.GUI;

public class GameBoard {
	public GameBoard() {

	}

	GUI_Field[] fields = new GUI_Field[40];

	int[] fieldPrice = new int[40];
	boolean[] ownable = new boolean[40];
	int[] housePrice = { 50, 100, 150, 200 };
	int pirceForHouse;
	int[] rent = new int[6];

	int[] rentRoedovervej = { 50, 250, 750, 2250, 4000, 6000 };
	int[] rentHvidover = { 50, 250, 750, 2250, 4000, 6000 };
	int[] rentRoskildevej = { 100, 600, 1800, 5400, 8000, 11000 };
	int[] rentValbylanggade = { 100, 600, 1800, 5400, 8000, 11000 };
	int[] rentAllegade = { 150, 800, 2000, 6000, 9000, 12000 };
	int[] rentFrederiksbergalle = { 200, 1000, 3000, 9000, 12500, 15000 };
	int[] rentBulowsvej = { 200, 1000, 3000, 9000, 12500, 15000 };
	int[] rentGammelKongeVej = { 250, 1250, 3750, 10000, 14000, 18000 };
	int[] rentBernstorffsvej = { 300, 1400, 4000, 11000, 15000, 19000 };
	int[] rentHellerupvej = { 300, 1400, 4000, 11000, 15000, 19000 };
	int[] rentStrandvejen = { 350, 1600, 4400, 12000, 16000, 20000 };
	int[] rentTrianglen = { 350, 1800, 5000, 14000, 17500, 21000 };
	int[] rentOesterbrogade = { 350, 1800, 5000, 14000, 17500, 21000 };
	int[] rentGroenningen = { 400, 2000, 6000, 15000, 18500, 22000 };
	int[] rentBredgade = { 450, 2200, 6600, 16000, 19500, 23000 };
	int[] rentKgsNytov = { 450, 2200, 6600, 16000, 19500, 23000 };
	int[] rentOestergade = { 500, 2400, 7200, 17000, 20500, 24000 };
	int[] rentAmagerto = { 550, 2600, 7800, 18000, 22000, 25000 };
	int[] rentVimmelskaftet = { 550, 2600, 7800, 18000, 22000, 25000 };
	int[] rentNygade = { 600, 3000, 9000, 20000, 24000, 28000 };
	int[] rentFrederiksberggade = { 700, 3500, 10000, 22000, 26000, 30000 };
	int[] rentRÃ¥dhuspladesen = { 1000, 4000, 12000, 28000, 34000, 40000 };

	public void createBoard() {
		GUI.setNull_fields_allowed(true);
		fields[0] = new GUI_Start();
		fields[0].setTitle("Start");
		fields[0].setSubText("Modtag: 200");
		createStreet(1, "Roedeorevej", Color.CYAN, 60, housePrice[0], rentRoedovervej);
		fields[2] = new GUI_Chance();
		fields[2].setSubText("Chance");
		createStreet(3, "Hvidovre", Color.CYAN, 60, housePrice[0], rentHvidover);
		fields[4] = new GUI_Tax();
		fields[4].setTitle("Stats skat");
		fields[4].setSubText("Betal skat");
		fields[4].setDescription("Betal 4000 eller 10% af dine samlede værdier");
		fields[5] = new GUI_Shipping();
		fields[5].setTitle("D/S Bornholm");
		fields[5].setSubText("Pris: 200");
		createStreet(6, "Roskildevej", Color.pink, 100, housePrice[0], rentRoskildevej);
		fields[7] = new GUI_Chance();
		fields[7].setSubText("Chance");
		createStreet(8, "Valby Langgade", Color.pink, 100, housePrice[0], rentValbylanggade);
		createStreet(9, "Allegade", Color.pink, 120, housePrice[0], rentAllegade);
		fields[10] = new GUI_Jail();
		fields[10].setSubText("På besøg");
		createStreet(11, "Frederiksberg Alle", Color.green, 140, housePrice[0], rentFrederiksbergalle);
		fields[12] = new GUI_Brewery();
		fields[12].setTitle("Tuborg");
		fields[12].setSubText("Pris: 150");
		createStreet(13, "Bulowsvej", Color.green, 140, housePrice[1], rentBulowsvej);
		createStreet(14, "GL. Kongevej", Color.green, 160, housePrice[1], rentGammelKongeVej);
		fields[15] = new GUI_Shipping();
		fields[15].setTitle("Øresund A/S");
		fields[15].setSubText("Pris: 200");
		createStreet(16, "Bernstorffsvej", Color.gray, 180, housePrice[1], rentBernstorffsvej);
		fields[17] = new GUI_Chance();
		fields[17].setSubText("Chance");
		createStreet(18, "Hellerupvej", Color.gray, 180, housePrice[1], rentHellerupvej);
		createStreet(19, "Strandvej", Color.gray, 200, housePrice[1], rentStrandvejen);
		fields[20] = new GUI_Refuge();
		fields[20].setSubText("Parkering");
		createStreet(21, "Trianglen", Color.red, 220, housePrice[2], rentTrianglen);
		fields[22] = new GUI_Chance();
		fields[22].setSubText("Chance");
		createStreet(23, "Østerbrogade", Color.red, 220, housePrice[2], rentOesterbrogade);
		createStreet(24, "Grøninningen", Color.red, 240, housePrice[2], rentGroenningen);
		fields[25] = new GUI_Shipping();
		fields[25].setTitle("D.F.D.S.");
		fields[25].setSubText("Pris: 200");
		createStreet(26, "Bredegade", Color.white, 260, housePrice[2], rentBredgade);
		createStreet(27, "Kgs. Nytorv", Color.white, 260, housePrice[2], rentKgsNytov);
		fields[28] = new GUI_Brewery();
		fields[28].setTitle("Carlsberg");
		fields[28].setSubText("Pris: 150");
		createStreet(29, "Østergade", Color.white, 280, housePrice[2], rentOestergade);
		fields[30] = new GUI_Jail();
		fields[30].setSubText("Gå i fængsel");
		createStreet(31, "Amagertorv", Color.yellow, 300, housePrice[3], rentAmagerto);
		createStreet(32, "Vimmelskaftet", Color.yellow, 300, housePrice[3], rentVimmelskaftet);
		fields[33] = new GUI_Chance();
		fields[33].setSubText("Chance");
		createStreet(34, "Nygade", Color.yellow, 320, housePrice[3], rentNygade);
		fields[35] = new GUI_Shipping();
		fields[35].setTitle("D.K.");
		fields[35].setSubText("Pris: 200");
		fields[36] = new GUI_Chance();
		fields[36].setSubText("Chance");
		createStreet(37, "Frederiksberggade", Color.magenta, 350, housePrice[3], rentFrederiksberggade);
		fields[38] = new GUI_Tax();
		fields[38].setTitle("Ekstraordinær skat");
		fields[38].setSubText("Betal 2000");
		createStreet(39, "Rådhuspladsen", Color.magenta, 400, housePrice[3], rentRÃ¥dhuspladesen);
		brewShipSetSetup();
		}

	private void createStreet(int field, String name, Color color, int price, int housePrice, int[] rentAr) {
		fields[field] = new GUI_Street();
		fields[field].setTitle(name);
		fields[field].setSubText("Pris: " + price);
		fields[field].setBackGroundColor(color);
		ownable[field] = true;
		((GUI_Street) fields[field]).setOwnerName(null);
		pirceForHouse = housePrice;
		for (int i = 0; i < rentAr.length; i++) {
			this.rent[i] = rentAr[i];
		}
		fieldPrice[field] = price;
		
	}
	
	private void brewShipSetSetup() {
		ownable[12] = true;
		((GUI_Brewery) fields[12]).setOwnerName(null);
		setPrice(12, 150);
		
		ownable[28] = true;
		((GUI_Brewery) fields[28]).setOwnerName(null);
		setPrice(28, 150);
		for (int i = 5; i < 40; i = i + 10) {
			ownable[i] = true;
			((GUI_Shipping)fields[i]).setOwnerName(null);
			setPrice(i, 200);
		}
	}
	
	public GUI_Field[] getFields() {
		return fields;
	}
	
	//Ownable get og set
	public boolean getOwnable(int field) {
		return ownable[field]; 	
	}
	public void setOwnable(int field, boolean own) {
		ownable[field] = own;
	}
	
	public GUI_Street getStreet(int field) {
		return ((GUI_Street) fields[field]);
	}
	public GUI_Brewery getBrewery(int field) {
		return ((GUI_Brewery) fields[field]);
	}
	public GUI_Shipping getShipping(int field) {
		return ((GUI_Shipping) fields[field]);
	}
	public int getPrice(int field) {
		return fieldPrice[field];
	}
	public void setPrice(int fields, int price) {
		fieldPrice[fields] = price;
	}
	
}

