package com.squire.api.models;

/**
 * @author Jordan/shakedown-street
 */
public class Frame {

	private Sprite sprite;
	private int interval;

	public Frame(Sprite sprite, int interval) {
		this.sprite = sprite;
		this.interval = interval;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getInterval() {
		return interval;
	}

}
