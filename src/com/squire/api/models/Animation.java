package com.squire.api.models;

import java.awt.*;
import java.util.LinkedList;

/**
 * @author Jordan/shakedown-street
 */
@SuppressWarnings("serial")
public class Animation implements Runnable {

    private int frame;
    private long delay;
    private boolean running;
    private boolean looping;
    private LinkedList<Sprite> frames;
    private Thread thread;

    public Animation() {
        frame = -1;
        delay = 0;
        frames = new LinkedList<>();
        running = false;
        looping = false;
    }

    public Animation(Sprite[] _sprites, int _delay) {
        this();
        delay = _delay;
        for (Sprite s : _sprites) {
            frames.add(s);
        }
    }

    public void start(boolean _loop) {
        restart();
        looping = _loop;
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

    public void render(Graphics g, int x, int y) {
        Sprite sprite = frames.get(frame);
        sprite.render(g, x, y);
    }

    @Override
    public void run() {
        while (running) {

            frame++;

            if (frame > frames.size() - 1) {
                if (looping) {
                    restart();
                } else {
                    stop();
                }
            }

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
