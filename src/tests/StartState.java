package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import com.squire.api.graphics.Sprite;
import com.squire.api.graphics.SpriteSheet;
import com.squire.api.state.AbstractState;
import com.squire.api.ui.UIButton;
import com.squire.api.ui.UIHandler;

public class StartState extends AbstractState {

	public StartState(String name) {
		super(name);
	}

	@Override
	public void init() {
		setStatus("initialized");
		printStatus();
		
		getUIHandler().setLayout(new StartLayout());
	}

	@Override
	public void process() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 800, 600);
	}
}
