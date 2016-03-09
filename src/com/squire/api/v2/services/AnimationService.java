package com.squire.api.v2.services;

import jprice.rest.APIConnection;
import jprice.rest.ModelService;

public class AnimationService extends ModelService {

	public AnimationService(APIConnection _api) {
		super(_api);
	}

	@Override
	public String getEndpoint() {
		return "/animations/";
	}

}
