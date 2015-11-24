package tests;

import java.awt.Color;
import java.awt.Graphics;

import com.squire.api.state.AbstractState;

public class StartState extends AbstractState {

	public StartState(String name) {
		super(name);
	}

	@Override
	public void init() {
		this.setStatus("test");
		System.out.println(this.status);
	}

	@Override
	public void process() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 800, 600);
	}
}
