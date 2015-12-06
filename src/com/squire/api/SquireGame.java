package com.squire.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * Entry point for the framework. Creating a new instance of the world class
 * will start a frame with the drawing/updating canvas inside of it.
 *
 * @author Jordan Price
 *
 */
@SuppressWarnings("serial")
public abstract class SquireGame extends Canvas implements Runnable {

	private Thread thread;
	private final String title;
	private int canvasWidth, canvasHeight;
	private final int buffers = 2;

	private SquireEngine engine;

	private final static int MAX_FPS = 30;
	private final static int MAX_FRAME_SKIPS = 5;
	private final static int FRAME_PERIOD = 1000 / MAX_FPS;

	public SquireGame(String title, int canvasWidth, int canvasHeight) {
		this.title = title;
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;

		setMinimumSize(new Dimension(canvasWidth, canvasHeight));
		setSize(new Dimension(canvasWidth, canvasHeight));

//		Key key = new Key();
//		Mouse mouse = new Mouse();
//
//		setFocusable(true);
//		addKeyListener(key);
//		addMouseListener(mouse);
//		addMouseMotionListener(mouse);
	}

	public abstract void init();

	@Override
	public void run() {
		init();

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

	private void process() {
		getEngine().getStateHandler().processState();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(buffers);
			requestFocus();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		getEngine().getStateHandler().renderState(g);

		g.dispose();
		bs.show();
	}

	public void start() {
		thread = new Thread(this);
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	public String getTitle() {
		return title;
	}

	public SquireEngine getEngine() {
		if (engine == null) {
			engine = new SquireEngine();
		}
		return engine;
	}

}
