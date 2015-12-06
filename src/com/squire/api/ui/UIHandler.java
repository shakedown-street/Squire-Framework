package com.squire.api.ui;

import java.awt.Graphics;
import java.util.ArrayList;

public class UIHandler {
	
	private ArrayList<UIObject> uiObjs;
	
	public UIHandler() {
		uiObjs = new ArrayList<UIObject>();
	}
	
	public void render(Graphics g) {
		for (UIObject obj : uiObjs) {
			obj.render(g);
		}
	}
	
	public void addObject(UIObject obj) {
		uiObjs.add(obj);
	}
	
	public void removeObject(UIObject obj) {
		uiObjs.remove(obj);
	}
	
	public ArrayList<UIObject> getObjects() {
		return uiObjs;
	}

}
