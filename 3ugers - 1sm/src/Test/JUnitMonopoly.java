package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import View.Display;
import Controller.Main;
import Controller.Controller;
import Controller.MoveController;
import Controller.DiceController;
import Game.BuyProperty;
import Game.Dice;
import Game.Game;
import Game.ChanceCard;
import Game.GameBoard;
import Game.Jail;
import Game.Player;
import gui_fields.GUI_Player;
import gui_main.GUI;

class JUnitMonopoly {

	Player pTest;
	Player pTest2;
	GUI_Player spiller;
	GUI gui;
	Game Game;
	ChanceCard cc;
	MoveController move;

	@BeforeEach
	public void setup() {
		pTest = new Player();
		pTest2 = new Player();
		move = new MoveController();
		spiller = new GUI_Player("TestDummy");
		gui = new GUI();
		Game = new Game();
		cc = new ChanceCard(gui);

		gui.addPlayer(spiller);
		pTest.setCarObject(spiller);
		pTest2.setCarObject(spiller);
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
		assertTrue(pTest.getHasJailCard());
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
		assertTrue(pTest.getBalance() == 100);
	}

	@Test
	public void testChanceCardGetMoney() {
		cc.getMoney(pTest, gui, 100, "Din præmieobligation er kommet ud. De Modtager kr. 100 af banken.");
		assertTrue(pTest.getBalance() == 100);
	}

	@Test
	public void testMoveTo() {
		cc.moveTo(pTest, 15, gui, "Go somewhere");
		assertTrue(pTest.getCurrentField() == 15);
	}
	
	@Test
	public void testMovePlayer() {
		move.movePlayer(pTest, gui, 15);
		assertTrue(pTest.getCurrentField() == 15);
	}
	
//	@Test
//	public void testFindAWinner() {
//		
//		pTest.changeBalance(1000);
//		pTest2.changeBalance(0);
//		move.movePlayer(pTest2, gui, 38);
//		
//		assertTrue(pTest.);
//		
//	}
	
}
