package Controller;

import Game.Dice;

	
public class DiceController {
	int currentFaceValue;
	Dice dice1 = new Dice(6);
	Dice dice2 = new Dice(6);
	
	public int roll() {
		currentFaceValue = (int) (Math.random() * dice1.getSides() + 1);
		return currentFaceValue;
	}

	//
}
