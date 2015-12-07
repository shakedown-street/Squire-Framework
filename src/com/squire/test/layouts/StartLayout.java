package com.squire.test.layouts;

import java.awt.Graphics;
import java.io.File;

import com.squire.api.graphics.Sprite;
import com.squire.api.graphics.SpriteSheet;
import com.squire.api.ui.UICheckbox;
import com.squire.api.ui.UILayout;

public class StartLayout extends UILayout {

	private SpriteSheet greySheet = new SpriteSheet(
			new File("./assets/kenney/ui/ui-2/Spritesheet/greySheet.png"));
	private Sprite greyBox = greySheet.getSprite(147, 433, 38, 36);
	private Sprite greyBoxCheckmark = greySheet.getSprite(185, 433, 38, 36);

	public StartLayout() {
		addComponent(new UICheckbox(null, 0, 0, 38, 36) {

			@Override
			public void renderChecked(Graphics g) {
				greyBoxCheckmark.draw(g, getX(), getY(), getWidth(),
						getHeight());
			}

			@Override
			public void renderUnchecked(Graphics g) {
				greyBox.draw(g, getX(), getY(), getWidth(), getHeight());
			}

		});
	}

}
