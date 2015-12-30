package com.squire.api.models;

public class Frame {

	private Sprite sprite;
	private int time;

	public Frame(Sprite sprite, int time) {
		this.sprite = sprite;
		this.time = time;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getTime() {
		return time;
	}

}
