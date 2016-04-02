package com.squire.api.event;

/**
 * @author Jordan/shakedown-street
 */
public abstract class ThreadedEvent implements IEvent, Runnable {

	// Time between executions
	private int interval;

	// Number of times this event will execute
	private int cycles;

	private boolean running;
	private Thread thread;

	public ThreadedEvent(int _interval, int _cycles) {
		interval = _interval;
		cycles = _cycles;
		running = false;
	}

	/**
	 * Must be called for the event to do anything.
	 */
	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		running = false;
	}

	public void run() {
		int iterations = 0;
		while (running && iterations < cycles) {
			try {
				iterations++;
				execute();
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		running = false;
	}

	public int getInterval() {
		return interval;
	}

	public boolean isRunning() {
		return running;
	}
}
