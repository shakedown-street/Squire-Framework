package com.squire.test;

import java.awt.Graphics;

import com.squire.api.SquireGame;
import com.squire.api.models.Animation;
import com.squire.api.models.Event;
import com.squire.api.models.Sprite;
import com.squire.api.models.State;

@SuppressWarnings("serial")
public class Spaceshooter extends SquireGame {

	private State startState;

	public Spaceshooter(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		startState = getStateManager().create(new State(this, "start_state") {

			private Sprite purpleBackground;
			private Sprite blue;
			private Sprite green;
			private Sprite orange;
			private Sprite red;
			private Animation switchColorAnim;
			private Event printEvent;

			@Override
			public void init() {
				String backgrounds = "./example/assets/spaceshooter/Backgrounds/";
				purpleBackground = getSpriteManager().create(new Sprite(backgrounds + "purple.png"));

				String playerShip1 = "./example/assets/spaceshooter/PNG/playerShip1_";
				blue = getSpriteManager().create(new Sprite(playerShip1 + "blue.png"));
				green = getSpriteManager().create(new Sprite(playerShip1 + "green.png"));
				orange = getSpriteManager().create(new Sprite(playerShip1 + "orange.png"));
				red = getSpriteManager().create(new Sprite(playerShip1 + "red.png"));
				
				switchColorAnim = getAnimationManager()
						.create(new Animation(new Sprite[] { blue, green, orange, red }, 100));
				
				printEvent = getEventManager().create(new Event(60) {
					int var = 0;
					@Override
					public void execute() {
						var++;
						System.out.println("Ayy lmao " + var);
					}
				});
			}

			int cX = 20, cY = 20;

			@Override
			public void process() {
				cX++;
				cY++;
				if (cY >= 500) {
					stop();
				}
			}

			@Override
			public void render(Graphics g) {
				purpleBackground.render(g, 0, 0, 800, 500);
				switchColorAnim.render(g, cX, cY);
			}

			@Override
			public void endHook() {
				System.out.println("sup");
			}
		});
	}

	@Override
	public State initialState() {
		return startState;
	}

	public static void main(String[] args) {
		new Spaceshooter(800, 500);
	}

}
