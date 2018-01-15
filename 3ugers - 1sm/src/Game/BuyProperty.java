package Game;

import gui_main.GUI;
import gui_fields.GUI_Street;

public class BuyProperty {
	boolean playerCanBuy = false;
	int counterCyan, counterPink, counterGreen, counterGrey, counterRed, counterWhite, counterYellow,
			counterMagenta = 0;
	int numberOffCyan, numberOffPink, numberOffGreen, numberOffGrey, numberOffRed, numberOffWhite, numberOffYellow,
			numberOffMagenta = 0;
	int hotelCyan, hotelPink, hotelGreen, hotelGrey, hotelRed, hotelWhite, hotelYellow, hotelMagenta = 0;

	public BuyProperty() {

	}
	
	public String ownerOfFieldName(int field, GUI gui) {
		return ((GUI_Street) gui.getFields()[field]).getOwnerName();

	}

	public void buildCyan(GUI gui, Player player, GameBoard board) {
		int price = board.pirceForHouse(0);
		if (ownerOfFieldName(1, gui).equals(ownerOfFieldName(3, gui))
				&& player.getName().equals(ownerOfFieldName(3, gui))) {
			if (numberOffCyan == 0 && counterCyan == 4) {// HOTEL
				if (hotelCyan == 0) {
					((GUI_Street) gui.getFields()[1]).setHotel(true);
					board.changeNumOffBuild(1, 1);
					hotelCyan = 1;
				} else {
					((GUI_Street) gui.getFields()[3]).setHotel(true);
					board.changeNumOffBuild(3, 1);
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			} else {
				if (numberOffCyan == 0 && counterCyan <= 3) {
					counterCyan++;
					((GUI_Street) gui.getFields()[1]).setHouses(counterCyan);
					board.changeNumOffBuild(1, 1);
					numberOffCyan = 1;
				} else if (numberOffCyan == 1 && counterCyan <= 4) {
					((GUI_Street) gui.getFields()[3]).setHouses(counterCyan);
					board.changeNumOffBuild(3, 1);
					numberOffCyan = 0;
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			}
		}
	}

	public void buildPink(GUI gui, Player player, GameBoard board) {
		int price = board.pirceForHouse(0);
		if (ownerOfFieldName(6, gui).equals(ownerOfFieldName(8, gui))
				&& ownerOfFieldName(6, gui).equals(ownerOfFieldName(9, gui))
				&& player.getName().equals(ownerOfFieldName(6, gui))) {
			if (numberOffPink == 0 && counterPink == 4) {// HOTEL
				if (hotelPink == 0) {
					((GUI_Street) gui.getFields()[6]).setHotel(true);
					board.changeNumOffBuild(6, 1);
					hotelPink = 1;
				} else if (hotelPink == 1) {
					((GUI_Street) gui.getFields()[8]).setHotel(true);
					board.changeNumOffBuild(8, 1);
					hotelPink = 2;
				} else {
					((GUI_Street) gui.getFields()[9]).setHotel(true);
					board.changeNumOffBuild(9, 1);
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			} else {
				if (numberOffPink == 0 && counterPink <= 3) {
					counterPink++;
					((GUI_Street) gui.getFields()[6]).setHouses(counterPink);
					board.changeNumOffBuild(6, 1);
					numberOffPink = 1;
				} else if (numberOffPink == 1 && counterPink <= 4) {
					((GUI_Street) gui.getFields()[8]).setHouses(counterPink);
					board.changeNumOffBuild(8, 1);
					numberOffPink = 2;
				} else if (numberOffPink == 2 && counterPink <= 4) {
					((GUI_Street) gui.getFields()[9]).setHouses(counterPink);
					board.changeNumOffBuild(9, 1);
					numberOffPink = 0;
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			}
		}
	}

	public void buildGreen(GUI gui, Player player, GameBoard board) {
		int price = board.pirceForHouse(1);
		if (ownerOfFieldName(11, gui).equals(ownerOfFieldName(13, gui))
				&& ownerOfFieldName(11, gui).equals(ownerOfFieldName(14, gui))
				&& player.getName().equals(ownerOfFieldName(11, gui))) {
			if (numberOffGreen == 0 && counterGreen == 4) {// HOTEL
				if (hotelGreen == 0) {
					((GUI_Street) gui.getFields()[11]).setHotel(true);
					board.changeNumOffBuild(11, 1);
					hotelGreen = 1;
				} else if (hotelGreen == 1) {
					((GUI_Street) gui.getFields()[13]).setHotel(true);
					board.changeNumOffBuild(13, 1);
					hotelGreen = 2;
				} else {
					((GUI_Street) gui.getFields()[14]).setHotel(true);
					board.changeNumOffBuild(14, 1);
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			} else {
				if (numberOffGreen == 0 && counterGreen <= 3) {
					counterGreen++;
					((GUI_Street) gui.getFields()[11]).setHouses(counterGreen);
					board.changeNumOffBuild(11, 1);
					numberOffGreen = 1;
				} else if (numberOffGreen == 1 && counterGreen <= 4) {
					((GUI_Street) gui.getFields()[13]).setHouses(counterGreen);
					board.changeNumOffBuild(13, 1);
					numberOffGreen = 2;
				} else if (numberOffGreen == 2 && counterGreen <= 4) {
					((GUI_Street) gui.getFields()[14]).setHouses(counterGreen);
					board.changeNumOffBuild(14, 1);
					numberOffGreen = 0;
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			}
		}
	}

	public void buildGrey(GUI gui, Player player, GameBoard board) {
		int price = board.pirceForHouse(1);
		if (ownerOfFieldName(16, gui).equals(ownerOfFieldName(18, gui))
				&& ownerOfFieldName(16, gui).equals(ownerOfFieldName(19, gui))
				&& player.getName().equals(ownerOfFieldName(16, gui))) {
			if (numberOffGrey == 0 && counterGrey == 4) {// HOTEL
				if (hotelGrey == 0) {
					((GUI_Street) gui.getFields()[16]).setHotel(true);
					board.changeNumOffBuild(16, 1);
					hotelGrey = 1;
				} else if (hotelGrey == 1) {
					((GUI_Street) gui.getFields()[18]).setHotel(true);
					board.changeNumOffBuild(18, 1);
					hotelGrey = 2;
				} else {
					((GUI_Street) gui.getFields()[19]).setHotel(true);
					board.changeNumOffBuild(19, 1);
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			} else {
				if (numberOffGrey == 0 && counterGrey <= 3) {
					counterGrey++;
					((GUI_Street) gui.getFields()[16]).setHouses(counterGrey);
					board.changeNumOffBuild(16, 1);
					numberOffGrey = 1;
				} else if (numberOffGrey == 1 && counterGrey <= 4) {
					((GUI_Street) gui.getFields()[18]).setHouses(counterGrey);
					board.changeNumOffBuild(18, 1);
					numberOffGrey = 2;
				} else if (numberOffGrey == 2 && counterGrey <= 4) {
					((GUI_Street) gui.getFields()[19]).setHouses(counterGrey);
					board.changeNumOffBuild(19, 1);
					numberOffGrey = 0;
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			}
		}
	}

	public void buildRed(GUI gui, Player player, GameBoard board) {
		int price = board.pirceForHouse(2);
		if (ownerOfFieldName(21, gui).equals(ownerOfFieldName(23, gui))
				&& ownerOfFieldName(21, gui).equals(ownerOfFieldName(24, gui))
				&& player.getName().equals(ownerOfFieldName(21, gui))) {
			if (numberOffRed == 0 && counterRed == 4) {// HOTEL
				if (hotelRed == 0) {
					((GUI_Street) gui.getFields()[21]).setHotel(true);
					board.changeNumOffBuild(21, 1);
					hotelRed = 1;
				} else if (hotelRed == 1) {
					((GUI_Street) gui.getFields()[23]).setHotel(true);
					board.changeNumOffBuild(23, 1);
					hotelRed = 2;
				} else {
					((GUI_Street) gui.getFields()[24]).setHotel(true);
					board.changeNumOffBuild(24, 1);
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			} else {
				if (numberOffRed == 0 && counterRed <= 3) {
					counterRed++;
					((GUI_Street) gui.getFields()[21]).setHouses(counterRed);
					board.changeNumOffBuild(21, 1);
					numberOffRed = 1;
				} else if (numberOffRed == 1 && counterRed <= 4) {
					((GUI_Street) gui.getFields()[23]).setHouses(counterRed);
					board.changeNumOffBuild(23, 1);
					numberOffRed = 2;
				} else if (numberOffRed == 2 && counterRed <= 4) {
					((GUI_Street) gui.getFields()[24]).setHouses(counterRed);
					board.changeNumOffBuild(24, 1);
					numberOffRed = 0;
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			}
		}
	}

	public void buildWhite(GUI gui, Player player, GameBoard board) {
		int price = board.pirceForHouse(2);
		if (ownerOfFieldName(26, gui).equals(ownerOfFieldName(27, gui))
				&& ownerOfFieldName(26, gui).equals(ownerOfFieldName(29, gui))
				&& player.getName().equals(ownerOfFieldName(26, gui))) {
			if (numberOffWhite == 0 && counterWhite == 4) {// HOTEL
				if (hotelWhite == 0) {
					((GUI_Street) gui.getFields()[26]).setHotel(true);
					board.changeNumOffBuild(26, 1);
					hotelWhite = 1;
				} else if (hotelWhite == 1) {
					((GUI_Street) gui.getFields()[27]).setHotel(true);
					board.changeNumOffBuild(27, 1);
					hotelWhite = 2;
				} else {
					((GUI_Street) gui.getFields()[29]).setHotel(true);
					board.changeNumOffBuild(29, 1);
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			} else {
				if (numberOffWhite == 0 && counterWhite <= 3) {
					counterWhite++;
					((GUI_Street) gui.getFields()[26]).setHouses(counterWhite);
					board.changeNumOffBuild(26, 1);
					numberOffWhite = 1;
				} else if (numberOffWhite == 1 && counterWhite <= 4) {
					((GUI_Street) gui.getFields()[27]).setHouses(counterWhite);
					board.changeNumOffBuild(27, 1);
					numberOffWhite = 2;
				} else if (numberOffWhite == 2 && counterWhite <= 4) {
					((GUI_Street) gui.getFields()[29]).setHouses(counterWhite);
					board.changeNumOffBuild(29, 1);
					numberOffWhite = 0;
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			}
		}
	}

	public void buildYellow(GUI gui, Player player, GameBoard board) {
		int price = board.pirceForHouse(3);
		if (ownerOfFieldName(31, gui).equals(ownerOfFieldName(32, gui))
				&& ownerOfFieldName(31, gui).equals(ownerOfFieldName(34, gui))
				&& player.getName().equals(ownerOfFieldName(31, gui))) {
			if (numberOffYellow == 0 && counterYellow == 4) {// HOTEL
				if (hotelYellow == 0) {
					((GUI_Street) gui.getFields()[31]).setHotel(true);
					board.changeNumOffBuild(31, 1);
					hotelYellow = 1;
				} else if (hotelYellow == 1) {
					((GUI_Street) gui.getFields()[32]).setHotel(true);
					board.changeNumOffBuild(32, 1);
					hotelYellow = 2;
				} else {
					((GUI_Street) gui.getFields()[34]).setHotel(true);
					board.changeNumOffBuild(34, 1);
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			} else {
				if (numberOffYellow == 0 && counterYellow <= 3) {
					counterYellow++;
					((GUI_Street) gui.getFields()[31]).setHouses(counterYellow);
					board.changeNumOffBuild(31, 1);
					numberOffYellow = 1;
				} else if (numberOffYellow == 1 && counterYellow <= 4) {
					((GUI_Street) gui.getFields()[32]).setHouses(counterYellow);
					board.changeNumOffBuild(32, 1);
					numberOffYellow = 2;
				} else if (numberOffYellow == 2 && counterYellow <= 4) {
					((GUI_Street) gui.getFields()[34]).setHouses(counterYellow);
					board.changeNumOffBuild(34, 1);
					numberOffYellow = 0;
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			}
		}
	}

	public void buildMagenta(GUI gui, Player player, GameBoard board) {
		int price = board.pirceForHouse(3);
		if (ownerOfFieldName(37, gui).equals(ownerOfFieldName(39, gui))
				&& player.getName().equals(ownerOfFieldName(37, gui))) {
			if (numberOffMagenta == 0 && counterMagenta == 4) {// HOTEL
				if (hotelMagenta == 0) {
					((GUI_Street) gui.getFields()[37]).setHotel(true);
					board.changeNumOffBuild(37, 1);
					hotelMagenta = 1;
				} else {
					((GUI_Street) gui.getFields()[39]).setHotel(true);
					board.changeNumOffBuild(39, 1);
				}
				player.changeBalance(-price);
				player.setHouseValue(price);
			}
			if (numberOffMagenta == 0 && counterMagenta <= 3) {
				counterMagenta++;
				((GUI_Street) gui.getFields()[37]).setHouses(counterMagenta);
				board.changeNumOffBuild(37, 1);
				numberOffMagenta = 1;
			} else if (numberOffMagenta == 1 && counterMagenta <= 4) {
				((GUI_Street) gui.getFields()[39]).setHouses(counterMagenta);
				board.changeNumOffBuild(39, 1);
				numberOffMagenta = 0;
			}
			player.changeBalance(-price);
			player.setHouseValue(price);
		}
	}

	public void choiceOfArea(String choice, GUI gui, Player player, GameBoard board) {
		switch (choice) {
		case "Cyan":
			buildCyan(gui, player, board);
			break;
		case "Pink":
			buildPink(gui, player, board);
			break;
		case "Grøn":
			buildGreen(gui, player, board);
			break;
		case "Grå":
			buildGrey(gui, player, board);
			break;
		case "Rød":
			buildRed(gui, player, board);
			break;
		case "Hvid":
			buildWhite(gui, player, board);
			break;
		case "Gul":
			buildYellow(gui, player, board);
			break;
		case "Lilla":
			buildMagenta(gui, player, board);
			break;
		}
	}
}