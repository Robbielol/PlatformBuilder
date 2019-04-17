package com.world.objects;

import com.badlogic.gdx.math.Rectangle;

public class TriangleObstacle implements WorldObject {
    public void onCollision(){
        System.out.println("Using Triangle objects draw method");
    }

    @Override
    public boolean collidesWith(WorldObject obj) {
        return false;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
