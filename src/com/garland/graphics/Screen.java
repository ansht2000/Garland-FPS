package com.garland.graphics;

import java.util.Arrays;
import java.util.Random;

public class Screen extends Render {

    private Render test;

    public Screen(int width, int height) {
        super(width, height);
        Random random = new Random();
        test = new Render(256, 256);
        for (int i = 0; i < 256 * 256; i++) {
            test.pixels[i] = random.nextInt();
        }
    }

    public void render() {
        Arrays.fill(pixels, 0);

        for (int i = 0; i < 100; i++) {
            int anim_y = (int) (Math.sin((System.currentTimeMillis() + i) % 2000 / 2000.0 * Math.PI * 2) * 200);
            int anim_x = (int) (Math.cos((System.currentTimeMillis() + i) % 2000 / 2000.0 * Math.PI * 2) * 200);
            draw(test, (width - 256) / 2 + anim_y, (height - 256) / 2 + anim_x);
        }   
    }
}
