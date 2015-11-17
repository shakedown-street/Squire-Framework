package com.squire.api.entity;

import com.squire.api.graphics.Drawable;
import com.squire.api.graphics.Sprite;

/**
 * a game object with distinct and independent existence.
 *
 * @author Jordan Price
 *
 */
public abstract class Entity extends Drawable {

	public Entity(Sprite sprite, int x, int y, int w, int h) {
		super(sprite, x, y, w, h);
	}

	public void translate(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public void moveTo(int x, int y) {
		this.x = x;
		this.y = x;
	}

}
