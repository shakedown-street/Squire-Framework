package com.squire.api.v2.services;

import jprice.rest.APIConnection;
import jprice.rest.ModelService;

public class FrameService extends ModelService {

	public FrameService(APIConnection _api) {
		super(_api);
	}

	@Override
	public String getEndpoint() {
		return "/frames/";
	}

}
