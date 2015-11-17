package com.squire.api.graphics;

import java.awt.Graphics;

/**
 * an object that can be drawn onto the world.
 *
 * @author Jordan Price
 *
 */
public abstract class Drawable {

	protected int x, y, w, h;
	protected Sprite sprite;

	public Drawable(Sprite sprite, int x, int y, int w, int h) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	/**
	 * Overridden by child classes to specify how to draw the object.
	 */
	public abstract void draw(Graphics g);

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

}
