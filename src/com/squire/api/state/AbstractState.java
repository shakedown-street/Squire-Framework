package com.squire.api.state;

public abstract class AbstractState implements State {

	protected String name;
	protected String status;
	protected StateHandler stateHandler;

	public AbstractState(String name, StateHandler handler) {
		this.name = name;
		this.stateHandler = handler;
		init();
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = this.name + " : " + status;
	}
	
	public void printStatus() {
		System.out.println(getStatus());
	}
	
	public void alertStatus(String detail) {
		setStatus(detail);
		printStatus();
	}

}
