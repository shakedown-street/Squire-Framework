package com.squire.api.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A very basic key input handler. Uses an array of booleans to identify which
 * keys are currently pressed.
 * 
 * @author Jordan Price
 *
 */
public class Key implements KeyListener {

	public static boolean[] keymap = new boolean[1024 * 1000];

	@Override
	public void keyPressed(KeyEvent e) {
		keymap[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keymap[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
