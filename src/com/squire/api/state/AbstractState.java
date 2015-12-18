package com.squire.api.state;

public abstract class AbstractState implements State {

	private String name;

	public AbstractState(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
