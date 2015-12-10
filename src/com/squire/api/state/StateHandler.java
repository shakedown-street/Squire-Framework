package com.squire.api.state;

import java.awt.Graphics;

public class StateHandler {

	private AbstractState currentState;

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

	public AbstractState getState() {
		return currentState;
	}

	public void setState(AbstractState state) {
		this.currentState = state;
		this.currentState.init();
	}

}