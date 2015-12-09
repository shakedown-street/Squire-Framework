package com.squire.test;

import com.squire.api.SquireFrame;
import com.squire.api.SquireGame;
import com.squire.test.layouts.StartLayout;
import com.squire.test.states.StartState;

@SuppressWarnings("serial")
public class SpaceShooter extends SquireGame {
	
	private static SquireFrame frame;

	public SpaceShooter(String title, int canvasWidth, int canvasHeight) {
		super(title, canvasWidth, canvasHeight);
	}

	@Override
	public void init() {
		getEngine().getStateHandler().setState(new StartState(
				"start_state", new StartLayout()));
	}
	
	public static SquireFrame getFrame() {
		return frame;
	}
	
	public static void main(String[] args) {
		SpaceShooter shooter = new SpaceShooter("Space Shooter", 800, 500);
		frame = new SquireFrame(shooter);
		frame.initialize();
	}

}
