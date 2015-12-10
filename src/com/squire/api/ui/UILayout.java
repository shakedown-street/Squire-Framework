package com.squire.api.ui;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class UILayout {

	private ArrayList<UIComponent> components;

	public UILayout() {
		components = new ArrayList<UIComponent>();
	}

	public abstract void initLayout();

	public void renderLayout(Graphics g) {
		for (UIComponent component : components) {
			component.renderComponent(g);
		}
	}

	public void addComponent(UIComponent c) {
		components.add(c);
	}

	public void addComponents(UIComponent... uiComponents) {
		for (UIComponent c : uiComponents) {
			this.components.add(c);
		}
	}

	public ArrayList<UIComponent> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<UIComponent> components) {
		this.components = components;
	}

}
