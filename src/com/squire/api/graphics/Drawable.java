package com.squire.api.graphics;

import java.awt.Graphics;

import com.squire.api.Point;
import com.squire.api.Size;

public abstract class Drawable {

	protected Point pos;
	protected Size size;
	protected Sprite sprite;
	
	public Drawable(Sprite sprite, Point pos, Size size) {
		this.sprite = sprite;
		this.setPos(pos);
		this.setSize(size);
	}
	
	public Drawable(Sprite sprite, int x, int y, int w, int h) {
		this(sprite, new Point(x, y), new Size(w, h));
	}

	public void draw(Graphics g) {
		sprite.draw(g, pos.x, pos.y, size.w, size.h);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
}
