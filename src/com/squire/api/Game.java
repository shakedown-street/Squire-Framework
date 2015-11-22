package com.squire.api;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.squire.api.state.StateHandler;

/**
 * Entry point for the framework. Creating a new instance of the world class
 * will start a frame with the drawing/updating canvas inside of it.
 *
 * @author Jordan Price
 * 
 */
public class Game extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	public Game(int width, int height) {
		this.setDoubleBuffered(true);

		Dimension size = new Dimension(width, height);

		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);

		GameFrame.init(this);

		new Thread(this).start();
	}

	/**
	 * Updates game state.
	 */
	public void process() {
		StateHandler.getState().process();
	}

	/**
	 * Renders game state.
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		StateHandler.getState().render(g);
	}

	// desired fps
	private final static int MAX_FPS = 25;
	// maximum number of frames to be skipped
	private final static int MAX_FRAME_SKIPS = 5;
	// the frame period
	private final static int FRAME_PERIOD = 1000 / MAX_FPS;

	@Override
	public void run() {

		long beginTime; // the time when the cycle begun
		long timeDiff; // the time it took for the cycle to execute
		int sleepTime; // ms to sleep (<0 if we're behind)
		int framesSkipped; // number of frames being skipped

		sleepTime = 0;

		while (true) {
			// try locking the canvas for exclusive pixel editing
			// in the surface
			try {
				beginTime = System.currentTimeMillis();
				framesSkipped = 0; // resetting the frames skipped
				// update game state
				this.process();
				// render state to the screen
				// draws the canvas on the panel
				this.repaint();
				// calculate how long did the cycle take
				timeDiff = System.currentTimeMillis() - beginTime;
				// calculate sleep time
				sleepTime = (int) (FRAME_PERIOD - timeDiff);

				if (sleepTime > 0) {
					// if sleepTime > 0 we're OK
					try {
						// send the thread to sleep for a short period
						// very useful for battery saving
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
					}
				}

				while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
					// we need to catch up
					// update without rendering
					this.process();
					// add frame period to check if in next frame
					sleepTime += FRAME_PERIOD;
					framesSkipped++;
				}

			} finally {
				// in case of an exception the surface is not left in
				// an inconsistent state
				// if (canvas != null) {
				// surfaceHolder.unlockCanvasAndPost(canvas);
				// }
			}
		}
	}

	/**
	 * This limits the game to the specified frames per second.
	 */
	private long diff, start = System.currentTimeMillis();

	public void sleep(int fps) {
		if (fps > 0) {
			diff = System.currentTimeMillis() - start;
			long targetDelay = 1000 / fps;
			if (diff < targetDelay) {
				try {
					Thread.sleep(targetDelay - diff);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			start = System.currentTimeMillis();
		}
	}

}
