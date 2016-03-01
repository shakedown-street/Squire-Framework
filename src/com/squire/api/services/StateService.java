package com.squire.api.services;

import java.awt.Graphics;

import com.squire.api.SquireService;
import com.squire.api.models.State;

/**
 * @author Jordan/shakedown-street
 */
public class StateService extends SquireService<State> {

	private State state;

	public boolean isValidState() {
		return state != null && !state.hasEnded();
	}

	public void process() {
		if (isValidState()) {
			try {
				state.process();
				state.getAnimationService().process();
				state.getEventService().process();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void render(Graphics g) {
		if (isValidState()) {
			try {
				state.render(g);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public State getState() {
		return state;
	}
	
	public State retrieve(String name) {
		for (State s : objectSet()) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}

	public void setState(State _state) {
		if (_state == null) {
			return;
		}
		state = _state;
		state.init();
		state.getGame().refreshInputMethods();
	}
	
	public void setState(String name) {
		for (State s : objectSet()) {
			if (s.getName().equals(name)) {
				setState(s);
			}
		}
	}

}