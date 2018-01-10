package Game;

import gui_main.GUI;
import Controller.Controller;
import gui_fields.GUI_Street;

public class BuyProperty {
	Controller cont = new Controller();
	boolean playerCanBuy = false;
	 
	public BuyProperty() {

	}

	boolean[] sameColor = { false, false, false, false, false, false, false, false };

	public String ownerOfFieldName(int field, GUI gui) {
		return ((GUI_Street) gui.getFields()[field]).getOwnerName();
	}

	public void isAllOwendInSameColor(GUI gui, Player player) {
		if (ownerOfFieldName(1, gui).equals(ownerOfFieldName(3, gui))&& player.getName().equals(ownerOfFieldName(1,gui))) {
			sameColor[0] = true;
		}
		if (ownerOfFieldName(6, gui).equals(ownerOfFieldName(8, gui))
				&& ownerOfFieldName(6, gui).equals(ownerOfFieldName(9, gui)) && player.getName().equals(ownerOfFieldName(6,gui))) {
			sameColor[1] = true;
		}
		if (ownerOfFieldName(11, gui).equals(ownerOfFieldName(13, gui))
				&& ownerOfFieldName(11, gui).equals(ownerOfFieldName(14, gui)) && player.getName().equals(ownerOfFieldName(11,gui))) {
			sameColor[2] = true;
		}
		if (ownerOfFieldName(16, gui).equals(ownerOfFieldName(18, gui))
				&& ownerOfFieldName(16, gui).equals(ownerOfFieldName(19, gui)) && player.getName().equals(ownerOfFieldName(16,gui))) {
			sameColor[3] = true;
		}
		if (ownerOfFieldName(21, gui).equals(ownerOfFieldName(23, gui))
				&& ownerOfFieldName(21, gui).equals(ownerOfFieldName(24, gui)) && player.getName().equals(ownerOfFieldName(21,gui))) {
			sameColor[4] = true;
		}
		if (ownerOfFieldName(26, gui).equals(ownerOfFieldName(27, gui))
				&& ownerOfFieldName(26, gui).equals(ownerOfFieldName(29, gui))&& player.getName().equals(ownerOfFieldName(26,gui))) {
			sameColor[5] = true;
		}
		if (ownerOfFieldName(31, gui).equals(ownerOfFieldName(32, gui))
				&& ownerOfFieldName(31, gui).equals(ownerOfFieldName(34, gui))&& player.getName().equals(ownerOfFieldName(31,gui))) {
			sameColor[6] = true;
		}
		if (ownerOfFieldName(37, gui).equals(ownerOfFieldName(39, gui))&& player.getName().equals(ownerOfFieldName(37,gui))) {
			sameColor[7] = true;
		}
	}

	public void isBuildPossible() {
		
	}

	public void buildHouse(GUI gui, Player player, int field) {
		((GUI_Street) gui.getFields()[field]).setHouses(1);

	}

	// public void enableBuildHouse(Player player, GUI gui, int field) {
	// if (sameColorOwnedCyan = true) {
	// buildHouse(gui, player, 1);
	// buildHouse(gui, player, 3);
	// }
	// if (sameColorOwnedPink = true) {
	//
	// }
	// if (sameColorOwnedGreen = true) {
	//
	// }
	// if (sameColorOwnedGray = true) {
	//
	// }
	// if (sameColorOwnedRed = true) {
	//
	// }
	// if (sameColorOwnedWhite = true) {
	//
	// }
	// if (sameColorOwnedYellow = true) {
	//
	// }
	// if (sameColorOwnedMagenta = true) {
	//
	// }
	// }
}