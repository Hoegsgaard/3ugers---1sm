package Controller;


import Game.Game;
import View.View;
import gui_main.GUI;

public class Controller {
	private View view = new View();
	private Game model = new Game();
	
	public Controller(View view, Game model, GUI gui) {
		this.view = view;
		this.model = model;
		this.view.roll(gui);
		
		
	}
	public void action(GUI gui) {
		model.changeName(view.roll(gui));
		System.out.println("cunt");
	}
}
