package com.squire.api.models;

import com.squire.api.services.AnimationService;

import jprice.rest.APIConnection;
import jprice.rest.DataModel;
import jprice.rest.Response;

public class Player extends DataModel {
	
	private Animation anim;

	public Player(Response _res) {
		super(_res);
		APIConnection connection = new APIConnection("http://127.0.0.1:8000", "?format=json", 5000);
		AnimationService anims = new AnimationService(connection);

		Response res = anims.retrieve((int) ((long) get("anim")));
		anim = new Animation(res);
	}

	public String getName() {
		return (String) get("name");
	}

	public long getPosX() {
		return (long) get("pos_x");
	}

	public long getPosY() {
		return (long) get("pos_y");
	}
	
	public void incrementX() {
		replace("pos_x", getPosX() + 5);
	}
	
	public void incrementY() {
		replace("pos_y", getPosY() + 5);
	}

	public Animation getAnimation() {
		return anim;
	}

}
