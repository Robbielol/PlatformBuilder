package com.Logic.Constructor;

import com.world.objects.WorldObject;

public abstract class ObstacleFactory {
    abstract WorldObject getObstacle(String obstacleType);
}
