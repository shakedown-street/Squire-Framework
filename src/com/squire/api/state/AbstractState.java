package com.squire.api.state;

import com.squire.api.ui.UIHandler;

public abstract class AbstractState implements State {

	private String name;
	private String status;
	private UIHandler uiHandler;

	public AbstractState(String name) {
		this.name = name;
	}
	
	public UIHandler getUIHandler() {
		if (uiHandler == null) {
			uiHandler = new UIHandler();
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
