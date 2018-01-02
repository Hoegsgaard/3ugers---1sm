package Game;

public class ChanceCard {
	
	public ChanceCard() {}
	
	String[] chanceCard = {};
	
	public void shuffle(String[] chanceCard) {

		for (int i = 0; i < chanceCard.length; i++) { // goes length of array times

			int currentValue = 0;

			boolean run = true;

			// runs until different index than current index
			while (run) {
				currentValue = (int) (Math.random() * chanceCard.length); // returns 0- max index value of array
				if (currentValue != i) {
					run = false;
				}
			}
			// change position between values in array
			String a = chanceCard[i]; // pre-defined
			String b = chanceCard[currentValue]; // random

			chanceCard[i] = b;
			chanceCard[currentValue] = a;
		}
	}
		
		// Trækker et kort, kalder metoden og lægger det nederst i bunken
		public void drawCard(Player player, Player[] players) {
			String card = chanceCard[0];
			for (int i = 1; i < chanceCard.length; i++) {
				chanceCard[i - 1] = chanceCard[i];
			}
			chanceCard[chanceCard.length - 1] = card;
			
			// Switch case
			switch (card) {}
	}
}
