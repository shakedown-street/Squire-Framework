package com.squire.api.player;

public abstract class KeyAction {
	
	public enum Type {
		PRESSED, RELEASED, TYPED
	}
	
	private int key;
	private Type type;
	
	public KeyAction(int _key, Type _type) {
		key = _key;
		type = _type;
	}
	
	public abstract void act();
	
	public int getKey() {
		return key;
	}
	
	public Type getType() {
		return type;
	}
}
