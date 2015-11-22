package tests;

import java.awt.Graphics;
import java.io.File;

import com.squire.api.graphics.Sprite;
import com.squire.api.graphics.SpriteSheet;
import com.squire.api.listeners.Key;
import com.squire.api.state.State;
import com.squire.api.state.StateHandler;

public class StartState extends State {

	private SpriteSheet sheet;
	private Sprite startBg;

	@Override
	public void init() {
		this.sheet = new SpriteSheet(new File("./assets/sheet.png"));
		this.startBg = new Sprite(this.sheet, 0, 0, 800, 500);
	}

	@Override
	public void process() {
		if (Key.keymap[18]) {
			StateHandler.setState(new PlayState());
		}
	}

	@Override
	public void render(Graphics g) {
		startBg.draw(g, 0, 0, 800, 500);
	}

}
