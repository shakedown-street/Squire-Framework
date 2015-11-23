package tests;

import java.awt.Color;
import java.awt.Graphics;

import com.squire.api.state.SelectionState;
import com.squire.api.state.StateHandler;

public class StartState extends SelectionState {

	public StartState(String name, String[] choices, StateHandler handler) {
		super(name, choices, handler);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 800, 500);
		for (int i = 0; i < choices.length; i++) {
			g.setColor(Color.BLACK);
			g.drawString(choices[i], 40, 40 + (i * 40));
		}
	}

}
