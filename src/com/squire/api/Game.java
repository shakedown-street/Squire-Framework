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
@SuppressWarnings("serial")
public class Game extends JPanel implements Runnable {
	
	private StateHandler stateHandler;

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
		stateHandler.process();
	}

	/**
	 * Renders game state.
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		stateHandler.render(g);
	}

	private final static int MAX_FPS = 30;
	private final static int MAX_FRAME_SKIPS = 5;
	private final static int FRAME_PERIOD = 1000 / MAX_FPS;

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
				this.process();
				// render state to the screen
				this.repaint();

				timeDiff = System.currentTimeMillis() - beginTime;
				sleepTime = (int) (FRAME_PERIOD - timeDiff);

				if (sleepTime > 0) {
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
					}
				}

				while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
					this.process();
					sleepTime += FRAME_PERIOD;
					framesSkipped++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public StateHandler getStateHandler() {
		if (stateHandler == null) {
			stateHandler = new StateHandler();
		}
		return stateHandler;
	}

}
