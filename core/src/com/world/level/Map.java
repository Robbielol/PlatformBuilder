package com.world.level;

import com.world.objects.WorldObject;

import java.util.ArrayList;

public class Map implements WorldObject{

    private ArrayList<WorldObject> worldObjects;

    public Map(){
        worldObjects = new ArrayList<WorldObject>();
    }

    @Override
    public void onCollision() {
        System.out.println("Map collision method.");
    }
}
