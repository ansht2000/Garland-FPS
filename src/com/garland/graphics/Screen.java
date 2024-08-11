package com.garland.graphics;

import java.util.Arrays;
import java.util.Random;

public class Screen extends Render {

    private Render test_object;
    private int OBJECT_HEIGHT = 256;
    private int OBJECT_WIDTH = 256;

    public Screen(int width, int height) {
        super(width, height);
        Random random = new Random();
        test_object = new Render(OBJECT_WIDTH, OBJECT_HEIGHT);
        for (int i = 0; i < OBJECT_WIDTH * OBJECT_HEIGHT; i++) {
            test_object.pixels[i] = random.nextInt();
        }
    }

    public void render() {
        Arrays.fill(pixels, 0);

        for (int i = 0; i < 100; i++) {
            int anim_y = (int) (Math.sin((System.currentTimeMillis() + i * 2) % 2000 / 2000.0 * Math.PI * 2) * 200);
            int anim_x = (int) (Math.cos((System.currentTimeMillis() + i * 2) % 2000 / 2000.0 * Math.PI * 2) * 200);
            draw(test_object, (width - 256) / 2 + anim_y, (height - 256) / 2 + anim_x);
        }   
    }
}
