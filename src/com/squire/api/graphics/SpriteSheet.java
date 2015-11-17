package com.squire.api.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Creates sheets of game images and returns cropped portions of the sheet as
 * Sprites.
 *
 * I would eventually like to add automatic XML configuration of sheets.
 *
 * @author Jordan Price
 *
 */
public class SpriteSheet {

	private BufferedImage img;

	/**
	 * Create a Sprite sheet from a local file.
	 */
	public SpriteSheet(File f) {
		try {
			this.img = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SpriteSheet(BufferedImage img) {
		this.img = img;
	}

	/**
	 * Returns a sprite from the sheet at the specified location.
	 */
	public Sprite getSprite(int x, int y, int w, int h) {
		return new Sprite(img.getSubimage(x, y, w, h));
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

}
