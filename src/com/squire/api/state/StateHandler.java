package com.squire.api.state;

import java.awt.Graphics;

public class StateHandler {

	private static State currentState;

	public static void updateCurrentState() {
		if (currentState != null) {
			currentState.process();
		}
	}

	public static void renderCurrentState(Graphics g) {
		if (currentState != null) {
			currentState.render(g);
		}
	}

	public static void setCurrentState(State newState) {
		currentState = newState;
	}

}