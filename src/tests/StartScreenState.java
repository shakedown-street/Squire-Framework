package tests;

import java.awt.Graphics;
import java.io.File;

import com.squire.api.graphics.Sprite;
import com.squire.api.graphics.SpriteSheet;
import com.squire.api.state.State;

public class StartScreenState extends State {
	

	SpriteSheet sheet = new SpriteSheet(new File("./assets/sheet.png"));
	Sprite startScreen = new Sprite(sheet, 0, 0, 800, 500);
	
	public StartScreenState() {}
	
	@Override
	public void init() {
		System.out.println("test");
	}

	@Override
	public void process() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(startScreen.getImg(), 0, 0, null);
	}

}
