package com.squire.api;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SquireFrameWrapper {
	
	private JFrame frame;
	
	private SquireGame game;
	
	public SquireFrameWrapper(SquireGame game) {
		frame = new JFrame();
		this.game = game;
		
		JPanel root = new JPanel(new BorderLayout());
		root.add(game, BorderLayout.CENTER);
		frame.getContentPane().add(root);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle(game.getName());
	}
	
	public void initialize() {
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
	}

}
