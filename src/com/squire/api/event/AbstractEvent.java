package com.squire.api.event;

/**
 * @author Jordan Price
 */

public abstract class AbstractEvent implements Event {

	private int interval;

	private int cycles;
	
	private boolean running;

	public AbstractEvent(int interval) {
		this.interval = interval;
		this.cycles = interval;
		this.running = true;
	}

	public boolean shouldExecute() {
		cycles--;
		if (running && cycles == 0) {
			cycles = interval;
		}
		return running;
	}
	
	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
