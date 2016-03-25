package com.squire.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.squire.api.state.StateHandler;

/**
 * Squire is an open source game framework.  Use it however you'd like to.
 *
 * Quick Start
 *
 * Step 1: If not already done, compile Squire into a Jar file
 *         and add it to your build path.
 *
 * Step 2:
 *
 * Step 3:
 *
 * State state = new State(this) {
 *
 *     @Override init() {
 *         // This will execute when the
 *     }
 *     @Override process() {
 *
 *     }
 *     @Override render(Graphics g) {
 *
 *     }
 *     @Override endHook() {
 *
 *     }
 * };
 * getStateHandler().setState(state);
 *
 * @author Jordan/shakedown-street
 */
@SuppressWarnings("serial")
public abstract class SquireGame extends Canvas implements Runnable {

    private Thread thread;
    public int lastFPS = 0;
    private final static int MAX_FPS = 60;
    private final static int BUFFERS = 2;

    private SquireFrame frame;
    private int width, height;

    private StateHandler stateHandler;

    public SquireGame(int _width, int _height) {
        width = _width;
        height = _height;
        setFocusable(true);

        setMinimumSize(new Dimension(_width, _height));
        setMaximumSize(new Dimension(_width, _height));
        setSize(new Dimension(_width, _height));
        load();
    }

    private void load() {
        stateHandler = new StateHandler();
        frame = new SquireFrame(this);
    }

    public abstract void init();

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(BUFFERS);
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        stateHandler.render(g);

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
                stateHandler.process();
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

    public void refreshInputMethods() {
        addKeyListener(stateHandler.getState().getKeys());
        addMouseListener(stateHandler.getState().getMouse());
        addMouseMotionListener(stateHandler.getState().getMouse());
    }

    public StateHandler getStateHandler() {
        return stateHandler;
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
