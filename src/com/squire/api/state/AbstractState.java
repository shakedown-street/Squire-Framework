package com.squire.api.state;

import com.squire.api.ui.UIHandler;
import com.squire.api.ui.UILayout;

public abstract class AbstractState implements State {

	private String name;
	private String status;
	private UIHandler uiHandler;

	public AbstractState(String name) {
		this.name = name;
	}
	
	public AbstractState(String name, UILayout layout) {
		super();
		getUIHandler().setLayout(layout);
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
