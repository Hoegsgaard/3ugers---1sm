package Game;

import java.awt.Color;

import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class GameBoard {
	
	GUI_Field[] fields = new GUI_Field[40];
	
	boolean ownable;
	int[] housePrice = {1000,2000,3000,4000};
	int pirceForHouse;
	int[] rent;
	
	
	public GameBoard() {
		
	}

	public void createBoard() {
		GUI.setNull_fields_allowed(true);
		fields[0] = new GUI_Start();
		fields[0].setTitle("Start");
		fields[0].setSubText("Gain: 1000");
		createStreet(1, "Rødeorevej", Color.CYAN, 1200, housePrice[0]);
		fields[2] = new GUI_Chance();
		fields[2].setSubText("Take a Chance");
		createStreet(3, "Hvidovre", Color.CYAN, 1200, housePrice[0]);
		//Skat
		//Rederi
		createStreet(6, "Roskildevej", Color.pink, 2000, housePrice[0]);
		fields[7] = new GUI_Chance();
		fields[7].setSubText("Take a Chance");
		createStreet(8, "Valby Langgade", Color.pink, 2000, housePrice[0]);
		createStreet(9, "Allégade", Color.pink, 2400, 1000);
		//Fængsel (På besøg)
		createStreet(11, "Frederiksberg Allé", Color.green, 2800, housePrice[0]);
		//Cola
		createStreet(13, "Büllowsvej", Color.green, 2800, housePrice[1]);
		createStreet(14, "GL. Kongevej", Color.green, 3200, housePrice[1]);
		//Rederi
		createStreet(16, "Bernstorffsvej", Color.gray, 3600, housePrice[1]);
		fields[17] = new GUI_Chance();
		fields[17].setSubText("Take a Chance");
		createStreet(18, "Hellerupvej", Color.gray, 3600, housePrice[1]);
		createStreet(19, "Strandvej", Color.gray, 4000, housePrice[1]);
		//Parkering
		createStreet(21, "Trianglen", Color.red, 4400, housePrice[2]);
		fields[22] = new GUI_Chance();
		fields[22].setSubText("Take a Chance");
		createStreet(23, "Østerbrogade", Color.red, 4400, housePrice[2]);
		createStreet(24, "Grønningen", Color.red, 4800, housePrice[2]);
		//Rederi
		createStreet(26, "Bredegade", Color.white, 5200, housePrice[2]);
		createStreet(27, "Kgs. Nytorv", Color.white, 5200, housePrice[2]);
		//Faxe
		createStreet(29, "Østergade", Color.white, 5600, housePrice[2]);
		// Ryk ik fængsel
		createStreet(31, "Amagertorv", Color.yellow, 6000, housePrice[3]);
		createStreet(32, "Vimmelskaftet", Color.yellow, 6000, housePrice[3]);
		fields[33] = new GUI_Chance();
		fields[33].setSubText("Take a Chance");
		createStreet(34, "Nygade", Color.yellow, 6400, housePrice[3]);
		//Rederi
		fields[36] = new GUI_Chance();
		fields[36].setSubText("Take a Chance");
		createStreet(37, "Frederiksberggade", Color.magenta, 7000, housePrice[3]);
		//Ekstraordinær statsskat betal kr. 2.000
		createStreet(39, "Rådhuspladsen", Color.magenta, 8000, housePrice[3]);
		GUI gui = new GUI(fields);
	}

	private void createStreet(int field, String name, Color color, int price, int housePrice) {
		fields[field] = new GUI_Street();
		fields[field].setTitle(name);
		fields[field].setSubText("Cost: " + price);
		fields[field].setBackGroundColor(color);
		ownable = true;
		pirceForHouse = housePrice;
		
	}
	
}
