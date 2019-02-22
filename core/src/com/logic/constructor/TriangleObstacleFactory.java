package com.Logic.Constructor;

import com.world.obstacle.Obstacle;
import com.world.obstacle.TriangleObstacle;

public class TriangleObstacleFactory extends ObstacleFactory  {
    public Obstacle getObstacle(String obstacleType){
        if(obstacleType.equals("TRIANGLEOBSTACLE")){
            return new TriangleObstacle();
        }


        else return null;
    }
}
