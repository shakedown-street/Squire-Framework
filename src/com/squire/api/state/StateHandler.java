package com.squire.api.state;

import java.awt.Graphics;

public class StateHandler {

	private State currentState;

	public void processState() {
		if (this.currentState != null) {
			this.currentState.process();
		}
	}

	public void renderState(Graphics g) {
		if (this.currentState != null) {
			this.currentState.render(g);
			this.currentState.getUIManager().renderUI(g);
		}
	}
	
	public State getState() {
		return currentState;
	}

	public void setState(State state) {
		this.currentState = state;
		this.currentState.init();
	}

}