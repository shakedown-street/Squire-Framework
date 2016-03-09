package com.squire.api.v1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jordan/shakedown-street
 */
@SuppressWarnings("serial")
public class SquireFrame extends JFrame {

	public SquireFrame(SquireGame game) {
		super();

		JPanel root = new JPanel(new BorderLayout());
		root.add(game, BorderLayout.CENTER);
		getContentPane().add(root);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();

		setLocationRelativeTo(null);
		setVisible(true);
	}

}
