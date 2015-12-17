package com.squire.api;

import com.squire.api.event.EventManager;
import com.squire.api.state.StateManager;
import com.squire.api.ui.UIManager;

public class SquireEngine {

	private EventManager eventManager;
	private StateManager stateManager;
	private UIManager uiManager;

	public SquireEngine(SquireGame game) {
		eventManager = new EventManager();
		stateManager = new StateManager();
		uiManager = new UIManager();
	}

	public void process() {
		eventManager.process();
		stateManager.processState();
	}
	
	public EventManager getEventManager() {
		return eventManager;
	}

	public StateManager getStateManager() {
		return stateManager;
	}
	
	public UIManager getUIManager() {
		return uiManager;
	}

}
