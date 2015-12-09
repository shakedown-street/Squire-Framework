package com.squire.api.state;

import java.awt.Graphics;

import com.squire.api.ui.UIManager;

public interface State {

	void init();

	void process();

	void render(Graphics g);
	
	UIManager getUIManager();

}
