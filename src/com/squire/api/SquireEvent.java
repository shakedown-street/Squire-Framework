package com.squire.api;

/**
 * @author Jordan/shakedown-street
 */
public abstract class SquireEvent implements Runnable {

    // Time between executions
    private int interval;

    // Number of times this event will execute
    private int cycles;

    private boolean running;
    private Thread thread;

    public SquireEvent(int _interval, int _cycles) {
        interval = _interval;
        cycles = _cycles;
        running = true;
    }

    /**
     * Must be called for the event to do anything.
     */
    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        int iterations = 0;
        running = true;
        while (running) {
            try {
                iterations++;
                if (iterations >= cycles) {
                    running = false;
                }
                execute();
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void execute();

    public int getInterval() {
        return interval;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean _running) {
        running = _running;
    }
}
