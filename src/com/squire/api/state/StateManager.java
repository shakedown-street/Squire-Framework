package com.squire.api.state;

import java.awt.Graphics;

public class StateManager {

	private State currentState;
	
	public StateManager() {
		currentState = null;
	}

	public void processState() {
		if (currentState == null) {
			return;
		}
		currentState.process();
	}

	public void renderState(Graphics g) {
		if (currentState == null) {
			return;
		}
		currentState.render(g);
	}

	public State getState() {
		return currentState;
	}

	public void setState(State state) {
		this.currentState = state;
		this.currentState.init();
	}

}