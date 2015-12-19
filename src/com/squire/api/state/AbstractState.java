package com.squire.api.state;

import com.squire.api.SquireGame;
import com.squire.api.event.EventManager;
import com.squire.api.ui.InterfaceManager;

public abstract class AbstractState implements State {

	private String name;
	private SquireGame game;

	private EventManager eventManager;
	private InterfaceManager uiManager;
	
	private boolean ended;

	public AbstractState(SquireGame game, String name) {
		this.name = name;
		this.game = game;
		this.eventManager = new EventManager();
		this.uiManager = new InterfaceManager();
	}

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
