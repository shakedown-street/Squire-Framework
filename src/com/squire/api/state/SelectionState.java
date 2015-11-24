package com.squire.api.state;

import java.awt.event.KeyEvent;

import com.squire.api.listeners.Key;

public abstract class SelectionState extends AbstractState {

	private int currentChoice;
	public String choice;
	public String[] choices;

	public SelectionState(String name, String[] choices) {
		super(name);
		this.choices = choices;
		currentChoice = -1;
	}

	@Override
	public void process() {
		if (Key.keymap[KeyEvent.VK_LEFT]) {
			if (currentChoice > 0) {
				currentChoice -= 1;
				choice = choices[currentChoice];
			}
		}
		if (Key.keymap[KeyEvent.VK_RIGHT]) {
			if (currentChoice < choices.length - 1) {
				currentChoice += 1;
				choice = choices[currentChoice];
			}
		}
	}
}
