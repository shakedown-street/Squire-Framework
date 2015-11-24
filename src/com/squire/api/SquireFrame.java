package com.squire.api;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SquireFrame {

	private JFrame frame;

	private SquireGame game;

	public SquireFrame(SquireGame game) {
		frame = new JFrame();
		this.game = game;

		JPanel root = new JPanel(new BorderLayout());
		root.add(game, BorderLayout.CENTER);
		frame.getContentPane().add(root);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle(game.getTitle());
		frame.pack();
	}

	public void initialize() {
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
	}

}
