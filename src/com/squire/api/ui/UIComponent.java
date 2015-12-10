package com.squire.api.ui;

import java.awt.Graphics;

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
