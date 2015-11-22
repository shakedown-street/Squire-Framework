package com.squire.api.state;

public abstract class AbstractState implements State {
	
	protected StateHandler stateHandler;

	public AbstractState(StateHandler handler) {
		stateHandler = handler;
		init();
	}

}
