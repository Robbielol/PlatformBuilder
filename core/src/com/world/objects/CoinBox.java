package com.world.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public class CoinBox extends Image implements WorldObject, ScoreObject{

    private ArrayList<Coin> coins;

    public CoinBox(){

        coins = new ArrayList<Coin>();
        Coin c;
        for(int x = 0; x < 10; x++){
            c = new Coin();
            coins.add(c);
        }
    }

    @Override
    public void onCollision(){
        System.out.println("Collision with score box");
    }

    @Override
    public boolean collidesWith(WorldObject obj) {
        return false;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public int getScore(){
        int totalBoxScore = 0;
        for(Coin c : coins){
            totalBoxScore += c.getScore();
        }
        return totalBoxScore;
    }

}
