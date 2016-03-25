# Squire-Framework
Takes care of some of the common tasks of a 2D game so you can just focus on writing your game.

### Engine Features
* Canvas based rendering
* Modular design through game states
* Sprite and Spritesheet support
* Multi-threaded event system
* Multi-threaded animation support
* Keyboard input
* Plenty coming in the next few weeks

### Features In Development
* Mouse input
* A music system
* A solid rendering system
* User interface

### Quick Start
Squire is based around simplicity.  In a few simple steps Squire can take care of many of
the common tasks that most 2D games will need.

* Step One: If not already done, compile Squire into a Jar file and add it to your build path.
* Step Two: Create a new class that extends SquireGame and override init()
* Step Three: Create a new State in the init() method
* Step Four: Set the state with getStateHandler().setState(__state_name__);
* Step Five: Create a new instance of your game class and call .start() on it

#### At this point now, you should be able to start developing your game.

```java
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
```
