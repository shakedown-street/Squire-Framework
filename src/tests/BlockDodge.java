package tests;

import com.squire.api.Game;

public class BlockDodge {

	public static void main(String[] args) {
		Game blocks = new Game(800, 500);
		blocks.getStateHandler()
				.setState(new StartState(blocks.getStateHandler()));
	}

}
