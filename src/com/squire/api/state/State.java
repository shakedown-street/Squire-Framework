package com.squire.api.state;

import java.awt.Graphics;

import com.squire.api.SquireGame;
import com.squire.api.event.EventManager;
import com.squire.api.ui.InterfaceManager;

public abstract class State {

	private String name;
	private SquireGame game;

	private EventManager eventManager;
	private InterfaceManager uiManager;
	
	private boolean ended;

	public State(SquireGame game, String name) {
		this.name = name;
		this.game = game;
		this.eventManager = new EventManager();
		this.uiManager = new InterfaceManager();
	}
	
	public abstract void init();
	public abstract void process();
	public abstract void render(Graphics g);

	public String getName() {
		return name;
	}
	
	public SquireGame getGame() {
		return game;
	}
	
	public EventManager getEventManager() {
		return eventManager;
	}
	
	public InterfaceManager getUIManager() {
		return uiManager;
	}
	
	public abstract void endHook();
	
	public void stop() {
		this.ended = true;
		this.endHook();
	}
	
	public boolean hasEnded() {
		return ended;
	}

}
