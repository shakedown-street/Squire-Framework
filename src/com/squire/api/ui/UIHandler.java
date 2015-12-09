package com.squire.api.ui;

import java.awt.Graphics;

public class UIHandler {
	
	private UILayout layout;
	
	public UIHandler() {
		layout = null;
	}
	
	public UIHandler(UILayout layout) {
		super();
		this.layout = layout;
	}
	
	public void renderUI(Graphics g) {
		if (layout == null) {
			return;
		}
		layout.renderLayout(g);
	}
	
	public UILayout getLayout() {
		return layout;
	}
	
	public void setLayout(UILayout layout) {
		this.layout = layout;
		this.layout.initLayout();
	}

}
