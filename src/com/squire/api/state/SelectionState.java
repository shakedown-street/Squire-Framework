package com.squire.api.state;

import com.squire.api.listeners.Key;
import com.sun.glass.events.KeyEvent;

public abstract class SelectionState extends AbstractState {
	
	public int currentChoice;
	public String choice;
	public String[] choices;

	public SelectionState(String name, String[] choices, StateHandler handler) {
		super(name, handler);
		this.choices = choices;
		currentChoice = -1;
	}
	
	public void printChoice() {
		if (choice != null)
			System.out.println(choice);
	}
	
	@Override
	public void process() {
		if (Key.keymap[KeyEvent.VK_LEFT]) {
			System.out.println("left");
			if (currentChoice > 0) {
				currentChoice -= 1;
				choice = choices[currentChoice];
			}
		}
		if (Key.keymap[KeyEvent.VK_RIGHT]) {
			System.out.println("Right");
			if (currentChoice < choices.length) {
				currentChoice += 1;
				choice = choices[currentChoice];
			}
		}
		printChoice();
	}
}
