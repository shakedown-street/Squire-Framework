package com.squire.api.services;

import jprice.rest.APIConnection;
import jprice.rest.ModelService;

public class SpriteService extends ModelService {

	public SpriteService(APIConnection _api) {
		super(_api);
	}

	@Override
	public String getEndpoint() {
		return "/sprites/";
	}

}
