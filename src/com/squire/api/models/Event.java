package com.squire.api.models;

/**
 * @author Jordan Price
 */

public abstract class Event {

	private int interval;

	private int cycles;

	private boolean running;

	public Event(int interval) {
		this.interval = interval;
		this.cycles = interval;
		this.running = true;
	}

	public abstract void execute();

	public boolean shouldExecute() {
		cycles--;
		if (running && cycles == 0) {
			cycles = interval;
			this.execute();
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
