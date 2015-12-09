package com.squire.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

@SuppressWarnings("serial")
public class SquireCanvas extends Canvas {

	private SquireGame game;
	private final int BUFFERS = 3;

	public SquireCanvas(SquireGame game) {
		this.game = game;

		setMinimumSize(new Dimension(game.getCanvasWidth(), game.getCanvasHeight()));
		setSize(new Dimension(game.getCanvasWidth(), game.getCanvasHeight()));
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(BUFFERS);
			requestFocus();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		game.getEngine().getStateHandler().renderState(g);

		g.dispose();
		bs.show();
	}

}
