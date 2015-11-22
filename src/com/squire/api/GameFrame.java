package com.squire.api;

import javax.swing.JFrame;

import com.squire.api.listeners.Key;
import com.squire.api.listeners.Mouse;

public class GameFrame {

	private static JFrame frame;

	public static void init(Game game) {
		frame = new JFrame("Squire");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(game);
		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		frame.setVisible(true);

		Key key = new Key();
		Mouse mouse = new Mouse();

		frame.addKeyListener(key);
		frame.addMouseListener(mouse);
		frame.addMouseMotionListener(mouse);
	}

	/**
	 * Set the title of the frame
	 */
	public static void setTitle(String title) {
		frame.setTitle(title);
	}

	public static String getTitle() {
		return frame.getTitle();
	}

}
