package com.squire.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.squire.api.listeners.Key;
import com.squire.api.listeners.Mouse;

/**
 * Entry point for the framework. Creating a new instance of the world class
 * will start a frame with the drawing/updating canvas inside of it.
 *
 * @author Jordan Price
 * 
 */
@SuppressWarnings("serial")
public abstract class SquireGame extends Canvas implements Runnable {

	private final static int MAX_FPS = 30;
	private final static int MAX_FRAME_SKIPS = 5;
	private final static int FRAME_PERIOD = 1000 / MAX_FPS;

	private final String name;
	private int width, height;

	private SquireEngine engine;

	public SquireGame(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		
		setMinimumSize(new Dimension(width, height));
		setSize(new Dimension(width, height));

		Key key = new Key();
		Mouse mouse = new Mouse();

		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public abstract void init();

	@Override
	public void run() {

		long beginTime;
		long timeDiff;
		int sleepTime;
		int framesSkipped;

		sleepTime = 0;

		while (true) {
			try {
				beginTime = System.currentTimeMillis();
				framesSkipped = 0;

				// update game state
				process();

				// render state to the screen
				render();

				timeDiff = System.currentTimeMillis() - beginTime;
				sleepTime = (int) (FRAME_PERIOD - timeDiff);

				if (sleepTime > 0) {
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
					process();
					sleepTime += FRAME_PERIOD;
					framesSkipped++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void start() {
		Thread thread = new Thread(this);
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
		init();
	}

	private void process() {
		getEngine().getStateHandler().process();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(2);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);

		getEngine().getStateHandler().render(g);

		g.dispose();
		bs.show();
	}

	public String getName() {
		return name;
	}

	public SquireEngine getEngine() {
		if (engine == null) {
			engine = new SquireEngine();
		}
		return engine;
	}

}
