package com.squire.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.squire.api.input.KeyInput;

@SuppressWarnings("serial")
public class SquireCanvas extends Canvas {

	private SquireGame game;
	private final int BUFFERS = 2;

	private KeyInput keyInput;
	
	public SquireCanvas(SquireGame game) {
		this.game = game;
		setFocusable(true);

		setMinimumSize(new Dimension(game.getCanvasWidth(), game.getCanvasHeight()));
		setSize(new Dimension(game.getCanvasWidth(), game.getCanvasHeight()));
		
		init();
	}
	
	public void init() {
		keyInput = new KeyInput(game);
		
		addKeyListener(keyInput);
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(BUFFERS);
			requestFocus();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, game.getCanvasWidth(), game.getCanvasHeight());
		game.getEngine().getStateManager().renderState(g);
		game.getEngine().getUIManager().renderUI(g);

		g.dispose();
		bs.show();
	}
	
	public KeyInput getKeyInput() {
		return keyInput;
	}

}
