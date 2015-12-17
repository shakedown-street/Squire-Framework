package com.squire.api.state;

import com.squire.api.SquireGame;

public abstract class AbstractState implements State {

	private String name;
	private String status;
	private SquireGame game;

	public AbstractState(SquireGame game, String name) {
		this.game = game;
		this.name = name;
		this.status = "";
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

}
