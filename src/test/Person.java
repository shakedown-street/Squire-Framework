package test;

import java.awt.Graphics;

import jprice.rest.DataModel;
import jprice.rest.Response;

@SuppressWarnings("serial")
public class Person extends DataModel {
	
	public Person(Response _res) {
		super(_res);
	}

	public long getId() {
		return (long) get("id");
	}
	
	public String getFirstName() {
		return (String) get("first_name");
	}
	
	public String getLastName() {
		return (String) get("last_name");
	}
	
	public long getAge() {
		return (long) get("age");
	}
	
	public String getGender() {
		return (String) get("gender");
	}
	
	public void draw(Graphics g) {
		g.drawString("First Name: " + getFirstName(), 20, 20);
		g.drawString("Last Name: " + getLastName(), 20, 35);
		g.drawString("Age: " + getAge(), 20, 50);
		switch (getGender()) {
		case "M":
			g.drawString("Gender: Male", 20, 65);
			break;
		case "F":
			g.drawString("Gender: Male", 20, 65);
			break;
		}
	}

}
