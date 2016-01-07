package com.squire.api.ui;

import java.awt.Graphics;

import com.squire.api.ui.actions.Clickable;
import com.squire.api.ui.actions.Hoverable;
import com.squire.api.ui.actions.Toggleable;

public abstract class UIComponent {

	public UIComponent() {

	}

	public abstract void renderComponent(Graphics g);

	public boolean isClickable() {
		return (this instanceof Clickable);
	}

	public boolean isHoverable() {
		return (this instanceof Hoverable);
	}

	public boolean isToggleable() {
		return (this instanceof Toggleable);
	}

}
