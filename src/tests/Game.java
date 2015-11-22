package tests;

import com.squire.api.World;

public class Game {
	

	public static void main(String[] args) {
		World world = new World(800, 500);
		world.getStateHandler().setState(new StartScreenState());
	}

}
