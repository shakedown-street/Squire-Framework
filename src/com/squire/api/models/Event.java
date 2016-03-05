package com.squire.api.models;

/**
 * @author Jordan/shakedown-street
 */
public abstract class Event implements Runnable {

	private int interval;
	private int cycles;
	private boolean running;
	private Thread thread;

	public Event(int _interval, int _cycles) {
		interval = _interval;
		cycles = _cycles;
		running = true;
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		int iterations = 0;
		running = true;
		while(running) {
			try {
				iterations++;
				if (iterations >= cycles) {
					running = false;
				}
				execute();
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public abstract void execute();

	public int getInterval() {
		return interval;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean _running) {
		running = _running;
	}
}
