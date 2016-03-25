package com.squire.api;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jordan/shakedown-street
 */
@SuppressWarnings("serial")
public class SquireFrame extends JFrame {

    public SquireFrame(SquireGame _game) {
        super();

        JPanel root = new JPanel(new BorderLayout());
        root.add(_game, BorderLayout.CENTER);
        getContentPane().add(root);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
