package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import com.squire.api.graphics.Sprite;
import com.squire.api.graphics.SpriteSheet;
import com.squire.api.state.AbstractState;
import com.squire.api.ui.UIButton;

public class StartState extends AbstractState {
	
	private SpriteSheet greySheet;
	private Sprite greyButton00;
	private UIButton startButton;

	public StartState(String name) {
		super(name);
	}

	@Override
	public void init() {
		setStatus("initialized");
		printStatus();
		
		greySheet = new SpriteSheet(new File(
				"./assets/kenney/ui/ui-2/Spritesheet/greySheet.png"));
		greyButton00 = greySheet.getSprite(0, 143, 190, 45);
		startButton = new UIButton(greyButton00, 0, 0, 190, 45);
		getUIHandler().addObject(startButton);
	}
	
	int processCount = 0;
	int renderCount = 0;

	@Override
	public void process() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 800, 600);
	}
}
