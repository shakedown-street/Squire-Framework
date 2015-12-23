package com.squire.api.managers;

import com.squire.api.models.Event;

/**
 * Cycles through all events at the specified cycle rate.
 * 
 * @author Jordan Price
 */

public class EventManager extends ObjectManager<Event> {
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
