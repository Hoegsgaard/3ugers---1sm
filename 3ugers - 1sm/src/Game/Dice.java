package Game;

public class Dice {
	int currentFaceValue;
	int sides;

	
//
	public Dice(int sides) {
		this.sides = sides;
	}

	
	public int getFaceValue() {
		return currentFaceValue;
	}
	
	public int getSides() {
		
		return sides;
	}

}
