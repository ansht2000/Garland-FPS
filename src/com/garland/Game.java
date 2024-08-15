package com.garland;

import java.awt.event.KeyEvent;

import com.garland.input.Controller;

public class Game {

    public int time;
    public Controller controls;

    public Game() {
        time = 0;
        controls = new Controller();
    }

    public void tick(boolean[] key) {
        time++;
        boolean forward = key[KeyEvent.VK_W];
        boolean back = key[KeyEvent.VK_S];
        boolean right = key[KeyEvent.VK_D];
        boolean left = key[KeyEvent.VK_A];
        boolean turnRight = key[KeyEvent.VK_LEFT];
        boolean turnLeft = key[KeyEvent.VK_RIGHT];

        controls.tick(forward, back, right, left, turnRight, turnLeft);
    }

}
