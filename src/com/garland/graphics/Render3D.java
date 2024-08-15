package com.garland.graphics;

public class Render3D extends Render {

    public Render3D(int width, int height) {
        super(width, height);
    }

    public void floorAndCeiling() {

        for (int y = 100; y < 101; y++) {  // Draw a single horizontal line at y = 100
            for (int x = 0; x < width; x++) {
                pixels[x + y * width] = 0xFF0000; // Red color
            }
        }
        
    }
}
