package test;

import java.awt.Graphics;

import com.squire.api.SquireGame;
import com.squire.api.models.Sprite;

import jprice.state.IState;

public class Game extends SquireGame {

	public static void main(String[] args) {
		new Game(800, 640).start();
	}

	public Game(int _w, int _h) {
		super(_w, _h);
	}

	@Override
	public void init() {
		IState state = new IState() {

			Sprite playerShip1_blue;
			int shipX = 20, shipY = 20;

			@Override
			public void init() {
				playerShip1_blue = new Sprite(
						"./assets/spaceshooter/PNG/playerShip1_blue.png");
			}

			@Override
			public void process() {

			}

			@Override
			public void render(Graphics g) {
				playerShip1_blue.render(g, shipX, shipY);
			}

			@Override
			public void stop() {

			}
		};

		getStateHandler().setState(state);
	}

}
