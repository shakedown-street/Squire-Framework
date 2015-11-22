package tests;

import com.squire.api.Game;
import com.squire.api.state.StateHandler;

public class BlockDodge {
	
	public static void main(String[] args) {
		Game blocks = new Game(800, 500);
		
		StateHandler.setCurrentState(new StartState());
	}

}
