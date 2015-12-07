package com.squire.api.ui;

import java.awt.Graphics;

import com.squire.api.graphics.Sprite;

public abstract class UICheckbox extends UIComponent
		implements Clickable, Hoverable, Toggleable {

	private boolean checked = false;

	public UICheckbox(Sprite sprite, int x, int y, int w, int h) {
		super(sprite, x, y, w, h);
	}

	@Override
	public void onClick() {
		onToggle();
	}

	@Override
	public void onHover() {

	}

	@Override
	public void onToggle() {
		checked = !checked;
	}

	public abstract void renderChecked(Graphics g);

	public abstract void renderUnchecked(Graphics g);

	@Override
	public void renderComponent(Graphics g) {
		if (checked) {
			renderChecked(g);
		} else {
			renderUnchecked(g);
		}
	}

}
