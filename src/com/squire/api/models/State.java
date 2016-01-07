package com.squire.api.models;

import java.awt.Graphics;
import java.util.ArrayList;

import com.squire.api.SquireGame;
import com.squire.api.managers.AnimationManager;
import com.squire.api.managers.EventManager;
import com.squire.api.managers.SpriteManager;

/**
 * @author Jordan/shakedown-street
 */
public abstract class State {

	private String name;
	private SquireGame game;
	private boolean ended;

	private AnimationManager animationManager;
	private EventManager eventManager;
	private SpriteManager spriteManager;

	public State(SquireGame game, String name) {
		this.name = name;
		this.game = game;
		this.ended = false;
		this.animationManager = new AnimationManager();
		this.eventManager = new EventManager();
		this.spriteManager = new SpriteManager();
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

	public EventManager getEventManager() {
		return eventManager;
	}

	public ArrayList<Event> getEvents() {
		return getEventManager().objectSet();
	}

	public SpriteManager getSpriteManager() {
		return spriteManager;
	}

	public ArrayList<Sprite> getSprites() {
		return getSpriteManager().objectSet();
	}

	public AnimationManager getAnimationManager() {
		return animationManager;
	}

	public ArrayList<Animation> getAnimations() {
		return getAnimationManager().objectSet();
	}

}
