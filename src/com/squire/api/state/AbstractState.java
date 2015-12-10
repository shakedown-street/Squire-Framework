package com.squire.api.state;

import com.squire.api.SquireGame;
import com.squire.api.ui.UILayout;
import com.squire.api.ui.UIManager;

public abstract class AbstractState implements State {

	private String name;
	private String status;
	private UIManager uiManager;
	private SquireGame game;

	public AbstractState(SquireGame game, String name) {
		this.game = game;
		this.name = name;
		this.status = "";
		this.uiManager = new UIManager();
	}

	public AbstractState(SquireGame game, String name, UILayout layout) {
		this(game, name);
		getUIManager().setUILayout(layout);
	}
	
	public SquireGame getGame() {
		return game;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return getName() + " : " + status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void printStatus() {
		System.out.println(getStatus());
	}

	public UIManager getUIManager() {
		return uiManager;
	}

}
