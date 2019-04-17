package com.Logic.Constructor;

import com.world.obstacle.WorldObject;
import com.world.obstacle.Square;

public class SquareObstacleFactory extends ObstacleFactory{
    public WorldObject getObstacle(String obstacleType){
        if(obstacleType.equals("SQUARE1")){
            return new Square();
        }


        else return null;
    }
}
