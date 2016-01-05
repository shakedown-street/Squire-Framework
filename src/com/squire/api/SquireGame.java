package com.squire.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.squire.api.managers.StateManager;
import com.squire.api.models.State;

/**
 * Squire: An open source game framework.
 * 
 * Use however you'd like.
 *
 * @author Jordan Price
 *
 */

@SuppressWarnings("serial")
public abstract class SquireGame extends Canvas implements Runnable {

	private StateManager stateManager;

	private int width, height;
	private SquireFrame frame;

	private Thread thread;

	public int lastFPS = 0;
	private final static int MAX_FPS = 60;
	private final static int BUFFERS = 2;

	public SquireGame(int width, int height) {
		this.width = width;
		this.height = height;
		setFocusable(true);

		setMinimumSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		setSize(new Dimension(width, height));
		load();
	}

	private void load() {
		stateManager = new StateManager();
		frame = new SquireFrame(this);
		start();
	}

	public abstract void init();
	public abstract State initialState();

	private void process() {
		stateManager.processState();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(BUFFERS);
			requestFocus();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);

		stateManager.renderState(g);

		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		init();
		stateManager.setState(initialState());
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
				render();
				fps++;
			}
			if (System.currentTimeMillis() - lastFPSTime > 1000) {
				lastFPS = fps;
				lastFPSTime = System.currentTimeMillis();
				fps = 0;
			}
		}
	}

	public void start() {
		thread = new Thread(this);
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
	}

	public StateManager getStateManager() {
		return stateManager;
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
