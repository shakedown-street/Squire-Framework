package com.squire.api.ui;

import java.awt.Graphics;

public class UIManager {
	
	private UILayout layout;
	
	public UIManager() {
		layout = null;
	}
	
	public UIManager(UILayout layout) {
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
