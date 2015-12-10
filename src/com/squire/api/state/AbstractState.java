package com.squire.api.state;

import com.squire.api.ui.UILayout;
import com.squire.api.ui.UIManager;

public abstract class AbstractState implements State {

	private String name;
	private String status;
	private UIManager uiManager;

	public AbstractState(String name) {
		this.name = name;
		this.status = "";
		this.uiManager = new UIManager();
	}

	public AbstractState(String name, UILayout layout) {
		this(name);
		getUIManager().setUILayout(layout);
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = getName() + " : " + status;
	}

	public void printStatus() {
		System.out.println(getStatus());
	}

	public UIManager getUIManager() {
		return uiManager;
	}

}
