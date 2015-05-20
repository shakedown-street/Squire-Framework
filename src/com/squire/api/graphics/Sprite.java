package com.squire.api.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents a game image.
 * 
 * Sprites do not implement drawable and therefore cannot be drawn solo.
 * 
 * @author Jordan Price
 *
 */
public class Sprite {

	private BufferedImage img;

	public Sprite(File f) {
		try {
			this.img = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Sprite(BufferedImage img) {
		this.img = img;
	}

	/**
	 * Can be used in the draw method of classes implementing the Drawable
	 * interface, not directly
	 * 
	 * @param g
	 *            Graphics object
	 * @param x
	 *            x Origin
	 * @param y
	 *            y Origin
	 */
	public void draw(Graphics g, int x, int y) {
		g.drawImage(getImg(), x, y, null);
	}

	public void draw(Graphics g, int x, int y, int w, int h) {
		g.drawImage(getImg(), x, y, w, h, null);
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

}
