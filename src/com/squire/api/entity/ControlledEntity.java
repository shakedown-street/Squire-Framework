package com.squire.api.entity;

import com.squire.api.graphics.Sprite;

/**
 * This is the "Character Controller Interface" that I talked about in the
 * project proposal. It allows users to create their controlled Entities (the
 * players Entity) with key actions implemented (although with the time frame I
 * was not able to add a functional click/mouse input handler.
 * 
 * @author Jordan Price
 *
 */
public abstract class ControlledEntity extends Entity {

	public ControlledEntity(Sprite sprite, int x, int y, int w, int h) {
		super(sprite, x, y, w, h);
	}

	public abstract void clickActions();

	public abstract void mouseActions();

	public abstract void keyActions();

}
