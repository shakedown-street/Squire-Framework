package com.squire.test.states;

import java.awt.Graphics;
import java.io.File;

import com.squire.api.SquireGame;
import com.squire.api.graphics.Animation;
import com.squire.api.graphics.Sprite;
import com.squire.api.state.AbstractState;

public class PlayState extends AbstractState {

	private String dir = "./assets/kenney/spaceshooter/PNG/";
	private Sprite[] testFrames = { 
			new Sprite(new File(dir + "playerShip3_blue.png")),
			new Sprite(new File(dir + "playerShip3_green.png")),
			new Sprite(new File(dir + "playerShip3_red.png")),
			new Sprite(new File(dir + "playerShip3_orange.png")) };
	private Animation testAnimation;

	private Sprite background;
	private Sprite damage1;
	private Sprite damage2;
	private Sprite damage3;
	private Sprite shield1;
	private Sprite shield2;
	private Sprite shield3;
	private Sprite engine5;

	public PlayState(SquireGame game, String name) {
		super(game, name);
	}

	@Override
	public void init() {
		background = new Sprite(
				new File("./assets/kenney/spaceshooter/Backgrounds/purple.png"));
		testAnimation = new Animation(testFrames, 1000);
		damage1 = new Sprite(new File(dir + "/Damage/playerShip3_damage1.png"));
		damage2 = new Sprite(new File(dir + "/Damage/playerShip3_damage2.png"));
		damage3 = new Sprite(new File(dir + "/Damage/playerShip3_damage3.png"));
		shield1 = new Sprite(new File(dir + "/Effects/shield1.png"));
		shield2 = new Sprite(new File(dir + "/Effects/shield2.png"));
		shield3 = new Sprite(new File(dir + "/Effects/shield3.png"));
		engine5 = new Sprite(new File(dir + "/Parts/engine5.png"));
	}
	
	int x = 0, y = 0;

	@Override
	public void process() {
		x++;
		y++;
	}

	@Override
	public void render(Graphics g) {
		background.render(g, 0, 0, 800, 500);
		testAnimation.render(g, x, y);
		damage1.render(g, x, y);
	}

}
