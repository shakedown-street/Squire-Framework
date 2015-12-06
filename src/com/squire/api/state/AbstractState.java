package com.squire.api.state;

public abstract class AbstractState implements State {

	private String name;
	private String status;

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
		this.status = getName() + " : " + status;
	}
	
	public void printStatus() {
		System.out.println(getStatus());
	}

}
