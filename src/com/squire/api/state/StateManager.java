package com.squire.api.state;

import java.awt.Graphics;

public class StateManager {

	private State currentState;
	
	public StateManager() {
	
	}

	public void processState() {
		if (currentState == null) {
			return;
		}
		
		try {
			currentState.process();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void renderState(Graphics g) {
		if (currentState == null) {
			return;
		}
		
		try {
			currentState.render(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}