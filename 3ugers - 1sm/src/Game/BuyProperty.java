package Game;

import gui_main.GUI;
import gui_fields.GUI_Street;

public class BuyProperty {
	boolean playerCanBuy = false;

	int counterCyan, counter2 = 0;


	
	public BuyProperty() {

	}
	
	boolean[] sameColor = { false, false, false, false, false, false, false, false };
	
	public String ownerOfFieldName(int field, GUI gui) {
		return ((GUI_Street) gui.getFields()[field]).getOwnerName();

	}

	public void isAllOwendInSameColor(GUI gui, Player player) {
		try {
			if (ownerOfFieldName(1, gui).equals(ownerOfFieldName(3, gui))
					&& player.getName().equals(ownerOfFieldName(3, gui)) && counterCyan < 4) {
				counterCyan++;
				((GUI_Street) gui.getFields()[1]).setHouses(counterCyan);

			}
			if (ownerOfFieldName(6, gui).equals(ownerOfFieldName(8, gui))
					&& ownerOfFieldName(6, gui).equals(ownerOfFieldName(9, gui))
					&& player.getName().equals(ownerOfFieldName(6, gui)) && counter2 <= 4) {
				counter2++;
				System.out.println("HAaalo!");
				((GUI_Street) gui.getFields()[6]).setHouses(counter2);
			}
			if (ownerOfFieldName(11, gui).equals(ownerOfFieldName(13, gui))
					&& ownerOfFieldName(11, gui).equals(ownerOfFieldName(14, gui))
					&& player.getName().equals(ownerOfFieldName(11, gui))) {
				sameColor[2] = true;
			}
			if (ownerOfFieldName(16, gui).equals(ownerOfFieldName(18, gui))
					&& ownerOfFieldName(16, gui).equals(ownerOfFieldName(19, gui))
					&& player.getName().equals(ownerOfFieldName(16, gui))) {
				sameColor[3] = true;
			}
			if (ownerOfFieldName(21, gui).equals(ownerOfFieldName(23, gui))
					&& ownerOfFieldName(21, gui).equals(ownerOfFieldName(24, gui))
					&& player.getName().equals(ownerOfFieldName(21, gui))) {
				sameColor[4] = true;
			}
			if (ownerOfFieldName(26, gui).equals(ownerOfFieldName(27, gui))
					&& ownerOfFieldName(26, gui).equals(ownerOfFieldName(29, gui))
					&& player.getName().equals(ownerOfFieldName(26, gui))) {
				sameColor[5] = true;
			}
			if (ownerOfFieldName(31, gui).equals(ownerOfFieldName(32, gui))
					&& ownerOfFieldName(31, gui).equals(ownerOfFieldName(34, gui))
					&& player.getName().equals(ownerOfFieldName(31, gui))) {
				sameColor[6] = true;
			}
			if (ownerOfFieldName(37, gui).equals(ownerOfFieldName(39, gui))
					&& player.getName().equals(ownerOfFieldName(37, gui))) {
				counter2++;
				((GUI_Street) gui.getFields()[39]).setHouses(counter2);

			}
		} catch (NullPointerException e) {
			System.out.println();
		}

	}
	public void getCyan (GUI gui, Player player) {
		if (ownerOfFieldName(1, gui).equals(ownerOfFieldName(3, gui))
				&& player.getName().equals(ownerOfFieldName(3, gui)) && counterCyan < 4) {
			counterCyan++;
			((GUI_Street) gui.getFields()[1]).setHouses(counterCyan);

		}
	}
	public void getPink (GUI gui, Player player) {
		if (ownerOfFieldName(6, gui).equals(ownerOfFieldName(8, gui))
				&& ownerOfFieldName(6, gui).equals(ownerOfFieldName(9, gui))
				&& player.getName().equals(ownerOfFieldName(6, gui)) && counter2 <= 4) {
			counter2++;
			System.out.println("HAaalo!");
			((GUI_Street) gui.getFields()[6]).setHouses(counter2);
		}
	}
	

	public void buildHouse(GUI gui, int field) {
		((GUI_Street) gui.getFields()[field]).setHouses(1);

	}
	
	public void choiceOfArea(String choice, GUI gui, Player player) {
		switch(choice) {
		case "Cyan":
			getCyan(gui, player);
			break;
		case "Pink":
			getPink(gui, player);
			break;
		
		}
	}

}