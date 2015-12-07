package com.squire.test.states;

import java.awt.Graphics;

import com.squire.api.state.AbstractState;
import com.squire.test.layouts.StartLayout;

public class StartState extends AbstractState {

	public StartState(String name) {
		super(name);
	}

	@Override
	public void init() {
		getUIHandler().setLayout(new StartLayout());
	}

	@Override
	public void process() {
		
	}

	@Override
	public void render(Graphics g) {
		
	}

}
