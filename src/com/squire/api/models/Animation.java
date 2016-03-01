package com.squire.api.models;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * @author Jordan/shakedown-street
 */
public class Animation {

	private int frame;
	private int cycles;
	private int delay;
	private LinkedList<Frame> frameSet;

	private boolean running;
	private boolean looping;

	private Animation() {
		frame = 0;
		delay = 0;
		frameSet = new LinkedList<Frame>();
		running = false;
		looping = false;
	}

	public Animation(Sprite[] sprites, int delay) {
		this();
		this.delay = delay;
		this.cycles = delay;
		for (int i = 0; i < sprites.length; i++) {
			frameSet.add(new Frame(sprites[i], delay));
		}
	}

	public Animation addFrame(Sprite sprite) {
		frameSet.add(new Frame(sprite, delay));
		return this;
	}

	public boolean shouldIncrement() {
		cycles--;
		if (running && cycles == 0) {
			cycles = delay;
			return true;
		}
		return false;
	}

	public void render(Graphics g, int x, int y) {
		Frame f = frameSet.get(frame);
		f.getSprite().render(g, x, y);
	}

	public void start(boolean loop) {
		looping = loop;
		if (!running) {
			restart();
		}
	}

	public void restart() {
		frame = 0;
		running = true;
	}

	public void stop() {
		if (running) {
			frame = frameSet.size() - 1;
			running = false;
		}
	}

	public int getFrame() {
		return frame;
	}

	public void incrementFrame() {
		frame++;
	}

	public LinkedList<Frame> getFrameSet() {
		return frameSet;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean isLooping() {
		return looping;
	}
}
