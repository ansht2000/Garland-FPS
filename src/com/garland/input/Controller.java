package com.garland.input;

public class Controller {

    public double x, z, rotation, deltaX, deltaZ, deltaR;

    public Controller() {
        x = 0;
        z = 0;
        rotation = 0;
        deltaX = 0;
        deltaZ = 0;
        deltaR = 0;
    }
    public void tick(boolean forward, boolean back, boolean right, boolean left, boolean turnRight, boolean turnLeft) {
        double rotationSpeed = .005;
        double walkSpeed = .2;
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
            deltaR -= rotationSpeed;
        }
        if (turnRight) {
            deltaR += rotationSpeed;
        }

        if (Math.abs(xMove) > 0 && Math.abs(zMove) > 0) {
            // walkSpeed *= (Math.sqrt(2) / 2);
            walkSpeed /= 2;
        }

        deltaX += (xMove * Math.cos(rotation) + zMove * Math.sin(rotation)) * walkSpeed;
        deltaZ += (zMove * Math.cos(rotation) - xMove * Math.sin(rotation)) * walkSpeed;

        x += deltaX;
        z += deltaZ;
        rotation += deltaR;
        deltaX *= 0.5;
        deltaZ *= 0.5;
        deltaR *= .9;
        deltaR = 0;

    }
}
