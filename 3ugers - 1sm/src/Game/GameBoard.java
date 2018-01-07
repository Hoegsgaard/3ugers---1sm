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
	
	GUI_Field[] fields = new GUI_Field[40];
	
	boolean ownable;
	int[] housePrice = {1000,2000,3000,4000};
	int pirceForHouse;
	int[] rent = new int[6];
	
	int[] rentRødovervej = {50, 250, 750, 2250, 4000, 6000};
	int[] rentHvidover = {50, 250, 750, 2250, 4000, 6000};
	int[] rentRoskildevej = {100, 600, 1800, 5400, 8000, 11000};
	int[] rentValbylanggade = {100, 600, 1800, 5400, 8000, 11000};
	int[] rentAllégade = {150, 800, 2000, 6000, 9000, 12000};
	int[] rentFrederiksbergalle = {200, 1000, 3000, 9000, 12500, 15000};
	int[] rentBülowsvej = {200, 1000, 3000, 9000, 12500, 15000};
	int[] rentGammelKongeVej = {250, 1250, 3750, 10000, 14000, 18000};
	int[] rentBernstorffsvej = {300, 1400, 4000, 11000, 15000, 19000};
	int[] rentHellerupvej = {300, 1400, 4000, 11000, 15000, 19000};
	int[] rentStrandvejen = {350, 1600, 4400, 12000, 16000, 20000};
	int[] rentTrianglen = {350, 1800, 5000, 14000, 17500, 21000};
	int[] rentØsterbrogade = {350, 1800, 5000, 14000, 17500, 21000};
	int[] rentGrønningen = {400, 2000, 6000, 15000, 18500, 22000};
	int[] rentBredgade = {450, 2200, 6600, 16000, 19500, 23000};
	int[] rentKgsNytov = {450, 2200, 6600, 16000, 19500, 23000};
	int[] rentØstergade = {500, 2400, 7200, 17000, 20500, 24000};
	int[] rentAmagerto = {550, 2600, 7800, 18000, 22000, 25000};
	int[] rentVimmelskaftet = {550, 2600, 7800, 18000, 22000, 25000};
	int[] rentNygade = {600, 3000, 9000, 20000, 24000, 28000};
	int[] rentFrederiksberggade = {700, 3500, 10000, 22000, 26000, 30000};
	int[] rentRådhuspladesen = {1000, 4000, 12000, 28000, 34000, 40000};
	
	
	
	
	
	public GameBoard() {
		
	}
	
	public GUI_Field[] getFields() {
		
		return fields;
	}

	public void createBoard() {
		GUI.setNull_fields_allowed(true);
		fields[0] = new GUI_Start();
		fields[0].setTitle("Start");
		fields[0].setSubText("Modtag: 1000");
		createStreet(1, "Rødeorevej", Color.CYAN, 1200, housePrice[0], rentRødovervej);
		fields[2] = new GUI_Chance();
		fields[2].setSubText("Take a Chance");
		createStreet(3, "Hvidovre", Color.CYAN, 1200, housePrice[0], rentRødovervej);
		//Skat
		/*Rederi*/ fields[5] = new GUI_Shipping();
		createStreet(6, "Roskildevej", Color.pink, 2000, housePrice[0], rentRødovervej);
		fields[7] = new GUI_Chance();
		fields[7].setSubText("Take a Chance");
		createStreet(8, "Valby Langgade", Color.pink, 2000, housePrice[0], rentRødovervej);
		createStreet(9, "Allégade", Color.pink, 2400, housePrice[0], rentRødovervej);
		/*Fængsel (På besøg)*/fields[10] = new GUI_Jail();
								fields[10].setSubText("På besøg");
		createStreet(11, "Frederiksberg Allé", Color.green, 2800, housePrice[0], rentRødovervej);
		/*Cola*/ fields[12] = new GUI_Brewery();
			//Mangler SUB
		createStreet(13, "Büllowsvej", Color.green, 2800, housePrice[1], rentRødovervej);
		createStreet(14, "GL. Kongevej", Color.green, 3200, housePrice[1], rentRødovervej);
		/*Rederi*/ fields[15] = new GUI_Shipping();
		createStreet(16, "Bernstorffsvej", Color.gray, 3600, housePrice[1], rentRødovervej);
		fields[17] = new GUI_Chance();
		fields[17].setSubText("Take a Chance");
		createStreet(18, "Hellerupvej", Color.gray, 3600, housePrice[1], rentRødovervej);
		createStreet(19, "Strandvej", Color.gray, 4000, housePrice[1], rentRødovervej);
		/*Parkering*/
		createStreet(21, "Trianglen", Color.red, 4400, housePrice[2], rentRødovervej);
		fields[22] = new GUI_Chance();
		fields[22].setSubText("Take a Chance");
		createStreet(23, "Østerbrogade", Color.red, 4400, housePrice[2], rentRødovervej);
		createStreet(24, "Grønningen", Color.red, 4800, housePrice[2], rentRødovervej);
		/*Rederi*/ fields[25] = new GUI_Shipping();
		createStreet(26, "Bredegade", Color.white, 5200, housePrice[2], rentRødovervej);
		createStreet(27, "Kgs. Nytorv", Color.white, 5200, housePrice[2], rentRødovervej);
		/*Faxe*/ fields[28] = new GUI_Brewery();
			//Mangler SUB
		createStreet(29, "Østergade", Color.white, 5600, housePrice[2], rentRødovervej);
		/*Ryk ik fængsel*/ 
		createStreet(31, "Amagertorv", Color.yellow, 6000, housePrice[3], rentRødovervej);
		createStreet(32, "Vimmelskaftet", Color.yellow, 6000, housePrice[3], rentRødovervej);
		fields[33] = new GUI_Chance();
		fields[33].setSubText("Take a Chance");
		createStreet(34, "Nygade", Color.yellow, 6400, housePrice[3], rentRødovervej);
		/*Rederi*/ fields[35] = new GUI_Shipping();
		fields[36] = new GUI_Chance();
		fields[36].setSubText("Take a Chance");
		createStreet(37, "Frederiksberggade", Color.magenta, 7000, housePrice[3], rentRødovervej);
		/*Ekstraordinær statsskat betal kr. 2.000*/
		createStreet(39, "Rådhuspladsen", Color.magenta, 8000, housePrice[3], rentRødovervej);
		GUI gui = new GUI(fields);
		createStreet(37, "Frederiksberggade", Color.magenta, 7000, housePrice[3], rentRødovervej);
		//Ekstraordinær statsskat betal kr. 2.000
		createStreet(39, "Rådhuspladsen", Color.magenta, 8000, housePrice[3], rentRødovervej);
		}

	private void createStreet(int field, String name, Color color, int price, int housePrice, int[] test) {
		fields[field] = new GUI_Street();
		fields[field].setTitle(name);
		fields[field].setSubText("Pris: " + price);
		fields[field].setBackGroundColor(color);
		ownable = true;
		pirceForHouse = housePrice;
		//rent
		for (int i = 0; i < test.length; i++) {
			int hold = test[i]; 
			rent[i] = hold;
			System.out.println(rent[i]);
		} 
	}
	
}
