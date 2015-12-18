package com.squire.api.ui;

import java.awt.Graphics;

public class InterfaceManager {

	private UILayout layout;

	public InterfaceManager() {
		layout = null;
	}

	public void renderUI(Graphics g) {
		if (layout == null) {
			return;
		}
		
		try {
			layout.renderLayout(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
