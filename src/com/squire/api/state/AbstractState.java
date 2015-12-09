package com.squire.api.state;

import com.squire.api.ui.UILayout;
import com.squire.api.ui.UIManager;

public abstract class AbstractState implements State {

	private String name;
	private String status;
	private UIManager uiHandler;

	public AbstractState(String name) {
		this.name = name;
	}
	
	public AbstractState(String name, UILayout layout) {
		super();
		getUIManager().setLayout(layout);
	}
	
	public UIManager getUIManager() {
		if (uiHandler == null) {
			uiHandler = new UIManager();
		}
		return uiHandler;
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

}
