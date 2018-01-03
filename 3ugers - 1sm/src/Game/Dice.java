package Game;

public class Dice {
	int currentFaceValue;
	int sides;

	public Dice() {
		sides = 6;
	}

	public Dice(int sides) {
		this.sides = sides;
	}

	public int roll() {
		currentFaceValue = (int) (Math.random() * sides + 1);
		return currentFaceValue;
	}

	public int getFaceValue() {
		return currentFaceValue;
	}

}
