package com.squire.api;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SquireFrame extends JFrame {

	public SquireFrame(SquireGame game) {
		super();

		JPanel root = new JPanel(new BorderLayout());
		root.add(game.getCanvas(), BorderLayout.CENTER);
		getContentPane().add(root);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		
		// setTitle(game.getTitle());
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
