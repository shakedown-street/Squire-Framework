package com.squire.api.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Creates sheets of game images and returns cropped images (single Sprite
 * objects) at specific locations on the sheet.
 * 
 * @author Jordan Price
 *
 */
public class SpriteSheet {

	private BufferedImage img;

	public SpriteSheet(File f) {
		try {
			this.img = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns a sprite from the sheet at the specified location.
	 * 
	 * @param x
	 *            sprite x Origin
	 * @param y
	 *            sprite y Origin
	 * @param w
	 *            sprite width
	 * @param h
	 *            sprite height
	 * @return
	 */
	public Sprite sprite(int x, int y, int w, int h) {
		return new Sprite(img.getSubimage(x, y, w, h));
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

}