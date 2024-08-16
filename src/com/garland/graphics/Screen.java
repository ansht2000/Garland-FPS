package com.garland.graphics;

import java.util.Arrays;

import com.garland.Game;

public class Screen extends Render {

    private Render3D test_object3D;

    public Screen(int width, int height) {
        super(width, height);
        test_object3D = new Render3D(width, height);
    }

    public void render(Game game) {
        Arrays.fill(pixels, 0);
        test_object3D.floorAndCeiling(game);
        test_object3D.limitRenderDistance();
        draw(test_object3D, 0, 0);
    }
}
