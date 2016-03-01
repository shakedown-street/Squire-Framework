package test;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.squire.api.SquireGame;
import com.squire.api.models.State;
import com.squire.api.player.KeyAction;
import com.squire.api.player.KeyAction.Type;

@SuppressWarnings("serial")
public class ActionTest extends SquireGame {

	private State startState;

	public ActionTest(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		startState = getStateService().create(new State(this, "start") {

			@Override
			public void init() {
				getKeys().addAction(new KeyAction(KeyEvent.VK_W, Type.RELEASED) {
					@Override
					public void act() {
						System.out.println("w typed");
					}
				});
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
		getStateService().setState(startState);
	}

	public static void main(String[] args) {
		new ActionTest(800, 640).start();
	}

}
