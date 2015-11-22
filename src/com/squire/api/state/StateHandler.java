package com.squire.api.state;

import java.awt.Graphics;

public class StateHandler {

	private State currentState;

	public void setState(State state) {
		this.currentState = state;
	}

	public void process() {
		if (this.currentState != null) {
			this.currentState.process();
		}
	}

	public void render(Graphics g) {
		if (this.currentState != null) {
			this.currentState.render(g);
		}
	}

}