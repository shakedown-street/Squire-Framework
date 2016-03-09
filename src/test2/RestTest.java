package test2;

import java.awt.Graphics;

import com.squire.api.v2.SquireGame;
import com.squire.api.v2.models.Sprite;
import com.squire.api.v2.models.State;
import com.squire.api.v2.services.SpriteService;

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
			SpriteService sprites;

			Sprite sprite;

			@Override
			public void init() {
				connection = new APIConnection("http://127.0.0.1:8000", "?format=json", 5000);
				sprites = new SpriteService(connection);

				Response res = sprites.retrieve(6);
				sprite = new Sprite(res);
			}

			@Override
			public void process() {

			}

			@Override
			public void render(Graphics g) {
				sprite.render(g, 20, 20);
			}

			@Override
			public void endHook() {

			}
		};
		getStateService().setState(state);
	}

	public static void main(String[] args) {
		new RestTest(800, 640).start();
	}

}
