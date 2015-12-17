package com.squire.test.states;

import java.awt.Graphics;

import com.squire.api.SquireGame;
import com.squire.api.input.KeyInput;
import com.squire.api.state.AbstractState;
import com.squire.test.layouts.StartLayout;

public class StartState extends AbstractState {
	public StartState(SquireGame game, String name) {
		super(game, name);
	}

	@Override
	public void init() {
		getGame().getEngine().getUIManager().setUILayout(new StartLayout());
	}

	@Override
	public void process() {
		KeyInput keys = getGame().getCanvas().getKeyInput();

		if (keys.isKeyPressed(17)) {
			getGame().getEngine().getStateManager().setState(
					new PlayState(getGame(), "play_state"));
		}
	}

	@Override
	public void render(Graphics g) {
		
	}

}
