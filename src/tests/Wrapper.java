package tests;

import com.squire.api.SquireFrameWrapper;

public class Wrapper {

	public static void main(String[] args) {
		SimpleSkeleton game = new SimpleSkeleton("Simple game", 800, 600);
		SquireFrameWrapper frame = new SquireFrameWrapper(game);
		frame.initialize();
	}
}
