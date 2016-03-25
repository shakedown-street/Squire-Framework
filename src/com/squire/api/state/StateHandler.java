package com.squire.api.state;

import java.awt.Graphics;

/**
 * @author Jordan/shakedown-street
 */
public class StateHandler {

    private State state;

    public boolean isValidState() {
        return state != null && !state.hasEnded();
    }

    public void process() {
        if (isValidState()) {
            try {
                state.process();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid state");
        }
    }

    public void render(Graphics g) {
        if (isValidState()) {
            try {
                state.render(g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid State");
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State _state) {
        if (_state == null) {
            return;
        }
        state = _state;
        state.init();
        state.getGame().refreshInputMethods();
    }

}
