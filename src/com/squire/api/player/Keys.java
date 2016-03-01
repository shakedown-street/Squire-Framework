package com.squire.api.player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Keys implements KeyListener {
	
	private ArrayList<KeyAction> actions = new ArrayList<KeyAction>();

	@Override
	public void keyPressed(KeyEvent e) {
		for (KeyAction action : actions) {
			if (e.getKeyCode() == action.getKey()) {
				action.act();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void addAction(KeyAction action) {
		actions.add(action);
	}

}
