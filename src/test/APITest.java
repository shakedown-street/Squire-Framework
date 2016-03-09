package test;

import java.awt.Graphics;

import com.squire.api.v2.SquireEvent;
import com.squire.api.v2.SquireGame;
import com.squire.api.v2.models.State;

import jprice.rest.APIConnection;
import jprice.rest.ModelService;

@SuppressWarnings("serial")
public class APITest extends SquireGame {

	public APITest(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		State state = new State(this, "state") {

			APIConnection api = new APIConnection("http://127.0.0.1:8000", "?format=json", 5000);
			ModelService people = new ModelService(api) {
				@Override
				public String getEndpoint() {
					return "/people/";
				}
			};
			Person person;

			@Override
			public void init() {
				SquireEvent switchEvent = new SquireEvent(2500, 3) {
					int id = 1;

					@Override
					public void execute() {
						person = new Person(people.retrieve(id));
						id++;
					}
				};
				switchEvent.start();
			}

			@Override
			public void process() {

			}

			@Override
			public void render(Graphics g) {
				person.draw(g);
			}

			@Override
			public void endHook() {

			}
		};
		getStateService().setState(state);
	}

	public static void main(String[] args) {
		new APITest(800, 640).start();
	}

}
