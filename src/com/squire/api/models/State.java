package com.squire.api.models;

import java.awt.Graphics;
import java.util.ArrayList;

import com.squire.api.SquireGame;
import com.squire.api.player.Keys;
import com.squire.api.player.Mouse;
import com.squire.api.services.AnimationService;
import com.squire.api.services.EventService;
import com.squire.api.services.SpriteService;

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
	private EventService eventService;
	private SpriteService spriteService;

	public State(SquireGame _game, String _name) {
		this.name = _name;
		game = _game;
		ended = false;
		animationService = new AnimationService();
		eventService = new EventService();
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

	public EventService getEventService() {
		return eventService;
	}

	public ArrayList<Event> getEvents() {
		return getEventService().objectSet();
	}

	public SpriteService getSpriteService() {
		return spriteService;
	}

	public ArrayList<Sprite> getSprites() {
		return getSpriteService().objectSet();
	}

}
