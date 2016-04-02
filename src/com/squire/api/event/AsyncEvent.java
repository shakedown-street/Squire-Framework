package com.squire.api.event;

public abstract class AsyncEvent implements IEvent {
	
	private int interval;

	private int cycles;
	
	private boolean running;
	
	public AsyncEvent(int _interval) {
		interval = _interval;
		cycles = _interval;
		running = true;
	}
	
	public boolean shouldExecute() {
		cycles--;
		if (running && cycles == 0) {
			cycles = interval;
			execute();
		}
		return running;
	}
	
	public int getInterval() {
		return interval;
	}
	
	public boolean isRunning() {
		return running;
	}

}
