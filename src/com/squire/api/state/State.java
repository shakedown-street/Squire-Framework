package com.squire.api.state;

import java.awt.Graphics;

import com.squire.api.ui.UIHandler;

public interface State {

	void init();

	void process();

	void render(Graphics g);
	
	UIHandler getUIHandler();

}
