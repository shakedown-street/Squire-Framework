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

	public final static int MAX_FPS = 30;

	public SquireGame(String title, int canvasWidth, int canvasHeight) {
		this.title = title;
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		initGame();
	}

	private void initGame() {
		engine = new SquireEngine(this);
		canvas = new SquireCanvas(this);
		frame = new SquireFrame(this);

		start();
		init();
	}
	
	public abstract void init();

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
				engine.process();
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
