package com.squire.api.event;

import java.util.ArrayList;

/**
 * Cycles through all events at the specified cycle rate.
 * 
 * @author Jordan Price
 */

public class EventManager {

	/**
	 * The events currently being executed by the engine
	 */

	private ArrayList<AbstractEvent> events;

	public EventManager() {
		events = new ArrayList<AbstractEvent>();
	}

	/**
	 * Submits the specified event to the EventManager.
	 * 
	 * @param evt
	 */
	public void submit(AbstractEvent evt) {
		evt.init();
		evt.setRunning(true);
		events.add(evt);
	}

	/**
	 * Removes the specified event.
	 * 
	 * @param evt
	 */
	public void remove(AbstractEvent evt) {
		events.remove(evt);
	}

	/**
	 * Clears all the events
	 */
	public void clear() {
		events.clear();
	}
	
	public void process() {
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i).shouldExecute()) {
				events.get(i).execute();
			} else {
				events.remove(i);
			}
		}
	}

	public ArrayList<AbstractEvent> getEvents() {
		return events;
	}
}
