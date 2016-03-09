package com.squire.api.v1.models;

import java.awt.Graphics;
import java.util.ArrayList;

import com.squire.api.v1.SquireGame;
import com.squire.api.v1.models.Animation;
import com.squire.api.v1.models.Sprite;
import com.squire.api.v1.player.Keys;
import com.squire.api.v1.player.Mouse;
import com.squire.api.v1.services.AnimationService;
import com.squire.api.v1.services.SpriteService;

/**
 * @author Jordan/shakedown-street
 */
public abstract class State {

	private String name;
	private SquireGame game;
	private boolean ended;

	private Keys keyInput;
	private Mouse mouseInput;
	private AnimationService animationService;
	private SpriteService spriteService;

	public State(SquireGame _game, String _name) {
		this.name = _name;
		game = _game;
		ended = false;
		animationService = new AnimationService();
		spriteService = new SpriteService();

		keyInput = new Keys();
		mouseInput = new Mouse();
	}

	public abstract void init();

	public abstract void process();

	public abstract void render(Graphics g);

	public abstract void endHook();

	public void stop() {
		this.ended = true;
		this.endHook();
	}

	public String getName() {
		return name;
	}

	public SquireGame getGame() {
		return game;
	}

	public boolean hasEnded() {
		return ended;
	}
	
	public Keys getKeys() {
		return keyInput;
	}
	
	public Mouse getMouse() {
		return mouseInput;
	}

	public AnimationService getAnimationService() {
		return animationService;
	}

	public ArrayList<Animation> getAnimations() {
		return getAnimationService().objectSet();
	}

	public SpriteService getSpriteService() {
		return spriteService;
	}

	public ArrayList<Sprite> getSprites() {
		return getSpriteService().objectSet();
	}

}
