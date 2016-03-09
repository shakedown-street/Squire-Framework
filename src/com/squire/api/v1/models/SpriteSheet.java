package com.squire.api.v1.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Jordan/shakedown-street
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

	public BufferedImage getImg() {
		return img;
	}

	public BufferedImage getImg(int x, int y, int w, int h) {
		return img.getSubimage(x, y, w, h);
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

}
