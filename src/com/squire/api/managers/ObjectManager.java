package com.squire.api.managers;
import java.util.ArrayList;

public abstract class ObjectManager<Type> {
	
	public ArrayList<Type> objects;
	
	public ObjectManager() {
		objects = new ArrayList<Type>();
	}
	
	public Type create(Type obj) {
		objects.add(obj);
		return obj;
	}
	
	public Type destroy(Type obj) {
		objects.remove(obj);
		return obj;
	}
	
	public Type getObject(int index) {
		return objects.get(index);
	}
	
	public ArrayList<Type> getObjects() {
		return objects;
	}

}
