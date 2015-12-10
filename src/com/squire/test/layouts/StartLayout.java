package com.squire.test.layouts;

import java.io.File;

import com.squire.api.graphics.Sprite;
import com.squire.api.graphics.SpriteSheet;
import com.squire.api.ui.UILayout;
import com.squire.test.components.PlayButton;

public class StartLayout extends UILayout {

	private SpriteSheet sheet;
	private Sprite button00;

	public StartLayout() {
		sheet = new SpriteSheet(new File("./assets/kenney/ui/ui-2/Spritesheet/blueSheet.png"));
		button00 = sheet.getSprite(0, 94, 190, 49);
	}

	@Override
	public void initLayout() {
		addComponent(new PlayButton());
	}

}
