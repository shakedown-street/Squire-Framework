package com.squire.api.managers;

import java.awt.Graphics;

import com.squire.api.SquireManager;
import com.squire.api.models.State;

/**
 * @author Jordan/shakedown-street
 */
public class StateManager extends SquireManager<State> {

	private State state;

	public boolean isValidState() {
		return state != null && !state.hasEnded();
	}

	public void processState() {
		if (!isValidState()) {
			return;
		}

		try {
			state.process();
			state.getEventManager().process();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void renderState(Graphics g) {
		if (!isValidState()) {
			return;
		}

		try {
			state.render(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		if (state == null) {
			return;
		}
		this.state = state;
		this.state.init();
	}

}