package com.squire.api.models;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;

import jprice.rest.DataModel;
import jprice.rest.Response;

public class Sprite extends DataModel {
	
	private String name;
	private BufferedImage image;
	
	public Sprite(Response _res) {
		super(_res);
		name = (String) get("name");
		try {
			image = ImageIO.read(new URL((String) get("image")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Sprite(JSONObject obj) {
		super(obj);
		name = (String) get("name");
		try {
			image = ImageIO.read(new URL((String) get("image")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(getImage(), x, y, null);
	}

	public void render(Graphics g, int x, int y, int w, int h) {
		g.drawImage(getImage(), x, y, w, h, null);
	}

}
