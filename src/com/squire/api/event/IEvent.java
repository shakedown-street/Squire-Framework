package com.squire.api.event;

public interface IEvent {

	int getInterval();

	boolean isRunning();

	void execute();

}
