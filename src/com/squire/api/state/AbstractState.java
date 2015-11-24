package com.squire.api.state;

public abstract class AbstractState implements State {

	private String name;
	private String status;
	private int id;

	public AbstractState(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = this.name + " : " + status;
	}
	
	public int getID() {
		return id;
	}

}
