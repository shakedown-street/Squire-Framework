package com.squire.test;

import com.squire.api.SquireFrame;

public class Launcher {
	
	private static SpaceShooter game = new SpaceShooter(
			"Space Shooter", 840, 500);
	private static SquireFrame frame = new SquireFrame(game);
	
	public static void main(String[] args) {
		frame.initialize();
	}

}
