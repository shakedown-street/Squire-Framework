package com.squire.api.models;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

import org.json.simple.JSONArray;

import com.squire.api.services.SpriteService;

import jprice.rest.APIConnection;
import jprice.rest.DataModel;
import jprice.rest.Response;

/**
 * @author Jordan/shakedown-street
 */
@SuppressWarnings("serial")
public class Animation extends DataModel implements Runnable {

	private int frame;
	private long delay;
	private boolean running;
	private boolean looping;
	private LinkedList<Sprite> frames;
	private Thread thread;

	public Animation(Response _res) {
		super(_res);
		frame = 0;
		delay = (long) get("delay");
		frames = new LinkedList<Sprite>();

		APIConnection connection = new APIConnection("http://127.0.0.1:8000", "?format=json", 5000);
		SpriteService sprites = new SpriteService(connection);
		JSONArray frameObjs = (JSONArray) get("frame_set");
		Iterator iterator = frameObjs.iterator();
		while (iterator.hasNext()) {
			frames.add(new Sprite(sprites.retrieve((int) ((long) iterator.next()))));
		}
		looping = (boolean) get("loop");

		running = false;
	}

	public void start() {
		restart();
		thread = new Thread(this);
		thread.start();
	}

	public void restart() {
		frame = 0;
		running = true;
	}

	public void stop() {
		frame = frames.size() - 1;
		running = false;
	}

	public void incrementFrame() {
		frame++;
	}

	public void render(Graphics g, int x, int y) {
		Sprite sprite = frames.get(frame);
		sprite.render(g, x, y);
	}

	@Override
	public void run() {
		while (running) {

			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			incrementFrame();

			if (getFrame() > getFrames().size() - 1) {
				if (looping) {
					restart();
				} else {
					stop();
				}
			}
		}
	}

	public int getFrame() {
		return frame;
	}

	public LinkedList<Sprite> getFrames() {
		return frames;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean isLooping() {
		return looping;
	}
}
