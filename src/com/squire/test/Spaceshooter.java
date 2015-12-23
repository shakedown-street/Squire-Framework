package com.squire.test;

import java.awt.Graphics;

import com.squire.api.SquireGame;
import com.squire.api.models.Sprite;
import com.squire.api.models.State;

@SuppressWarnings("serial")
public class Spaceshooter extends SquireGame {

	public Spaceshooter(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		getStateManager().create(new State(this, "start_state") {

			private String backgrounds = "./example/assets/spaceshooter/Backgrounds/";

			private Sprite purpleBackground;

			@Override
			public void init() {
				System.out.println("start state");

				purpleBackground = getGame().getSprites().create(
						new Sprite(backgrounds + "purple.png"));
			}

			@Override
			public void process() {

			}

			@Override
			public void render(Graphics g) {
				purpleBackground.render(g, 0, 0, 800, 500);
			}

			@Override
			public void endHook() {

			}
		});
		getStateManager().create(new State(this, "play_state") {

			@Override
			public void init() {

			}

			@Override
			public void process() {

			}

			@Override
			public void render(Graphics g) {

			}

			@Override
			public void endHook() {

			}

		});
		getStateManager().setState(getStateManager().getObject(0));
	}

	public static void main(String[] args) {
		new Spaceshooter(800, 500);
	}

}
