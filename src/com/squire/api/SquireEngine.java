package com.squire.api;

import com.squire.api.state.StateHandler;

public class SquireEngine {

	private StateHandler stateHandler;
	
	public SquireEngine(SquireGame game) {
		stateHandler = new StateHandler();
	}
	
	public void process() {
		stateHandler.processState();
	}

	public StateHandler getStateHandler() {
		return stateHandler;
	}

}
