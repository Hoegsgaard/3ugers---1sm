package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Controller.DiceController;
import Controller.GameController;
import Controller.MoveController;
import Game.ChanceCard;
import Game.GameBoard;
import Game.Player;
import gui_fields.GUI_Player;
import gui_main.GUI;

class JUnitMonopoly {

	Player pTest;
	Player pTest2;
	GUI_Player TestSpiller;
	GUI_Player TestSpiller2;
	GUI gui;
	ChanceCard cc;
	MoveController move;
	GameController GameController;
	GameBoard board;
	
	@Before
	public void setup() {
		pTest = new Player();
		pTest2 = new Player();
		move = new MoveController();
		TestSpiller = new GUI_Player("TestDummy");
		TestSpiller2 = new GUI_Player("TestDummy2");
		gui = new GUI(board.getFields());
		cc = new ChanceCard(gui);
		GameController = new GameController();
		board = new GameBoard();
		gui.addPlayer(TestSpiller);
		gui.addPlayer(TestSpiller2);
		pTest.setCarObject(TestSpiller);
		pTest2.setCarObject(TestSpiller2);
	}

	// Dice test 2 stk

	boolean exceed = false;
	@Test
	// This test check that each face value is hit approximately the statistically
	// predicted amount of times.
	public void testSum() {
		DiceController dice = new DiceController();
		int amountOfRolls = 10000000;
		double maxDev = 0.05;
		// Array that contains amount of hits for each face value.
		int[] values = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		// rolls a die twice, sums the two face values, and increments the corresponding
		// element in values[].
		for (int i = 0; i < amountOfRolls; i++) {
			values[dice.roll() + dice.roll() - 2]++;
		}
		double level;
		// This for-loop controls that the elements in values[], do not exceed some
		// arbitrary margin of error.
		for (int i = 0; i < 5; i++) {
			level = (double) (i + 1) / 36.0;
			if ((double) values[i] < (amountOfRolls * level) * (1 - maxDev)
					|| values[i] > (amountOfRolls * level) * (1 + maxDev)
					|| (double) values[10 - i] < (amountOfRolls * level) * (1 - maxDev)
					|| values[10 - i] > (amountOfRolls * level) * (1 + maxDev)) {
				exceed = true;
			}
		}
		assertFalse(exceed);
	}

	@Test
	// this test check the frequency of two rolls with the same face value.

	public void testMatch() {
		boolean exceed = false;
		DiceController dice = new DiceController();
		DiceController dice2 = new DiceController();
		int amountOfRolls = 10000000;
		double maxDev = 0.05;

		// Array that contains amount of hits for each pair.

		int[] values = { 0, 0, 0, 0, 0, 0 };

		// Rolls two die, and checks whether they display the same face value,
		// incrementing the corresponding element in values[], if they do.

		for (int i = 0; i < amountOfRolls; i++) {
			if (dice.roll() == dice2.roll()) {
				values[dice.getFaceValue() - 1]++;
			}
		}
		double level;
		// This for-loop controls that the elements in values[], do not exceed some
		// arbitrary margin of error.

		for (int i = 0; i < 5; i++) {
			level = 1.0 / 36.0;
			if ((double) values[i] < (amountOfRolls * level) * (1 - maxDev)
					|| values[i] > (amountOfRolls * level) * (1 + maxDev)) {
				exceed = true;
			}
		}
		assertFalse(exceed);
	}



	@Test
	public void testJailCard() {
		cc.getOutOfJail(pTest, null);
		assertTrue(pTest.getHasJailCard() == true);
	}

	@Test
	public void testChanceCardGoToMove() {
		cc.moveTo(pTest, 0, gui, "hi");
		boolean succeeded = false;
		pTest.setBalance(200);
		if (pTest.getCurrentField() == 0 && pTest.getBalance() == 200) {
			succeeded = true;
		}
		assertTrue(succeeded);
	}

	@Test
	public void testChanceCardPayMoney() {
		cc.payMoney(pTest, gui, 100, null);
		pTest.setBalance(1000);
		cc.payMoney(pTest, gui, 100, "Betal for vogn vask og smørning kr. 100.");
		assertEquals(pTest.getBalance(), 900);
	}

	@Test
	
	public void testChanceCardGetMoney() {
		cc.getMoney(pTest, gui, 100, "Din præmieobligation er kommet ud. De Modtager kr. 100 af banken.");
		assertTrue(pTest.getBalance() == 100);
	}

	@Test
	public void testMoveTo() {
		cc.moveTo(pTest, 15, gui, "Go somewhere");
		int field = pTest.getCurrentField();
		assertTrue(field == 15);
	}
	
	@Test
	public void testBuyField() {
		board.createBoard();
		move.setPlayerPos(pTest, 3, gui);
		GameController.buyField(pTest, gui);
		assertTrue(board.getOwnable(3) == false);	
	}
	//new
	@Test
	public void testBuildHouse() {
		board.createBoard();
		move.movePlayer(pTest, gui, 1);
		GameController.setOwner(pTest);
		move.movePlayer(pTest, gui, 3);
		GameController.setOwner(pTest);
		board.changeNumOffBuild(3, 1);
		board.changeNumOffBuild(1, 1);
		assertTrue(board.getNumOffBuild(1) == 1);
	}
	
	@Test
	public void testBankrupt() {
		pTest.setTotalValue(-1);
		GameController.bankrupt(pTest, gui);
		assertTrue(pTest.getBankrupt() == true);
	}
}