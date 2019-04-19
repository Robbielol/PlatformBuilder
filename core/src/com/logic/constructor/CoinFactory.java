package com.logic.constructor;

import com.badlogic.gdx.math.Vector2;
import com.world.objects.Coin;
import com.world.objects.CoinBox;
import com.world.objects.WorldObject;

public class CoinFactory extends ObstacleFactory {
    public WorldObject getObject(String obj){
        if (obj.equals("Coin")) return new Coin(new Vector2(100,100));
        else return new CoinBox(new Vector2(100,100));
    }
}
