package com.squire.api.managers;

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