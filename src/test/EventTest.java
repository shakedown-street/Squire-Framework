package test;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.squire.api.SquireEvent;
import com.squire.api.SquireGame;
import com.squire.api.models.Animation;
import com.squire.api.models.Sprite;
import com.squire.api.models.State;
import com.squire.api.player.KeyAction;
import com.squire.api.player.KeyAction.Type;

@SuppressWarnings("serial")
public class EventTest extends SquireGame {

	private State startState;

	private Animation anim;

	public EventTest(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		startState = new State(this, "start-state") {

			int x, y = 20;

			@Override
			public void init() {
				SquireEvent test = new SquireEvent(60, 600) {
					int i = 0;
					
					@Override
					public void execute() {
						System.out.println(getGame().lastFPS);
					}
				};
				test.start();

				String location = "./example/assets/spaceshooter/PNG/";
				Sprite[] sprites = {
						new Sprite(location + "playerShip1_blue.png"),
						new Sprite(location + "playerShip1_red.png"),
						new Sprite(location + "playerShip1_green.png"),
						new Sprite(location + "playerShip1_orange.png") };

				anim = getAnimationService().create(new Animation(sprites, 10));
				anim.start(true);
			}

			@Override
			public void process() {
				
			}

			@Override
			public void render(Graphics g) {
				anim.render(g, x, y);
			}

			@Override
			public void endHook() {

			}
		};
		getStateService().setState(startState);
	}

	public static void main(String[] args) {
		new EventTest(800, 640).start();
	}

}
