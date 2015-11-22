package com.squire.api;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.squire.api.listeners.Key;
import com.squire.api.listeners.Mouse;
import com.squire.api.state.StateHandler;

/**
 * Entry point for the framework. Creating a new instance of the world class
 * will start a frame with the drawing/updating canvas inside of it.
 *
 * @author Jordan Price
 */
public class World extends JComponent implements Runnable {

	private JFrame frame;
	private static final long serialVersionUID = 1L;
	
	private StateHandler stateHandler = new StateHandler();

	public World(int width, int height) {
		frame = new JFrame("Squire");
		this.setDoubleBuffered(true);

		Dimension size = new Dimension(width, height);

		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(this);
		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		frame.setVisible(true);

		Key key = new Key();
		Mouse mouse = new Mouse();

		frame.addKeyListener(key);
		frame.addMouseListener(mouse);
		frame.addMouseMotionListener(mouse);

		new Thread(this).start();
	}

	/**
	 * Updates game state.
	 */
	public void process() {
		if (stateHandler.getState() != null)
			stateHandler.getState().process();
	}

	/**
	 * Renders game state.
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		if (stateHandler.getState() != null)
			stateHandler.getState().render(g);
	}

	@Override
	public void run() {
		while (true) {
			process();
			repaint();
			sleep(30);
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

	public StateHandler getStateHandler() {
		return stateHandler;
	}

	public void setStateHandler(StateHandler stateHandler) {
		this.stateHandler = stateHandler;
	}

	/**
	 * Set the title of the frame
	 */
	public void setTitle(String title) {
		frame.setTitle(title);
	}

	public String getTitle() {
		return frame.getTitle();
	}

	/**
	 * Set the size of the frame/game
	 */
	public void setSize(int width, int height) {
		frame.setSize(width, height);
	}

	public Dimension getSize() {
		return frame.getSize();
	}

}
