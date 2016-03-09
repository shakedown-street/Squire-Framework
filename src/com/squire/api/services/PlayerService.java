package com.squire.api.services;

import jprice.rest.APIConnection;
import jprice.rest.ModelService;

public class PlayerService extends ModelService {

	public PlayerService(APIConnection _api) {
		super(_api);
	}

	@Override
	public String getEndpoint() {
		return "/players/";
	}

}
