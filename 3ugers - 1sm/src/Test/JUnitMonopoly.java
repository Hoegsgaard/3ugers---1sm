package Test;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import Controller.DiceController;

class JUnitMonopoly {
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
}