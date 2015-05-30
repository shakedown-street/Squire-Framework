package com.squire.api.event;

public interface Updatable {

	/**
	 * When implemented and added to the update block, will execute in the main
	 * game loop at a specified interval.
	 */
	void process();

}
