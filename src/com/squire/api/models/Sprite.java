package com.squire.api.models;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Jordan/shakedown-street
 */
public class Sprite {

	private BufferedImage img;

	public Sprite(BufferedImage img) {
		this.img = img;
	}

	public Sprite(File file) {
		try {
			this.img = ImageIO.read(file);
		} catch (IOException e) {
			this.img = null;
			e.printStackTrace();
		}
	}

	public Sprite(String filePath) {
		this(new File(filePath));
	}

	/**
	 * Create a Sprite object from a Sprite sheet
	 */
	public Sprite(SpriteSheet sheet, int x, int y, int w, int h) {
		this.img = sheet.getImg(x, y, w, h);
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(getImg(), x, y, null);
	}

	public void render(Graphics g, int x, int y, int w, int h) {
		g.drawImage(getImg(), x, y, w, h, null);
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

}
