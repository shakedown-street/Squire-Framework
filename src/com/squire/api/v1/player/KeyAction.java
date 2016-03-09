package com.squire.api.v1.player;

import com.squire.api.v1.models.State;

public abstract class KeyAction {
	
	public enum Type {
		PRESSED, RELEASED, TYPED
	}
	
	private int key;
	private Type type;
	private State state;
	
	public KeyAction(int _key, Type _type, State _state) {
		key = _key;
		type = _type;
		state = _state;
	}
	
	public abstract void act();
	
	public int getKey() {
		return key;
	}
	
	public Type getType() {
		return type;
	}
	
	public State getState() {
		return state;
	}
}
