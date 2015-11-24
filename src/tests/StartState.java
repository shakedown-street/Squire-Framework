package tests;

import java.awt.Color;
import java.awt.Graphics;

import com.squire.api.state.SelectionState;
import com.squire.api.state.StateHandler;

public class StartState extends SelectionState {

	public StartState(String name, String[] choices) {
		super(name, choices);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 800, 600);
		for (int i = 0; i < choices.length; i++) {
			if (choices[i].equalsIgnoreCase(choice)) {
				g.setColor(Color.BLUE);
				g.drawRect(40, 20 + (i * 40), 120, 20);
			}
			g.setColor(Color.BLACK);
			g.drawString(choices[i], 40, 40 + (i * 40));
		}
	}
}
