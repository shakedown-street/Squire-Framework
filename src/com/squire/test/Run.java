package com.squire.test;

import java.io.File;

import com.squire.api.World;
import com.squire.api.entity.Entity;
import com.squire.api.graphics.Sprite;
import com.squire.api.graphics.SpriteSheet;
import com.squire.api.gui.GuiObject;

public class Run {
	
	public static void main(String[] args) {
		World world = new World(800, 500);
		
		SpriteSheet sheet = new SpriteSheet(new File("assets/sheet.png"));
		
		Sprite startBG = sheet.sprite(0, 0, 800, 500);
		Sprite gameBG = sheet.sprite(800, 0, 800, 500);
		Sprite blue = sheet.sprite(0, 500, 50, 50);
		Sprite red = sheet.sprite(50, 500, 50, 50);
		
		GuiObject g = new GuiObject(gameBG, 0, 0, world.getWidth(), world.getHeight());
		Entity t = new Entity(blue, 50, 50, 50, 50);
		Entity q = new Entity(red, 368, 302, 50, 50);
		
		world.add(g, t, q);
	}

}
