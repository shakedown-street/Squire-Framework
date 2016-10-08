package com.squire.api;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jordan/shakedown-street
 */
@SuppressWarnings("serial")
public class SquireFrame {
	
	private JFrame frame;
	private SquireGame game;

	public SquireFrame(SquireGame _game) {
		frame = new JFrame(_game.getTitle());
		game = _game;

		JPanel root = new JPanel(new BorderLayout());
		root.add(_game, BorderLayout.CENTER);
		frame.getContentPane().add(root);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
	}
	
	public void launch() {
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
	}
}
