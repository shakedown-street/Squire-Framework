package com.squire.api.event;

import com.squire.api.SquireGame;

/**
 * Executes certain events at a specified time interval.
 * 
 * @author Jordan Price
 */

public abstract class AbstractEvent implements Event {
	
	private SquireGame game;

	/**
	 * The number of frames between execution.
	 */
	private int interval;

	/**
	 * How many frames are left until execution.
	 */
	private int cycles;
	
	/**
	 * Is the event currently running?
	 */
	private boolean running;

	public AbstractEvent(SquireGame game, int interval) {
		this.game = game;
		this.interval = interval;
		this.cycles = interval;
		this.running = false;
	}

	/**
	 * Executes the event and returns if it is still running
	 */
	public boolean shouldExecute() {
		cycles--;
		if (running && cycles == 0) {
			cycles = interval;
		}
		return running;
	}
	
	public SquireGame getGame() {
		return game;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getCycles() {
		return cycles;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
