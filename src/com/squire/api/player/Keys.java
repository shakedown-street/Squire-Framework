package com.squire.api.player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import com.squire.api.player.KeyAction.Type;

public class Keys implements KeyListener {
	
	private ArrayList<KeyAction> actions = new ArrayList<KeyAction>();

	@Override
	public void keyPressed(KeyEvent e) {
		for (KeyAction action : actions) {
			if (e.getKeyCode() == action.getKey() && action.getType() == Type.PRESSED) {
				action.act();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		for (KeyAction action : actions) {
			if (e.getKeyCode() == action.getKey() && action.getType() == Type.RELEASED) {
				action.act();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		for (KeyAction action : actions) {
			if (e.getKeyCode() == action.getKey() && action.getType() == Type.TYPED) {
				action.act();
			}
		}
	}
	
	public void addAction(KeyAction action) {
		actions.add(action);
	}

}
