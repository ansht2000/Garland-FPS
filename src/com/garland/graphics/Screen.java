package com.garland.graphics;

import java.util.Arrays;
import java.util.Random;

import com.garland.Game;

public class Screen extends Render {

    private Render test_object;
    private Render3D test_object3D;
    private int OBJECT_HEIGHT = 256;
    private int OBJECT_WIDTH = 256;

    public Screen(int width, int height) {
        super(width, height);
        Random random = new Random();
        test_object3D = new Render3D(width, height);
        test_object = new Render(OBJECT_WIDTH, OBJECT_HEIGHT);
        for (int i = 0; i < OBJECT_WIDTH * OBJECT_HEIGHT; i++) {
            test_object.pixels[i] = random.nextInt();
        }
    }

    public void render(Game game) {
        Arrays.fill(pixels, 0);

        for (int i = 0; i < 100; i++) {
            int anim_y = (int) (Math.sin((game.time * 5 + i * 2) % 2000 / 2000.0 * Math.PI * 2) * 200);
            int anim_x = (int) (Math.cos((game.time * 5 + i * 2) % 2000 / 2000.0 * Math.PI * 2) * 200);
        }
        test_object3D.floorAndCeiling();
        draw(test_object3D, 0, 0);
    }
}
