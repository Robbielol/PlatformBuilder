package com.Logic.Constructor;

import com.world.obstacle.Obstacle;
import com.world.obstacle.Square;
import com.world.obstacle.TriangleObstacle;

public class SquareObstacleFactory extends ObstacleFactory{
    public Obstacle getObstacle(String obstacleType){
        if(obstacleType.equals("SQUARE1")){
            return new Square();
        }


        else return null;
    }
}
