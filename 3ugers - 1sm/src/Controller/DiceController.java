package Controller;

import Game.Dice;

	
public class DiceController {
	int currentFaceValue;
	Dice dice1 = new Dice(6); //makes a dice object  with number of given sides
	
	
	public int roll() {
		currentFaceValue = (int) (Math.random() * dice1.getSides() + 1);	//finds the random facevalue
		return currentFaceValue;
	}
	public int getFaceValue() {
		return currentFaceValue;
	}
}
