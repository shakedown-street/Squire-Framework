package com.squire.api;
import java.util.ArrayList;

public abstract class ObjectManager<Type> {
	
	public ArrayList<Type> objects;
	
	public ObjectManager() {
		objects = new ArrayList<Type>();
	}
	
	public void create(Type obj) {
		objects.add(obj);
	}
	
	public void destroy(Type obj) {
		objects.remove(obj);
	}
	
	public Type getObject(int index) {
		return objects.get(index);
	}
	
	public ArrayList<Type> getObjects() {
		return objects;
	}

}
