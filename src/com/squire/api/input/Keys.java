package com.squire.api.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import com.squire.api.input.KeyAction.Type;

public class Keys implements KeyListener {

    private ArrayList<KeyAction> actions = new ArrayList<KeyAction>();

    @Override
    public void keyPressed(KeyEvent e) {
        for (KeyAction action : actions) {
            if (e.getKeyCode() == action.getKey()) {
                if (action.getType() == Type.PRESSED)
                    action.act();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (KeyAction action : actions) {
            if (e.getKeyCode() == action.getKey()) {
                if (action.getType() == Type.RELEASED)
                    action.act();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        for (KeyAction action : actions) {
            if (e.getKeyCode() == action.getKey()) {
                if (action.getType() == Type.TYPED)
                    action.act();
            }
        }
    }

    public void addAction(KeyAction... _actions) {
        for (KeyAction a : _actions) {
            actions.add(a);
        }
    }

}
