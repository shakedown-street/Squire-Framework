package test;

import java.awt.Graphics;

import com.squire.api.SquireGame;
import com.squire.api.models.Animation;
import com.squire.api.models.Sprite;
import com.squire.api.models.State;

@SuppressWarnings("serial")
public class AnimationTest extends SquireGame {

	private State startState;

	private Animation anim;

	public AnimationTest(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		startState = new State(this, "start-state") {

			@Override
			public void init() {
				String location = "./example/assets/spaceshooter/PNG/";
				Sprite[] sprites = { new Sprite(location + "playerShip1_blue.png"),
						new Sprite(location + "playerShip1_red.png"), new Sprite(location + "playerShip1_green.png"),
						new Sprite(location + "playerShip1_orange.png") };

				anim = getAnimationService().create(new Animation(sprites, 60));
				anim.start(true);
			}

			@Override
			public void process() {

			}

			@Override
			public void render(Graphics g) {
				anim.render(g, 20, 20);
			}

			@Override
			public void endHook() {

			}
		};
		getStateService().setState(startState);
		;
	}

	public static void main(String[] args) {
		new AnimationTest(800, 500).start();
	}

}
