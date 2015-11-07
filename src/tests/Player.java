package tests;

import java.awt.Graphics;

import com.squire.api.entity.ControlledEntity;
import com.squire.api.graphics.Sprite;

public class Player extends ControlledEntity {

	public Player(Sprite sprite, int x, int y, int w, int h) {
		super(sprite, x, y, w, h);
	}

	@Override
	public void process() {
		this.x += 5;
		this.y += 5;
	}

	@Override
	public void draw(Graphics g) {
		this.sprite.draw(g, this.x, this.y, this.w, this.h);
	}

	@Override
	public void clickActions() {
		
	}

	@Override
	public void mouseActions() {
		
	}

	@Override
	public void keyActions() {
		
	}
}
