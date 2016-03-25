package test;

import com.squire.api.SquireGame;
import com.squire.api.state.State;
import com.squire.api.models.Sprite;

import java.awt.*;

public class Game extends SquireGame {

    public static void main(String[] args) {
        new Game(800, 640).start();
    }

    public Game(int _w, int _h) {
        super(_w, _h);
    }

    @Override
    public void init() {
        State start = new State(this) {

            @Override
            public void init() {
            }

            @Override
            public void process() {

            }

            @Override
            public void render(Graphics g) {

            }

            @Override
            public void endHook() {

            }
        };

        getStateHandler().setState(start);
    }

}
