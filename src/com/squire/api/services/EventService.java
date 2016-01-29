package com.squire.api.services;

import com.squire.api.SquireService;
import com.squire.api.models.Event;

/**
 * Cycles through all events at the specified cycle rate.
 * 
 * @author Jordan/shakedown-street
 */
public class EventService extends SquireService<Event> {
	public void process() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).shouldExecute()) {
				objects.remove(i);
			}
		}
	}
}
