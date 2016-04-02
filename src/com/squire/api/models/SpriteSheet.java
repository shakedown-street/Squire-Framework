package com.squire.api.models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {

	private BufferedImage image;

	/**
	 * Creates a new SpriteSheet object from a BufferedImage object.
	 *
	 * @param _image
	 */
	public SpriteSheet(BufferedImage _image) {
		image = _image;
	}

	/**
	 * Loads and creates a new SpriteSheet from the file given.
	 *
	 * @param _file
	 */
	public SpriteSheet(File _file) {
		try {
			if (_file.exists() && _file.isFile()) {
				image = ImageIO.read(_file);
			} else {
				System.out.println(_file.getAbsoluteFile() + " not found");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads and creates a new SpriteSheet object from the file at the given
	 * path.
	 *
	 * @param _path
	 */
	public SpriteSheet(String _path) {
		this(new File(_path));
	}

	/**
	 * Returns a section of this SpriteSheet as a Sprite object
	 * 
	 * @param _x
	 * @param _y
	 * @param _w
	 * @param _h
	 * @return
	 */
	public Sprite getSprite(int _x, int _y, int _w, int _h) {
		return new Sprite(image.getSubimage(_x, _y, _w, _h));
	}

}
