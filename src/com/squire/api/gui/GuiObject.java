package com.squire.api.gui;

import com.squire.api.Point;
import com.squire.api.Size;
import com.squire.api.graphics.Drawable;
import com.squire.api.graphics.Sprite;

public class GuiObject extends Drawable {

	public GuiObject(Sprite sprite, Point pos, Size size) {
		super(sprite, pos, size);
	}

	public GuiObject(Sprite sprite, int x, int y, int w, int h) {
		this(sprite, new Point(x, y), new Size(w, h));
	}

}
