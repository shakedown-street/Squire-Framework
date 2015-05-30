package com.squire.api;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.squire.api.event.Updatable;
import com.squire.api.graphics.Drawable;
import com.squire.api.listeners.Key;
import com.squire.api.listeners.Mouse;

/**
 * Entry point for the framework. Creating a new instance of the world class
 * will start a frame with the drawing/updating canvas inside of it.
 * 
 * Email to tycast@microsoft.com
 * 
 * Assignment: Final Project
 * 
 * Expected Time To Complete: Well over the time given :D
 * 
 * Actual Time to Complete: Used all the time I had to work on it, but it is far
 * from complete still.
 * 
 * Comments: Due to my work schedule I didn't have as much time for this as I
 * would have liked, so I did what I could, but there are several things from
 * the rubric that I did not have time to implement, and some things are not
 * done as well as I would have liked them to be.
 * 
 * @author Jordan Price
 * 
 */
public class World extends JComponent implements Runnable {

	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Game objects that are updated in main loop.
	 */
	private ArrayList<Updatable> updateBlock = new ArrayList<Updatable>();

	/**
	 * Game objects that are drawn in the main loop.
	 */
	private ArrayList<Drawable> renderBlock = new ArrayList<Drawable>();

	/**
	 * Creates a drawable/updatable canvas inside of the width and height
	 * restraints.
	 * 
	 * @param width
	 *            Width of the canvas
	 * @param height
	 *            Height of the canvas
	 */
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
		for (Updatable obj : updateBlock) {
			obj.process();
		}
	}

	/**
	 * Renders game state.
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		for (Drawable obj : renderBlock) {
			obj.draw(g);
		}
	}

	@Override
	public void run() {
		while (true) {
			process();
			repaint();
			sleep(30);
		}
	}

	private long diff, start = System.currentTimeMillis();

	/**
	 * I had to look up how to do this. This limits the game to 30 frames per
	 * second.
	 * 
	 * @param fps
	 *            The amount of frames per second the game runs at.
	 */
	public void sleep(int fps) {
		if (fps > 0) {
			diff = System.currentTimeMillis() - start;
			long targetDelay = 1000 / fps;
			if (diff < targetDelay) {
				try {
					Thread.sleep(targetDelay - diff);
				} catch (InterruptedException e) {
				}
			}
			start = System.currentTimeMillis();
		}
	}

	/**
	 * Add a new Drawable object to the render block.
	 * 
	 * @param obj
	 *            The object to add
	 */
	public void appendRender(Drawable... objs) {
		for (Drawable obj : objs)
			renderBlock.add(obj);
	}

	/**
	 * Remove a Drawable object from the render block.
	 * 
	 * @param obj
	 *            The object to remove
	 */
	public void removeRender(Drawable... objs) {
		for (Drawable obj : objs)
			renderBlock.remove(obj);
	}

	/**
	 * Add an Updatable object to the update block.
	 * 
	 * @param objs
	 *            The object to append
	 */
	public void appendUpdate(Updatable... objs) {
		for (Updatable obj : objs)
			updateBlock.add(obj);
	}

	/**
	 * Remove an Updatable from the update block.
	 * 
	 * @param objs
	 *            The object to remove
	 */
	public void removeUpdate(Updatable... objs) {
		for (Updatable obj : objs)
			updateBlock.remove(obj);
	}

	/**
	 * Set the title of the frame
	 * 
	 * @param title
	 *            The new title for the frame
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
