package com.squire.api.entity;

import com.squire.api.event.Updatable;
import com.squire.api.graphics.Drawable;
import com.squire.api.graphics.Sprite;

/**
 * And Entity encompasses any object such as players, enemies, projectiles and
 * other things like that. Basically they are movable game objects.
 * 
 * @author Pork
 *
 */
public abstract class Entity extends Drawable implements Updatable {

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
