package com.Logic.Constructor;

import com.world.obstacle.WorldObject;

public abstract class ObstacleFactory {
    abstract WorldObject getObstacle(String obstacleType);
}
