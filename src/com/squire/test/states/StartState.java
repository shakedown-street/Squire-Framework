package com.squire.test.states;

import java.awt.Graphics;

import com.squire.api.SquireGame;
import com.squire.api.input.KeyInput;
import com.squire.api.state.AbstractState;
import com.squire.api.state.StateHandler;
import com.squire.api.ui.UILayout;
import com.squire.test.layouts.PlayLayout;

public class StartState extends AbstractState {

	public StartState(SquireGame game, String name) {
		super(game, name);
	}

	public StartState(SquireGame game, String name, UILayout layout) {
		super(game, name, layout);
	}

	@Override
	public void init() {

	}

	@Override
	public void process() {
		KeyInput keys = getGame().getCanvas().getKeyInput();
		StateHandler stateHandler = getGame().getEngine().getStateHandler();

		if (keys.isKeyPressed(17)) {
			getGame().getEngine().getStateHandler().setState(
					new PlayState(getGame(), "play_state", new PlayLayout()));
		}
	}

	@Override
	public void render(Graphics g) {
	}

}
