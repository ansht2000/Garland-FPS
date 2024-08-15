package com.garland.graphics;

public class Render3D extends Render {

    public Render3D(int width, int height) {
        super(width, height);
    }

    public void floorAndCeiling() {

        double yDepth = 0;
        double z = 0;
        double xDepth = 0;

        int xPix = 0;

        for (int y = 0; y < height; y++) {
            yDepth = y - height / 2;
            z = 100.0 / yDepth;

            for (int x = 0; x < width; x++) {
                xDepth = x - width / 2;
                xDepth *= z;
                xPix = (int) (xDepth) & 15;
                pixels[x + y * width] = xPix * 128;
            }
        }
    }
}
