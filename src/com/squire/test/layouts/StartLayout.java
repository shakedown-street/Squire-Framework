package com.squire.test.layouts;

import java.awt.Graphics;

import com.squire.api.ui.UIComponent;
import com.squire.api.ui.UILayout;

public class StartLayout extends UILayout {

	@Override
	public void initLayout() {
		addComponent(new UIComponent() {

			@Override
			public void renderComponent(Graphics g) {
				g.drawString("Press CTRL to enter next state", 20, 20);
			}
			
		});
	}

}
