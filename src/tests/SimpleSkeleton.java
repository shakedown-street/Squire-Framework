package tests;

import com.squire.api.SquireGame;

@SuppressWarnings("serial")
public class SimpleSkeleton extends SquireGame {

	public SimpleSkeleton(String name, int width, int height) {
		super(name, width, height);
	}

	@Override
	public void init() {
		String[] choices = { "Play", "Options", "Exit" };
		getEngine().getStateHandler().setState(new StartState("start_state",
				choices, getEngine().getStateHandler()));
	}
}