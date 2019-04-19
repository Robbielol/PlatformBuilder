package com.world.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class WorldObject extends Image{
    abstract void onCollision();
    abstract boolean collidesWith(WorldObject obj);
    abstract Rectangle getBounds();
}
