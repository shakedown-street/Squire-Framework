package tests;

import java.awt.Graphics;

import com.squire.api.graphics.Sprite;

public class Entity {
	
	public Sprite sprite;
	public int x, y, width, height;
	
	public Entity(Sprite sprite, int x, int y, int width, int height) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g) {
		sprite.draw(g, this.x, this.y, this.width, this.height);
	}

}
