package com.world.objects;

import com.badlogic.gdx.math.Rectangle;

public interface WorldObject {
    void onCollision();
    boolean collidesWith(WorldObject obj);
    Rectangle getBounds();
}
