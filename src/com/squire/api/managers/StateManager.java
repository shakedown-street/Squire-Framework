package com.squire.api.managers;

import java.awt.Graphics;

import com.squire.api.models.State;

public class StateManager extends ObjectManager<State> {

	private State state;

	public StateManager() {

	}

	public boolean invalidState() {
		return state == null || state.hasEnded();
	}

	public void processState() {
		if (invalidState()) {
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
		if (invalidState()) {
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