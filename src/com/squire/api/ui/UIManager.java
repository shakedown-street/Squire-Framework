package com.squire.api.ui;

import java.awt.Graphics;

public class UIManager {

	private UILayout layout;

	public UIManager() {
		layout = null;
	}

	public void renderUI(Graphics g) {
		if (layout == null) {
			System.out.println("null layout");
			return;
		}
		layout.renderLayout(g);
	}

	public UILayout getUILayout() {
		return layout;
	}

	public void setUILayout(UILayout layout) {
		this.layout = layout;
		this.layout.initLayout();
	}

}
