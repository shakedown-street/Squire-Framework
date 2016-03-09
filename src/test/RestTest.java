package test;

import java.awt.Graphics;

import com.squire.api.SquireGame;
import com.squire.api.models.Animation;
import com.squire.api.services.AnimationService;
import com.squire.api.state.State;

import jprice.rest.APIConnection;
import jprice.rest.Response;

@SuppressWarnings("serial")
public class RestTest extends SquireGame {

	public RestTest(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		State state = new State(this, "state") {

			APIConnection connection;
			AnimationService anims;

			Animation anim;

			@Override
			public void init() {
				connection = new APIConnection("http://127.0.0.1:8000", "?format=json", 5000);
				anims = new AnimationService(connection);

				Response res = anims.retrieve(3);
				anim = new Animation(res);
				anim.start();
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
		getStateHandler().setState(state);
	}

	public static void main(String[] args) {
		new RestTest(800, 640).start();
	}

}
