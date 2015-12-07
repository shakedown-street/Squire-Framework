package com.squire.api.ui;

import java.awt.Graphics;

public class UIHandler {
	
	private UILayout layout;
	
	public void renderUI(Graphics g) {
		if (layout == null) {
			System.out.println("Invalid layout");
		}
		layout.renderLayout(g);
	}
	
	public UILayout getLayout() {
		return layout;
	}
	
	public void setLayout(UILayout layout) {
		this.layout = layout;
	}

}
