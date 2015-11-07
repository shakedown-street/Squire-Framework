package tests;

import java.awt.Graphics;

import com.squire.api.event.Updatable;
import com.squire.api.graphics.Drawable;
import com.squire.api.graphics.Sprite;
import com.squire.api.listeners.Mouse;

public abstract class Button extends Drawable implements Updatable {

	public Button(Sprite sprite, int x, int y, int w, int h) {
		super(sprite, x, y, w, h);
	}
	
	public boolean isClicked() {
		if (Mouse.clickX >= this.x && Mouse.clickX <= (this.x + this.w)
				&& Mouse.clickY >= this.y
				&& Mouse.clickY <= (this.y + this.h)) {
			return true;
		}
		return false;
	}

	public boolean isHovered() {
		if (Mouse.mouseX >= this.x && Mouse.mouseX <= (this.x + this.w)
				&& Mouse.mouseY >= this.y
				&& Mouse.mouseY <= (this.y + this.h)) {
			return true;
		}
		return false;
	}
	
	public abstract void onClick();

	@Override
	public void process() {
		if (isClicked()) {
			onClick();
			Mouse.clickX = -1;
			Mouse.clickY = -1;
		}
	}

	@Override
	public void draw(Graphics g) {
		sprite.draw(g, x, y);
	}

}
