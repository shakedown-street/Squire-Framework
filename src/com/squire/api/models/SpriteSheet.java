package com.squire.api.models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {

    private BufferedImage image;

    /**
     * Loads
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

    public SpriteSheet(String _path) {
        this(new File(_path));
    }

    public Sprite getSprite(int _x, int _y, int _w, int _h) {
        return new Sprite(image.getSubimage(_x, _y, _w, _h));
    }

}
