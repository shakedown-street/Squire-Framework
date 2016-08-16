package test;

import com.squire.api.SquireGame;

public class Game extends SquireGame {
	
	public Game() {
		
	}

	@Override
	public void init() {
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setDimensions(840, 600);
		game.start();
	}

}
