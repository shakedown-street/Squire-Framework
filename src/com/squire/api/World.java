package com.squire.api;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.squire.api.graphics.Drawable;

/**
 * Entry point for the framework. Creating a new instance of the world class
 * will start a frame with the drawing/updating canvas inside of it.
 * 
 * @author Jordan Price
 */
public class World extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Drawable> renderBlock = new ArrayList<Drawable>();

	public World(int width, int height) {
		JFrame frame = new JFrame("Squire");

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

		new Thread(this).start();
	}

	public void update() {

	}
	
	@Override
	public void paintComponent(Graphics g) {
		for (Drawable obj : renderBlock) {
			obj.draw(g);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				update();
				repaint();
				Thread.sleep(1000 / 30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Add a new Drawable object to the render block.
	 * 
	 * @param obj
	 *            The object to add
	 */
	public void add(Drawable... objs) {
		for (Drawable obj : objs)
			renderBlock.add(obj);
	}

	/**
	 * Remove a Drawable object from the render block.
	 * 
	 * @param obj
	 *            The object to remove
	 */
	public void remove(Drawable... objs) {
		for (Drawable obj : objs)
			renderBlock.remove(obj);
	}

}
