package Game;

public class Game {
	public Game() {
	}
	GameBoard board = new GameBoard();

	public void runGame() {
		board.createBoard();
	}
}
