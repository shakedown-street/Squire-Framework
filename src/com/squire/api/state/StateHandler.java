package com.squire.api.state;

import java.awt.Graphics;

public class StateHandler {

	private static State currentState;
	private static BlankState blankState = new BlankState();

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

	public static State getState() {
		if (currentState != null) {
			return currentState;
		}
		return blankState;
	}

	public static void setState(State newState) {
		currentState = newState;
	}

}
