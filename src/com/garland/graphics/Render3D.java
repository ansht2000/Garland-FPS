package com.garland.graphics;

import com.garland.Game;

public class Render3D extends Render {

    public Render3D(int width, int height) {
        super(width, height);
    }

    public void floorAndCeiling(Game game) {

        int floorPosition = 8;
        int ceilingPosition = 8;
        int renderDistance = 30;

        double rotation = game.controls.rotation;
        double cos = Math.cos(rotation);
        double sin = Math.sin(rotation);
        double forward = game.controls.z;
        double right = game.controls.x;

        double xDepth, yDepth, z = 0;
        int xPix, yPix = 0;

        for (int y = 0; y < height; y++) {

            if (y <= (height / 2) + renderDistance && y >= (height / 2) - renderDistance) {
                continue;
            }

            yDepth = (y - height / 2.0) / height;
            z = floorPosition / yDepth;

            if (yDepth < 0) {
                z = ceilingPosition / -yDepth;
            }

            for (int x = 0; x < width; x++) {
                xDepth = (x - width / 2.0) / width;
                xDepth *= z;
                xPix = (int) (xDepth * cos + z * sin + right) & 15;
                yPix = (int) (z * cos - xDepth * sin + forward) & 15;
                pixels[x + y * width] = (xPix * 16) | (yPix * 16) << 8;
            }
        }
        
    }
}
