package com.squire.api.models;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * @author Jordan/shakedown-street
 */
public class Animation {

	private int frame;
	private LinkedList<Frame> frameSet;

	private boolean running;
	private boolean looping;

	private long lastUpdate;

	private Animation() {
		frame = -1;
		frameSet = new LinkedList<Frame>();
		running = false;
		looping = false;
	}

	public Animation(Sprite[] sprites, int[] delayTimes) {
		this();
		for (int i = 0; i < sprites.length; i++) {
			frameSet.add(new Frame(sprites[i], delayTimes[i]));
		}
	}

	public Animation(Sprite[] sprites, int delay) {
		this();
		for (int i = 0; i < sprites.length; i++) {
			frameSet.add(new Frame(sprites[i], delay));
		}
	}

	public Animation addFrame(Sprite sprite, int delay) {
		frameSet.add(new Frame(sprite, delay));
		return this;
	}

	public void render(Graphics g, int x, int y) {
		update();
		Frame f = frameSet.get(frame);
		f.getSprite().render(g, x, y);
	}

	public void update() {
		if (!running) {
			start();
		}

		if (running) {
			Frame f = frameSet.get(frame);

			int delay = (int) ((float) f.getTime() * 1f);

			if (System.currentTimeMillis() - lastUpdate > delay) {
				frame++;

				if (frame > frameSet.size() - 1) {
					if (looping) {
						frame = 0;
					} else {
						frame = frameSet.size() - 1;
						running = false;
					}
				}
				lastUpdate = System.currentTimeMillis();
			}
		}
	}

	public void start() {
		if (!running) {
			restart();
		}
	}

	public void restart() {
		frame = 0;
		lastUpdate = System.currentTimeMillis();
		running = true;
	}

	public void stop() {
		if (running) {
			lastUpdate = System.currentTimeMillis();
		}
	}

	public int getFrame() {
		return frame;
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
