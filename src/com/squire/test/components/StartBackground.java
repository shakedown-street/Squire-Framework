package com.squire.test.components;

import java.awt.Graphics;
import java.io.File;

import com.squire.api.graphics.Sprite;
import com.squire.api.ui.UIComponent;

public class StartBackground extends UIComponent {

	private Sprite bg = new Sprite(
			new File("./assets/kenney/spaceshooter/Backgrounds/purple.png"));

	@Override
	public void renderComponent(Graphics g) {
		bg.render(g, 0, 0, 800, 500);
	}

}
