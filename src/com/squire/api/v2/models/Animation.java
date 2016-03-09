package com.squire.api.v2.models;

import java.awt.Graphics;
import java.util.LinkedList;

import org.json.simple.JSONArray;

import com.squire.api.v2.services.FrameService;

import jprice.rest.APIConnection;
import jprice.rest.DataModel;
import jprice.rest.Response;

/**
 * @author Jordan/shakedown-street
 */
@SuppressWarnings("serial")
public class Animation extends DataModel {

	private int frame;
	private long cycles;
	private long delay;
	private LinkedList<AnimationFrame> frameSet;

	private boolean running;
	private boolean looping;
	
	public Animation(Response _res) {
		super(_res);
		APIConnection connection = new APIConnection("http://127.0.0.1:8000", "?format=json", 5000);
		FrameService frames = new FrameService(connection);
		
		frame = 0;
		delay = (long) get("delay");
		cycles = delay;
		frameSet = new LinkedList<AnimationFrame>();
		
		JSONArray frameObjs = (JSONArray) get("frame_set");
		while(frameObjs.iterator().hasNext()) {
			frameSet.add(new AnimationFrame(frames.retrieve((int) ((long) frameObjs.iterator().next()))));
		}
		looping = (boolean) get("loop");
		
		running = false;
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
		AnimationFrame f = frameSet.get(frame);
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

	public LinkedList<AnimationFrame> getFrameSet() {
		return frameSet;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean isLooping() {
		return looping;
	}
}
