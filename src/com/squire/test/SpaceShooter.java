package com.squire.test;

import com.squire.api.SquireGame;

public class SpaceShooter extends SquireGame {

	public SpaceShooter(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		
	}
	
	public static void main(String[] args) {
		new SpaceShooter(800, 500);
	}

}
