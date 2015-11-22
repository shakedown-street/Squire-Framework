package com.squire.api.state;

public class StateHandler {
	
	private State currentState;
	
	public StateHandler() {
		
	}
	
	public State getState() {
		return currentState;
	}
	
	public void setState(State newState) {
		this.currentState = newState;
	}
	
}
