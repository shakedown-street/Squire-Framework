package com.squire.api.models;

import java.awt.Graphics;
import java.util.ArrayList;

import com.squire.api.SquireGame;
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

	private AnimationService animationService;
	private EventService eventService;
	private SpriteService spriteService;

	public State(SquireGame game, String name) {
		this.name = name;
		this.game = game;
		this.ended = false;
		this.animationService = new AnimationService();
		this.eventService = new EventService();
		this.spriteService = new SpriteService();
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

	public AnimationService getAnimationService() {
		return animationService;
	}

	public ArrayList<Animation> getAnimations() {
		return getAnimationService().objectSet();
	}

}
