package test;

import com.squire.api.SquireGame;

import jprice.rest.APIConnection;
import jprice.rest.Response;

@SuppressWarnings("serial")
public class APITest extends SquireGame {
	
	public APITest(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		APIConnection api = new APIConnection("https://randomuser.me", "/api/", 5000);
		Response res = api.list();
		System.out.println(res.getContent());
	}

	public static void main(String[] args) {
		new APITest(800, 640).start();
	}

}
