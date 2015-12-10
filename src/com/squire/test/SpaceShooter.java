package com.squire.test;

import com.squire.api.SquireGame;
import com.squire.test.layouts.StartLayout;
import com.squire.test.states.StartState;

public class SpaceShooter extends SquireGame {

	public SpaceShooter(String title, int canvasWidth, int canvasHeight) {
		super(title, canvasWidth, canvasHeight);
	}

	public static void main(String[] args) {
		new SpaceShooter("Space Shooter", 800, 500);
	}

	@Override
	public void onInit() {
		getEngine().getStateHandler().setState(
				new StartState(this, "start_state", new StartLayout()));
	}

}
