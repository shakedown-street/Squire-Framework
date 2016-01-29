package com.squire.api;

import java.util.ArrayList;

/**
 * @author Jordan/shakedown-street
 *
 * @param <Model>
 */
public abstract class SquireService<Model> {

	protected ArrayList<Model> objects;

	public SquireService() {
		objects = new ArrayList<Model>();
	}

	public Model create(Model obj) {
		objects.add(obj);
		return obj;
	}

	public Model retrieve(int id) {
		if (objects.get(id) == null) {
			return null;
		}
		return objects.get(id);
	}

	public ArrayList<Model> objectSet() {
		if (objects.equals(null) || objects.isEmpty()) {
			return null;
		}
		return objects;
	}

	public Model update(int id, Model newObj) {
		if (objects.get(id) == null) {
			return null;
		}
		objects.set(id, newObj);
		return newObj;
	}

	public void destroy(int id) {
		objects.remove(id);
	}

	public void destroy(Model obj) {
		objects.remove(obj);
	}

}
