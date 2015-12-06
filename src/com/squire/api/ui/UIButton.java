package com.squire.api.ui;

import java.awt.Graphics;

import com.squire.api.graphics.Sprite;

public class UIButton extends UIComponent implements Clickable, Hoverable {

	public UIButton(Sprite sprite, int x, int y, int w, int h) {
		super(sprite, x, y, w, h);
	}

	@Override
	public void renderComponent(Graphics g) {
		getSprite().draw(g, getX(), getY(), getWidth(), getHeight());
	}

}