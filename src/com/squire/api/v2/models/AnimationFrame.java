package com.squire.api.v2.models;

import com.squire.api.v2.services.SpriteService;

import jprice.rest.APIConnection;
import jprice.rest.DataModel;
import jprice.rest.Response;

@SuppressWarnings("serial")
public class AnimationFrame extends DataModel {

	private Sprite sprite;
	private long interval;

	public AnimationFrame(Response _res) {
		super(_res);
		APIConnection connection = new APIConnection("http://127.0.0.1:8000", "?format=json", 5000);
		SpriteService sprites = new SpriteService(connection);
		long spriteId = (long) get("sprite");
		sprite = new Sprite(sprites.retrieve((int) spriteId));
		interval = (long) get("interval");
	}

	public Sprite getSprite() {
		return sprite;
	}

	public long getInterval() {
		return interval;
	}

}
