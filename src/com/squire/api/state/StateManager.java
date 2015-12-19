package com.squire.api.state;

import java.awt.Graphics;

public class StateManager {

	private AbstractState state;
	
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
			state.getUIManager().renderUI(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setState(AbstractState state) {
		this.state = state;
		this.state.init();
	}

}