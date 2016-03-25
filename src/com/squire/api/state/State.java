package com.squire.api.state;

import java.awt.Graphics;

import com.squire.api.SquireGame;
import com.squire.api.input.Keys;
import com.squire.api.input.Mouse;

/**
 * @author Jordan/shakedown-street
 */
public abstract class State {

    private SquireGame game;
    private boolean ended;

    private Keys keyInput;
    private Mouse mouseInput;

    public State(SquireGame _game) {
        game = _game;
        ended = false;

        keyInput = new Keys();
        mouseInput = new Mouse();
    }

    public abstract void init();

    public abstract void process();

    public abstract void render(Graphics g);

    public abstract void endHook();

    public void stop() {
        this.ended = true;
        this.endHook();
    }

    public SquireGame getGame() {
        return game;
    }

    public boolean hasEnded() {
        return ended;
    }

    public Keys getKeys() {
        return keyInput;
    }

    public Mouse getMouse() {
        return mouseInput;
    }

}
