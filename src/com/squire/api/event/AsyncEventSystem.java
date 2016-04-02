package com.squire.api.event;

import java.util.ArrayList;

public class AsyncEventSystem {
	
	private ArrayList<AsyncEvent> events;
	
	public AsyncEventSystem() {
		events = new ArrayList<AsyncEvent>();
	}
	
	public void process() {
		for (int i = 0; i < events.size(); i++) {
			if (!events.get(i).shouldExecute()) {
				events.remove(i);
			}
		}
	}
	
	public void addEvent(AsyncEvent e) {
		events.add(e);
	}

}
