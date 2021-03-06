package com.squire.api;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite {

	private BufferedImage image;

	/**
	 * Creates a new sprite from a BufferedImage object.
	 *
	 * @param _image
	 */
	public Sprite(BufferedImage _image) {
		image = _image;
	}

	/**
	 * Loads and creates a new Sprite object from the file given.
	 *
	 * @param _file
	 */
	public Sprite(File _file) {
		try {
			if (_file.exists() && _file.isFile()) {
				image = ImageIO.read(_file);
			} else {
				System.out.println(_file.getAbsoluteFile() + " not found.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads and creates a new Sprite object from the file at the given path.
	 *
	 * @param _path
	 */
	public Sprite(String _path) {
		this(new File(_path));
	}

	/**
	 * Creates a new Sprite object from a section of a SpriteSheet.
	 *
	 * @param _sheet
	 * @param _x
	 * @param _y
	 * @param _w
	 * @param _h
	 */
	public Sprite(SpriteSheet _sheet, int _x, int _y, int _w, int _h) {
		image = _sheet.getSprite(_x, _y, _w, _h).getImage();
	}

	/**
	 * Renders this Sprite at the given point on the screen.
	 *
	 * @param g
	 * @param x
	 * @param y
	 */
	public void render(Graphics g, int x, int y) {
		g.drawImage(image, x, y, null);
	}

	/**
	 * Renders this Sprite at the given point on the screen with a new width and
	 * height.
	 *
	 * @param g
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public void render(Graphics g, int x, int y, int w, int h) {
		g.drawImage(image, x, y, w, h, null);
	}

	/**
	 * Return the BufferedImage object from this Sprite
	 *
	 * @return
	 */
	public BufferedImage getImage() {
		return image;
	}

}
