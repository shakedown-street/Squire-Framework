package com.squire.test;

import java.awt.Graphics;

import com.squire.api.SquireGame;
import com.squire.api.models.Animation;
import com.squire.api.models.Event;
import com.squire.api.models.Sprite;
import com.squire.api.models.State;

/**
 * @author Jordan/shakedown-street
 */
public class StartState extends State {

	public StartState(SquireGame game, String name) {
		super(game, name);
	}

	private Sprite purpleBackground;
	private Sprite blue;
	private Sprite green;
	private Sprite orange;
	private Sprite red;
	private Animation switchColorAnim;
	private Event moveEvent;

	int cX = 20, cY = 20;

	@Override
	public void init() {
		String backgrounds = "./example/assets/spaceshooter/Backgrounds/";
		purpleBackground = getSpriteManager().create(new Sprite(backgrounds + "purple.png"));

		String playerShip1 = "./example/assets/spaceshooter/PNG/playerShip1_";
		blue = getSpriteManager().create(new Sprite(playerShip1 + "blue.png"));
		green = getSpriteManager().create(new Sprite(playerShip1 + "green.png"));
		orange = getSpriteManager().create(new Sprite(playerShip1 + "orange.png"));
		red = getSpriteManager().create(new Sprite(playerShip1 + "red.png"));

		switchColorAnim = getAnimationManager().create(new Animation(new Sprite[] { blue, green, orange, red }, 15));
		switchColorAnim.start(true);
		
		moveEvent = getEventManager().create(new Event(1) {

			@Override
			public void execute() {
				cX += 2;
				cY += 2;
				if (cY >= getGame().getHeight()) {
					getGame().setCurrentState(new StartState(getGame(), "start_state"));
					stop();
				}
			}
		});
	}

	@Override
	public void process() {
		
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

}
