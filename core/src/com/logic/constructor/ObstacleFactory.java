package com.Logic.Constructor;

import com.world.obstacle.Obstacle;

public abstract class ObstacleFactory {
    abstract Obstacle getObstacle(String obstacleType);
}
