package com.squire.test.components;

import java.awt.Graphics;

import com.squire.api.graphics.Sprite;
import com.squire.api.ui.UIButton;

public class PlayButton extends UIButton {

	public PlayButton(Sprite sprite, int x, int y, int w, int h) {
		super(sprite, x, y, w, h);
	}

	@Override
	public void renderComponent(Graphics g) {
		getSprite().draw(g, getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public void onClick() {
		
	}

	@Override
	public void onHover() {
		
	}

}
