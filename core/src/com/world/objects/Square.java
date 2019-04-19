package com.world.objects;

import com.badlogic.gdx.math.Rectangle;

public class Square extends WorldObject {
    public void onCollision(){
        System.out.println("Using Square obstacles draw method");
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
