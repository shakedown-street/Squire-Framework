package com.squire.api;

import com.squire.api.state.StateHandler;

public class SquireEngine {
	
	private StateHandler stateHandler;

	public StateHandler getStateHandler() {
		if (stateHandler == null) {
			stateHandler = new StateHandler();
		}
		return stateHandler;
	}

}
