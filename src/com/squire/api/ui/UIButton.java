package com.squire.api.ui;

import com.squire.api.graphics.Sprite;

public abstract class UIButton extends UIComponent
		implements Clickable, Hoverable {

	public UIButton(Sprite sprite, int x, int y, int w, int h) {
		super(sprite, x, y, w, h);
	}

}
