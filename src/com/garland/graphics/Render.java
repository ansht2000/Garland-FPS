package com.garland.graphics;

public class Render {
    public int width;
    public int height;
    public int[] pixels;

    public Render(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void draw(Render render, int xOffs, int yOffs) {
        for (int x = 0; x < render.width; ++x) {
            int xPix = x + xOffs;
            if (xPix < 0 ||  xPix >= width) {
                continue;
            }
            for (int y = 0; y < render.height; ++y) {
                int yPix = y + yOffs;
                if (yPix < 0 || yPix >= height) {
                    continue;
                }
                pixels[xPix + yPix * width] = render.pixels[x + y * render.width];
            }
        }
    }
}
