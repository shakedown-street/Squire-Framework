package com.squire.api.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.squire.api.SquireGame;

public class KeyInput implements KeyListener {
	
	private boolean[] keymap = new boolean[256];
	
	private SquireGame game;
	
	public KeyInput(SquireGame game) {
		this.game = game;
	}
	
	public boolean isKeyPressed(int key) {
		return keymap[key];
	}
	
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
	
	public SquireGame getGame() {
		return game;
	}

}
