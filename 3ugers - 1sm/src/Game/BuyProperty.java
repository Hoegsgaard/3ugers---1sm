package Game;

import gui_main.GUI;
import gui_fields.GUI_Street;

public class BuyProperty {
	boolean playerCanBuy = false;

	int counterCyan, counterPink, counterGreen, counterGrey, counterRed, counterWhite, counterYellow,
			counterMagenta = 0;

	public BuyProperty() {

	}

	boolean[] sameColor = { false, false, false, false, false, false, false, false };

	public String ownerOfFieldName(int field, GUI gui) {
		return ((GUI_Street) gui.getFields()[field]).getOwnerName();

	}

	public void getCyan(GUI gui, Player player) {
		if (ownerOfFieldName(1, gui).equals(ownerOfFieldName(3, gui))
				&& player.getName().equals(ownerOfFieldName(3, gui)) && counterCyan < 4) {
			counterCyan++;
			((GUI_Street) gui.getFields()[1]).setHouses(counterCyan);

		}
	}

	public void getPink(GUI gui, Player player) {
		if (ownerOfFieldName(6, gui).equals(ownerOfFieldName(8, gui))
				&& ownerOfFieldName(6, gui).equals(ownerOfFieldName(9, gui))
				&& player.getName().equals(ownerOfFieldName(6, gui)) && counterPink < 4) {
			counterPink++;
			((GUI_Street) gui.getFields()[6]).setHouses(counterPink);
		}
	}

	public void getGreen(GUI gui, Player player) {
		if (ownerOfFieldName(11, gui).equals(ownerOfFieldName(13, gui))
				&& ownerOfFieldName(11, gui).equals(ownerOfFieldName(14, gui))
				&& player.getName().equals(ownerOfFieldName(11, gui))&& counterGreen < 4) {
			counterGreen++;
			((GUI_Street) gui.getFields()[11]).setHouses(counterGreen);
		}
	}

	public void getGrey(GUI gui, Player player) {
		if (ownerOfFieldName(16, gui).equals(ownerOfFieldName(18, gui))
				&& ownerOfFieldName(16, gui).equals(ownerOfFieldName(19, gui))
				&& player.getName().equals(ownerOfFieldName(16, gui))&& counterGrey < 4) {
			counterGrey++;
			((GUI_Street) gui.getFields()[16]).setHouses(counterGrey);
		}
	}

	public void getRed(GUI gui, Player player) {
		if (ownerOfFieldName(21, gui).equals(ownerOfFieldName(23, gui))
				&& ownerOfFieldName(21, gui).equals(ownerOfFieldName(24, gui))
				&& player.getName().equals(ownerOfFieldName(21, gui))&& counterRed < 4) {
			counterRed++;
			((GUI_Street) gui.getFields()[21]).setHouses(counterRed);
		}
	}

	public void getWhite(GUI gui, Player player) {
		if (ownerOfFieldName(26, gui).equals(ownerOfFieldName(27, gui))
				&& ownerOfFieldName(26, gui).equals(ownerOfFieldName(29, gui))
				&& player.getName().equals(ownerOfFieldName(26, gui))&& counterWhite < 4) {
			counterWhite++;
			((GUI_Street) gui.getFields()[26]).setHouses(counterWhite);
		}
	}

	public void getYellow(GUI gui, Player player) {
		if (ownerOfFieldName(31, gui).equals(ownerOfFieldName(32, gui))
				&& ownerOfFieldName(31, gui).equals(ownerOfFieldName(34, gui))
				&& player.getName().equals(ownerOfFieldName(31, gui))&& counterYellow < 4) {
			counterYellow++;
			((GUI_Street) gui.getFields()[31]).setHouses(counterYellow);
		}
	}

	public void getMagenta(GUI gui, Player player) {
		if (ownerOfFieldName(37, gui).equals(ownerOfFieldName(39, gui))
				&& player.getName().equals(ownerOfFieldName(37, gui))&& counterMagenta < 4) {
			counterMagenta++;
			((GUI_Street) gui.getFields()[37]).setHouses(counterMagenta);
		}
	}

	public void buildHouse(GUI gui, int field) {
		((GUI_Street) gui.getFields()[field]).setHouses(1);

	}

	public void choiceOfArea(String choice, GUI gui, Player player) {
		switch (choice) {
		case "Cyan":
			getCyan(gui, player);
			break;
		case "Pink":
			getPink(gui, player);
			break;
		case "Grøn":
			getGreen(gui, player);
			break;
		case "Grå":
			getGrey(gui, player);
			break;
		case "Rød":
			getRed(gui, player);
			break;
		case "Hvid":
			getWhite(gui, player);
			break;
		case "Gul":
			getYellow(gui, player);
			break;
		case "Lilla":
			getMagenta(gui, player);
			break;
		}
	}

}