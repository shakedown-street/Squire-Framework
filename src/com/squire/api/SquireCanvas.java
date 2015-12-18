package com.squire.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

@SuppressWarnings("serial")
public class SquireCanvas extends Canvas {

	private final int BUFFERS = 2;
	private SquireGame game;
	
	public SquireCanvas(SquireGame game) {
		this.game = game;
		setFocusable(true);

		setMinimumSize(new Dimension(game.getWidth(), game.getHeight()));
		setSize(new Dimension(game.getWidth(), game.getHeight()));
		
		init();
	}
	
	public void init() {
		
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(BUFFERS);
			requestFocus();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, game.getWidth(), game.getHeight());
		
		// Render state
		game.getStateManager().renderState(g);
		// Render UI
		game.getUIManager().renderUI(g);

		g.dispose();
		bs.show();
	}

}
