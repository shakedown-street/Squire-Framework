package com.squire.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.squire.api.graphics.Animation;
import com.squire.api.graphics.Sprite;
import com.squire.api.state.StateManager;

/**
 * Squire: An open source game framework.
 * 
 * Use however you'd like.
 *
 * @author Jordan Price
 *
 */

@SuppressWarnings("serial")
public abstract class SquireGame extends Canvas implements Runnable {

	private Thread thread;
	
	private StateManager stateManager;
	private ObjectManager<Sprite> spriteManager;
	private ObjectManager<Animation> animationManager;
	
	private int width, height;
	private SquireFrame frame;

	public int lastFPS = 0;
	private final static int MAX_FPS = 60;
	private final static int BUFFERS = 2;

	public SquireGame(int width, int height) {
		this.width = width;
		this.height = height;
		setFocusable(true);

		setMinimumSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		setSize(new Dimension(width, height));
		load();
	}
	
	private void load() {
		stateManager = new StateManager();
		spriteManager = new ObjectManager<Sprite>() { };
		animationManager = new ObjectManager<Animation>() { };
		
		frame = new SquireFrame(this);
		start();
	}
	
	public abstract void init();
	
	private void process() {
		stateManager.processState();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(BUFFERS);
			requestFocus();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		stateManager.renderState(g);

		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		init();
		long lastFPSTime = System.currentTimeMillis();
		int fps = 0;
		long then = System.nanoTime();
		double unprocessed = 0d;
		double nsPerFrame = 1000000000.0d / MAX_FPS;
		while (true) {
			long now = System.nanoTime();
			unprocessed += (now - then) / nsPerFrame;
			then = now;
			boolean canRender = false;
			while (unprocessed >= 1) {
				process();
				canRender = true;
				unprocessed -= 1;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (canRender) {
				render();
				fps++;
			}
			if (System.currentTimeMillis() - lastFPSTime > 1000) {
				lastFPS = fps;
				lastFPSTime = System.currentTimeMillis();
				fps = 0;
			}
		}
	}

	public void start() {
		thread = new Thread(this);
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
	}
	
	public StateManager getStateManager() {
		return stateManager;
	}
	
	public ObjectManager<Sprite> getSprites() {
		return spriteManager;
	}
	
	public ObjectManager<Animation> getAnimations() {
		return animationManager;
	}
	
	public SquireFrame getFrame() {
		return frame;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

}
