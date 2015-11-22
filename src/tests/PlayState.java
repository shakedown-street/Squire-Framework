package tests;

import java.awt.Graphics;
import java.io.File;

import com.squire.api.graphics.Sprite;
import com.squire.api.graphics.SpriteSheet;
import com.squire.api.listeners.Key;
import com.squire.api.state.State;
import com.sun.glass.events.KeyEvent;

public class PlayState extends State {

	private SpriteSheet sheet;
	private Sprite gameBg;
	private Sprite playerSprite;
	
	private Entity playerEntity;

	@Override
	public void init() {
		this.sheet = new SpriteSheet(new File("./assets/sheet.png"));
		this.gameBg = new Sprite(this.sheet, 800, 0, 800, 500);
		this.playerSprite = new Sprite(this.sheet, 0, 500, 50, 50);
		
		this.playerEntity = new Entity(playerSprite, 0, 0, 50, 50);
	}

	@Override
	public void process() {
		if (Key.keymap[KeyEvent.VK_W]) {
			playerEntity.y-=5;
		}
		if (Key.keymap[KeyEvent.VK_A]) {
			playerEntity.x-=5;
		}
		if (Key.keymap[KeyEvent.VK_S]) {
			playerEntity.y+=5;
		}
		if (Key.keymap[KeyEvent.VK_D]) {
			playerEntity.x+=5;
		}
	}

	@Override
	public void render(Graphics g) {
		gameBg.draw(g, 0, 0, 800, 500);
		playerEntity.draw(g);
	}

}
