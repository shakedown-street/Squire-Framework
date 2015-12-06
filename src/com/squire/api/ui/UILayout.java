package com.squire.api.ui;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class UILayout {
	
	private ArrayList<UIComponent> components;
	
	public UILayout() {
		components = new ArrayList<UIComponent>();
	}
	
	public void renderLayout(Graphics g) {
		for (UIComponent comp : components) {
			comp.renderComponent(g);
		}
	}
	
	public void addComponent(UIComponent component) {
		components.add(component);
	}

	public void removeComponent(UIComponent component) {
		components.remove(component);
	}
}
