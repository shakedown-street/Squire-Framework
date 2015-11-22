package com.squire.api.state;

import java.awt.Graphics;

public interface State {
	
	void init();
	void process();
	void render(Graphics g);
	
}
