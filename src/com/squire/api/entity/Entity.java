package com.squire.api.entity;

import com.squire.api.Point;
import com.squire.api.Size;
import com.squire.api.graphics.Drawable;
import com.squire.api.graphics.Sprite;

public class Entity extends Drawable {
	
	public Entity(Sprite sprite, Point pos, Size size) {
		super(sprite, pos, size);
	}
	
	public Entity(Sprite sprite, int x, int y, int w, int h) {
		this(sprite, new Point(x, y), new Size(w, h));
	}
	
}
