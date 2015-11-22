package com.squire.api.state;

import java.awt.Graphics;

public abstract class State {
	
	public State() {
		init();
	}
	
	public abstract void init();
	public abstract void process();
	public abstract void render(Graphics g);
}
