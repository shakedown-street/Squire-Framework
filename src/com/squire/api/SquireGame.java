package com.squire.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * @author Jordan/shakedown-street
 */
@SuppressWarnings("serial")
public abstract class SquireGame extends Canvas implements Runnable {

	private String title;
	private int width, height;
	private boolean running = false;
	
	private StateManager stateManager;
	
	private boolean developmentMode = true;
	
	private Thread thread;
	private final static int MAX_FPS = 60;
	private final static int BUFFERS = 2;

	public SquireGame(String _title, int _width, int _height) {
		title = _title;
		setDimensions(_width, _height);
		setFocusable(true);
		stateManager = new StateManager();
	}
	
	public void setDimensions(int _width, int _height) {
		width = _width;
		height = _height;

		setMinimumSize(new Dimension(_width, _height));
		setMaximumSize(new Dimension(_width, _height));
		setSize(new Dimension(_width, _height));
	}

	public abstract void initGame();
	
	private void update() {
		stateManager.getState().update();
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
		
		// Render
		stateManager.getState().render(g);

		g.dispose();
		bs.show();
	}

	public void start() {
		if (!running) {
			running = true;
			thread = new Thread(this);
			thread.setPriority(Thread.MAX_PRIORITY);
			thread.start();
		}
	}
	
	public void stop() {
		if (running) {
			running = false;
		}
	}

	@Override
	public void run() {
		initGame();
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
				update();
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
				lastFPSTime = System.currentTimeMillis();
				fps = 0;
			}
		}
	}
	
	public String getTitle() {
		return title;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public StateManager getStateManager() {
		return stateManager;
	}

}
