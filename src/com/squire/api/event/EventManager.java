package com.squire.api.event;

import com.squire.api.ObjectManager;

/**
 * Cycles through all events at the specified cycle rate.
 * 
 * @author Jordan Price
 */

public class EventManager extends ObjectManager<Event> {
	
	@Override
	public Event create(Event obj) {
		super.create(obj);
		obj.init();
		obj.setRunning(true);
		return obj;
	}
	
	public void process() {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).shouldExecute()) {
				objects.get(i).execute();
			} else {
				objects.remove(i);
			}
		}
	}
}
