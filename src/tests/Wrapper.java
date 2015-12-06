package tests;

import com.squire.api.SquireFrame;

public class Wrapper {

	public static SimpleSkeleton game = new SimpleSkeleton("Simple game", 800, 600);
	public static SquireFrame frame = new SquireFrame(game);
	
	public static void main(String[] args) {
		frame.initialize();
	}
}
