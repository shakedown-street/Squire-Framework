package com.squire.api;

/**
 * Entry point for the framework. Creating a new instance of the world class
 * will start a frame with the drawing/updating canvas inside of it.
 *
 * @author Jordan Price
 *
 */

public abstract class SquireGame implements Runnable {

	private Thread thread;
	private String title;

	private SquireEngine engine;
	private SquireCanvas canvas;
	private SquireFrame frame;

	private int canvasWidth, canvasHeight;

	private final static int MAX_FPS = 30;
	private final static int MAX_FRAME_SKIPS = 5;
	private final static int FRAME_PERIOD = 1000 / MAX_FPS;

	public SquireGame(String title, int canvasWidth, int canvasHeight) {
		this.title = title;
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		init();
	}

	private void init() {
		this.engine = new SquireEngine(this);
		this.canvas = new SquireCanvas(this);
		this.frame = new SquireFrame(this);

		start();
	}

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

				engine.process();

				canvas.render();

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
					engine.process();
					sleepTime += FRAME_PERIOD;
					framesSkipped++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		thread = new Thread(this);
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
	}

	public String getTitle() {
		return title;
	}

	public SquireEngine getEngine() {
		return engine;
	}

	public SquireCanvas getCanvas() {
		return canvas;
	}

	public SquireFrame getFrame() {
		return frame;
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

}
