package com.squire.api.ui;

import java.awt.Graphics;

import com.squire.api.graphics.Sprite;

public abstract class UIComponent {
	
	private Sprite sprite;
	private int x, y, w, h;
	
	public UIComponent(Sprite sprite, int x, int y, int w, int h) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public abstract void renderComponent(Graphics g);
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void resize(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return w;
	}
	
	public int getHeight() {
		return h;
	}
	
}
