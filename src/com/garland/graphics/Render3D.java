package com.garland.graphics;

import java.util.Arrays;

import com.garland.Game;

public class Render3D extends Render {

    public double[] zBuffer;
    private int renderDistance = 5000;

    public Render3D(int width, int height) {
        super(width, height);
        zBuffer = new double[width * height];
        Arrays.fill(zBuffer, 0);
    }

    public void floorAndCeiling(Game game) {

        int floorPosition = 8;
        int ceilingPosition = 8;

        double rotation = game.controls.rotation;
        double cos = Math.cos(rotation);
        double sin = Math.sin(rotation);
        double forward = game.controls.z;
        double right = game.controls.x;

        double xDepth, yDepth, z = 0;
        int xPix, yPix = 0;

        for (int y = 0; y < height; y++) {

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
                zBuffer[x + y* width] = z;
                pixels[x + y * width] = (xPix * 16) | (yPix * 16) << 8;
            }
        }
        
    }

    public void limitRenderDistance() {
        int color, brightness, r, g, b = 0;

        for (int i = 0; i < width * height; i++) {
            color = pixels[i];
            brightness = (int) (renderDistance / zBuffer[i]);

            if (brightness < 0) {
                brightness = 0;
            }
            if (brightness > 255) {
                brightness = 255;
            }

            r = (color >> 16) & 0xff;
            g = (color >> 8) & 0xff;;
            b = color & 0xff;
            r = r * brightness >>> 8;
            g = g * brightness >>> 8;
            b = b * brightness >>> 8;

            pixels[i] = r << 16 | g << 8 | b;
        }
    }
}
