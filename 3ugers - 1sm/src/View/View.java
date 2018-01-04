package View;

import java.awt.Color;

import Game.Player;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Player;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_main.GUI;


public class View {
	
	GUI_Field[] fields = new GUI_Field[40];
	GUI_Player p2 = new GUI_Player("rambo", 0);
	
	

	public String roll(GUI gui) {
		
		return gui.getUserString("enter") ;
		
		
	}	
	
	public void runGame() {
  	createBoard();
  	GUI gui = new GUI(fields);
  	roll(gui);
	}
	public void createBoard() {
		GUI.setNull_fields_allowed(true);
		fields[0] = new GUI_Start();
		fields[0].setTitle("Start");
		fields[0].setSubText("Gain: 1000");
		createStreet(1, "Rødeorevej", Color.CYAN, 60);
		fields[2] = new GUI_Chance();
		fields[2].setSubText("Take a Chance");
		createStreet(3, "Hvidovre", Color.CYAN, 60);
		
	}

//	public Game() {
//
//	}

	
	private void createStreet(int field, String name, Color color, int rent) {
		fields[field] = new GUI_Street();
		fields[field].setTitle(name);
		fields[field].setBackGroundColor(color);
		((GUI_Street)fields[field]).setRentLabel("Cost: ");
		((GUI_Street)fields[field]).setRent(Integer.toString(rent));
		//setOwner(field, "none");
	}
	
}