package com.squire.test.layouts;

import java.awt.Graphics;
import java.io.File;

import com.squire.api.graphics.Sprite;
import com.squire.api.ui.UIComponent;
import com.squire.api.ui.UILayout;

public class PlayLayout extends UILayout {

	private Sprite background;

	public PlayLayout() {
		background = new Sprite(
				new File("./assets/kenney/spaceshooter/Backgrounds/blue.png"));
	}

	@Override
	public void initLayout() {
		addComponent(new UIComponent() {
			@Override
			public void renderComponent(Graphics g) {
				background.render(g, 0, 0, 800, 500);
			}
		});
	}

}
