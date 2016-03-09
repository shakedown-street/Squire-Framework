package test;

import java.awt.Graphics;

import com.squire.api.SquireEvent;
import com.squire.api.SquireGame;
import com.squire.api.models.Animation;
import com.squire.api.models.Player;
import com.squire.api.services.AnimationService;
import com.squire.api.services.PlayerService;
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
			PlayerService players;
			Player player;

			@Override
			public void init() {
				connection = new APIConnection("http://127.0.0.1:8000", "?format=json", 5000);
				players = new PlayerService(connection);
				Response res = players.retrieve(1);
				player = new Player(res);
				player.getAnimation().start();

				SquireEvent move = new SquireEvent(1000 / 60, 200) {
					@Override
					public void execute() {
						player.incrementX();
						player.incrementY();

					}
				};
				move.start();
			}

			@Override
			public void process() {

			}

			@Override
			public void render(Graphics g) {
				player.getAnimation().render(g, (int) player.getPosX(), (int) player.getPosY());
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
