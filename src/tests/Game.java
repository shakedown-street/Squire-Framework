package tests;

import java.io.File;

import com.squire.api.World;
import com.squire.api.graphics.Sprite;
import com.squire.api.graphics.SpriteSheet;

public class Game {

	public static void main(String[] args) {
		World world = new World(800, 500);

		SpriteSheet sheet = new SpriteSheet(new File("./assets/sheet.png"));
		Sprite startScreen = new Sprite(sheet, 0, 0, 800, 500);
		Sprite gameScreen = new Sprite(sheet, 800, 0, 800, 500);
		Sprite playerSprite = new Sprite(sheet, 0, 500, 50, 50);
		Sprite enemySprite = new Sprite(sheet, 50, 500, 50, 50);
	}

}
