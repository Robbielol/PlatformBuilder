package com.logic.constructor;

import com.world.objects.WorldObject;

public abstract class ObstacleFactory {
    abstract WorldObject getObject(String obj);

}
