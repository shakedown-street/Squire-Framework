package com.squire.api;

import com.squire.api.event.EventManager;
import com.squire.api.state.StateManager;
import com.squire.api.ui.InterfaceManager;

/**
 * Squire: An open source game framework.
 * 
 * Use however you'd like.
 *
 * @author Jordan Price
 *
 */

public abstract class SquireGame implements Runnable {

	private Thread thread;

	public final static int MAX_FPS = 9999;
	
	private EventManager eventManager;
	private StateManager stateManager;
	private InterfaceManager uiManager;
	
	private SquireCanvas canvas;
	private int width, height;
	private SquireFrame frame;

	public SquireGame(int width, int height) {
		this.width = width;
		this.height = height;
		load();
	}
	
	private void load() {
		eventManager = new EventManager();
		stateManager = new StateManager();
		uiManager = new InterfaceManager();
		canvas = new SquireCanvas(this);
		frame = new SquireFrame(this);
		start();
	}
	
	public abstract void init();
	
	private void process() {
		eventManager.process();
		stateManager.processState();
	}

	@Override
	public void run() {
		long lastFPSTime = System.currentTimeMillis();
		int fps = 0;
		long then = System.nanoTime();
		double unprocessed = 0d;
		double nsPerFrame = 1000000000.0d / MAX_FPS;
		while (true) {
			long now = System.nanoTime();
			unprocessed += (now - then) / nsPerFrame;
			then = now;
			boolean canRender = false;
			while (unprocessed >= 1) {
				process();
				canRender = true;
				unprocessed -= 1;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (canRender) {
				canvas.render();
				fps++;
			}
			if (System.currentTimeMillis() - lastFPSTime > 1000) {
				System.out.printf("%d FPS\n", fps);
				lastFPSTime = System.currentTimeMillis();
				fps = 0;
			}
		}
	}

	public void start() {
		thread = new Thread(this);
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
		init();
	}
	
	public EventManager getEventManager() {
		return eventManager;
	}
	
	public StateManager getStateManager() {
		return stateManager;
	}
	
	public InterfaceManager getUIManager() {
		return uiManager;
	}
	
	public SquireCanvas getCanvas() {
		return canvas;
	}
	
	public SquireFrame getFrame() {
		return frame;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

}
