package com.squire.api.managers;

import com.squire.api.SquireManager;
import com.squire.api.models.Event;

/**
 * Cycles through all events at the specified cycle rate.
 * 
 * @author Jordan/shakedown-street
 */
public class EventManager extends SquireManager<Event> {
	public void process() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).shouldExecute()) {
				objects.remove(i);
			}
		}
	}
}
