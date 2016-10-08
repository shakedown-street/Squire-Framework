package com.squire.api;

import java.awt.Graphics;

public class StateManager {
	
	private State state;
	private static final String invalidStateMessage = "Invalid state.";
	
	public StateManager() {
		
	}
	
	public boolean stateIsValid() {
		return state != null;
	}
	
	public void update() {
		if (stateIsValid()) {
			try {
				state.update();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(invalidStateMessage);
		}
	}
	
	public void render(Graphics g) {
		if (stateIsValid()) {
			try {
				state.render(g);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(invalidStateMessage);
		}
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State _state) {
		state = _state;
		state.init();
	}

}
