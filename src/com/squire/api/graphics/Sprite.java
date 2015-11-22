package com.squire.api.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents a game image.
 *
 * @author Jordan Price
 *
 */
public class Sprite {

	private BufferedImage img;

	/**
	 * Create a Sprite from a local file
	 */
	public Sprite(File f) {
		try {
			this.img = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create a Sprite object from a BufferedImage
	 */
	public Sprite(BufferedImage img) {
		this.img = img;
	}

	/**
	 * Create a Sprite object from a Sprite sheet
	 */
	public Sprite(SpriteSheet sheet, int x, int y, int w, int h) {
		this.img = sheet.getSprite(x, y, w, h).getImg();
	}

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
