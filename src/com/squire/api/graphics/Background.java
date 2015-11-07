package com.squire.api.graphics;

import java.awt.Graphics;

public class Background extends Drawable {

	public Background(Sprite sprite, int x, int y, int w, int h) {
		super(sprite, x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		sprite.draw(g, x, y);
	}

}
