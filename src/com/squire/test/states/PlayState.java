package com.squire.test.states;

import java.awt.Graphics;
import java.io.File;

import com.squire.api.SquireGame;
import com.squire.api.graphics.Animation;
import com.squire.api.graphics.Sprite;
import com.squire.api.input.KeyInput;
import com.squire.api.state.AbstractState;
import com.squire.api.state.StateHandler;
import com.squire.api.ui.UILayout;

public class PlayState extends AbstractState {
	
	private String dir = "./assets/kenney/spaceshooter/PNG/";
	private Sprite[] testFrames = {
			new Sprite(new File(dir + "ufoBlue.png")),
			new Sprite(new File(dir + "ufoGreen.png")),
			new Sprite(new File(dir + "ufoRed.png")),
			new Sprite(new File(dir + "ufoYellow.png"))
	};
	private Animation testAnimation;

	public PlayState(SquireGame game, String name) {
		super(game, name);
	}
	
	public PlayState(SquireGame game, String name, UILayout layout) {
		super(game, name, layout);
	}
	
	int x = 5, y = 5;
	int xSpeed = 5, ySpeed = 5;

	@Override
	public void init() {
		testAnimation = new Animation(testFrames, 1000);
	}

	@Override
	public void process() {
		
	}

	@Override
	public void render(Graphics g) {
		KeyInput keys = getGame().getCanvas().getKeyInput();
		
		testAnimation.render(g, x, y);
		
		if (keys.isKeyPressed(87)) { // w
			y -= ySpeed;
		}
		if (keys.isKeyPressed(65)) { // a
			x -= xSpeed;
		}
		if (keys.isKeyPressed(83)) { // s
			y += ySpeed;
		}
		if (keys.isKeyPressed(68)) { // d
			x += xSpeed;
		}
	}

}
