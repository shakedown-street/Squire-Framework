package com.squire.test;

import com.squire.api.SquireGame;
import com.squire.api.models.State;

/**
 * @author Jordan/shakedown-street
 */
@SuppressWarnings("serial")
public class Spaceshooter extends SquireGame {

	private State startState;

	public Spaceshooter(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		startState = getStateManager().create(new StartState(this, "start_state"));
		getStateManager().setState(startState);
	}

	public static void main(String[] args) {
		new Spaceshooter(800, 500).start();
	}

}
