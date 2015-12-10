package com.squire.test.components;

import java.awt.Graphics;
import java.io.File;

import com.squire.api.graphics.Sprite;
import com.squire.api.ui.UIButton;

public class PlayButton extends UIButton {

	private Sprite buttonSprite = new Sprite(new File("./assets/kenney/spaceshooter/PNG/UI/buttonBlue.png"));

	@Override
	public void onClick() {

	}

	@Override
	public void onHover() {

	}

	@Override
	public void renderComponent(Graphics g) {
		buttonSprite.draw(g, 0, 0);
	}
}
