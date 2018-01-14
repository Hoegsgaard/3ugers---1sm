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
	final int[] fieldPrice = new int[40];
	boolean[] ownable = new boolean[40];
	int[] NumOffBuild = new int[40];
	int[] housePrice = { 50, 100, 150, 200 };
	int pirceForHouse;
	boolean Street = true;
	boolean Brewery = true;
	boolean shipping = true;
	int[][] rent = new int[][] { 
		{ 0 }, // Start
		{ 2, 10, 30, 90, 160, 250 }, 
		{ 0 }, // ChanceCard
		{ 4, 20, 60, 180, 320, 540 }, 
		{ 0 }, // StatsSkat
		{ 25, 50, 100, 200 }, // Shiping
		{ 6, 30, 90, 270, 400, 550 }, 
		{ 0 }, // ChanceCard
		{ 6, 30, 90, 270, 400, 550 }, 
		{ 8, 40, 100, 300, 450, 600 }, 
		{ 0 }, // JAil
		{ 10, 50, 150, 450, 625, 750 }, 
		{ 0 }, // bryggeri
		{ 10, 50, 150, 450, 625, 750 }, 
		{ 12, 60, 180, 500, 700, 900 }, 
		{ 25, 50, 100, 200 }, // Shiping
		{ 14, 70, 200, 550, 750, 950 }, 
		{ 0 }, // ChanceCard	
		{ 14, 70, 200, 550, 750, 950 }, 
		{ 16, 80, 220, 600, 800, 1000 }, 
		{ 0 }, // Park
		{ 18, 90, 250, 700, 875, 1050 }, 
		{ 0 }, // ChanceCard
		{ 18, 90, 250, 700, 875, 1050 }, 
		{ 20, 100, 300, 750, 925, 1100 }, 
		{ 25, 50, 100, 200 }, // Shiping
		{ 22, 110, 330, 800, 975, 1150 }, 
		{ 22, 110, 330, 800, 975, 1150 }, 
		{ 0 }, // bryggeri
		{ 22, 120, 360, 850, 1025, 1200 }, 
		{ 0 }, // GoTOJail
		{ 26, 130, 390, 900, 1100, 1275 }, 
		{ 26, 130, 390, 900, 1100, 1275 }, 
		{ 0 }, // ChanceCard
		{ 28, 150, 450, 1000, 1200, 1400 }, 
		{ 25, 50, 100, 200 }, // Shiping
		{ 0 }, // ChanceCard
		{ 35, 200, 500, 1100, 1300, 1500 }, 
		{ 0 }, // EkstraSkat
		{ 50, 200, 600, 1400, 1700, 2000 },
	};
	
	public void createBoard() {
		GUI.setNull_fields_allowed(true);
		startOpNumOffBuild();
		fields[0] = new GUI_Start();
		fields[0].setTitle("Start");
		fields[0].setSubText("Modtag: 200");
		createStreet(1, "Rødovrevej", Color.CYAN, 60);
		fields[2] = new GUI_Chance();
		fields[2].setSubText("Chance");
		createStreet(3, "Hvidovre", Color.CYAN, 60);
		fields[4] = new GUI_Tax();
		fields[4].setTitle("Stats skat");
		fields[4].setSubText("Betal skat");
		fields[4].setDescription("Betal 4000 eller 10% af dine samlede værdier");
		fields[5] = new GUI_Shipping();
		fields[5].setTitle("D/S Bornholm");
		fields[5].setSubText("Pris: 200");
		createStreet(6, "Roskildevej", Color.pink, 100);
		fields[7] = new GUI_Chance();
		fields[7].setSubText("Chance");
		createStreet(8, "Valby Langgade", Color.pink, 100);
		createStreet(9, "Allegade", Color.pink, 120);
		fields[10] = new GUI_Jail();
		fields[10].setSubText("På besøg");
		createStreet(11, "Frederiksberg Alle", Color.green, 140);
		fields[12] = new GUI_Brewery();
		fields[12].setTitle("Tuborg");
		fields[12].setSubText("Pris: 150");
		createStreet(13, "Bulowsvej", Color.green, 140);
		createStreet(14, "GL. Kongevej", Color.green, 160);
		fields[15] = new GUI_Shipping();
		fields[15].setTitle("Øresund A/S");
		fields[15].setSubText("Pris: 200");
		createStreet(16, "Bernstorffsvej", Color.gray, 180);
		fields[17] = new GUI_Chance();
		fields[17].setSubText("Chance");
		createStreet(18, "Hellerupvej", Color.gray, 180);
		createStreet(19, "Strandvej", Color.gray, 200);
		fields[20] = new GUI_Refuge();
		fields[20].setSubText("Parkering");
		createStreet(21, "Trianglen", Color.red, 220);
		fields[22] = new GUI_Chance();
		fields[22].setSubText("Chance");
		createStreet(23, "Østerbrogade", Color.red, 220);
		createStreet(24, "Grøninningen", Color.red, 240);
		fields[25] = new GUI_Shipping();
		fields[25].setTitle("D.F.D.S.");
		fields[25].setSubText("Pris: 200");
		createStreet(26, "Bredegade", Color.white, 260);
		createStreet(27, "Kgs. Nytorv", Color.white, 260);
		fields[28] = new GUI_Brewery();
		fields[28].setTitle("Carlsberg");
		fields[28].setSubText("Pris: 150");
		createStreet(29, "Østergade", Color.white, 280);
		fields[30] = new GUI_Jail();
		fields[30].setSubText("Gå i fængsel");
		createStreet(31, "Amagertorv", Color.yellow, 300);
		createStreet(32, "Vimmelskaftet", Color.yellow, 300);
		fields[33] = new GUI_Chance();
		fields[33].setSubText("Chance");
		createStreet(34, "Nygade", Color.yellow, 320);
		fields[35] = new GUI_Shipping();
		fields[35].setTitle("D.K.");
		fields[35].setSubText("Pris: 200");
		fields[36] = new GUI_Chance();
		fields[36].setSubText("Chance");
		createStreet(37, "Frederiksberggade", Color.magenta, 350);
		fields[38] = new GUI_Tax();
		fields[38].setTitle("Ekstraordinær skat");
		fields[38].setSubText("Betal 100");
		createStreet(39, "Rådhuspladsen", Color.magenta, 400);
		brewShipSetSetup();
	}

	private void createStreet(int field, String name, Color color, int price) {
		fields[field] = new GUI_Street();
		fields[field].setTitle(name);
		fields[field].setSubText("Pris: " + price);
		fields[field].setBackGroundColor(color);
		ownable[field] = true;
		((GUI_Street) fields[field]).setOwnerName(null);
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
			((GUI_Shipping) fields[i]).setOwnerName(null);
			setPrice(i, 200);
		}
	}

	public GUI_Field[] getFields() {
		return fields;
	}
	public void startOpNumOffBuild() {
		for (int i = 0; i < NumOffBuild.length; i++) {
			NumOffBuild[i] = 0;
		}
	}
	// Ownable get og set
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
	public int getRentStreet(int field) {
		return rent[field][getNumOffBuild(field)];
	}
	public int getRentBrewery(int sum, int count) {
		int rent = 0;
		if (count == 1) {
			rent = sum * 4;
		} else if (count == 2) {
			rent = sum * 10;
		}
		return rent;
	}
	public int getRentShipping(int count) {
		int pay = 0;
		switch (count) {
		case 1:
			pay = rent[5][0];
			break;
		case 2:
			pay = rent[5][1];
			break;
		case 3:
			pay = rent[5][2];
			break;
		case 4:
			pay = rent[5][3];
			break;
		}
		return pay;
	}
	
	public int pirceForHouse(int val) {
		return housePrice[val];
	}
	public int getNumOffBuild(int field) {
		return NumOffBuild[field];
	}
	public void setNumOffBuild(int field, int num) {
		NumOffBuild[field] = 0;
	}
	public void changeNumOffBuild(int field, int num) {
		NumOffBuild[field] = getNumOffBuild(field) + num;
	}
	public void sellAll(Player player, GUI gui) {
		for (int i = 0; i < fields.length; i++) { // ALT HVAD DER IKKE KAN KØBES ER UDELUKKET
			if (i != 2 && i != 7 && i != 17 && i != 22 && i != 33 && i != 36 && i != 10 && i != 20 && i != 30 && i != 0
					&& i != 4 && i != 38) {
				if (i == 12 || i == 28) { //Hvis spilleren står på et bryggeri
					if (player.getName().equals(((GUI_Brewery) gui.getFields()[i]).getOwnerName())) {
						setOwnable(i, true);
						((GUI_Brewery) gui.getFields()[i]).setBorder(Color.black);
					}
				} else if (i == 5 || i == 15 || i == 25 || i == 35) { //Hvis spilleren står på et shipperi?
					if (player.getName().equals(((GUI_Shipping) gui.getFields()[i]).getOwnerName())) {
						setOwnable(i, true);
						((GUI_Shipping) gui.getFields()[i]).setBorder(Color.BLACK);
					}
				} else { // Kun Streets er tilbage
					if (player.getName().equals(((GUI_Street) gui.getFields()[i]).getOwnerName())) {
						setOwnable(i, true);
						((GUI_Street) gui.getFields()[i]).setBorder(Color.BLACK);
						((GUI_Street) gui.getFields()[i]).setHotel(false);
						((GUI_Street) gui.getFields()[i]).setHouses(0);
					}
				}
			}
		}
	}
}