package com.garland.input;

public class Controller {

    public double x, z, rotation, xa, za, rotationa;

    public Controller() {
        x = 0;
        z = 0;
        rotation = 0;
        xa = 0;
        za = 0;
        rotationa = 0;
    }
    public void tick(boolean forward, boolean back, boolean right, boolean left, boolean turnRight, boolean turnLeft) {
        double rotationSpeed = .001;
        double walkSpeed = .1;
        double xMove = 0;
        double zMove = 0;

        if (forward) {
            zMove++;
        }
        if (back) {
            zMove--;
        }
        if (left) {
            xMove--;
        }
        if (right) {
            xMove++;
        }
        if (turnLeft) {
            rotationa += rotationSpeed;
        }
        if (turnRight) {
            rotationa -= rotationSpeed;
        }

        xa += (xMove * Math.cos(rotation) + zMove * Math.sin(rotation)) * walkSpeed;
        za += (zMove * Math.cos(rotation) - xMove * Math.sin(rotation)) * walkSpeed;

        x += xa;
        z += za;
        xa *= 0.1;
        za *= 0.1;
        rotation += rotationa;
        rotationa *= .8;

    }
}
