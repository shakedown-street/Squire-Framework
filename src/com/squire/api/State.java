package com.squire.api;

import java.awt.Graphics;

public interface State {

	void init();
	
	void update();
	
	void render(Graphics g);
	
	void end();
	
}
