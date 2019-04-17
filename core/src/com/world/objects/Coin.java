package com.world.objects;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.Random;

public class Coin extends Image implements WorldObject, ScoreObject {

    private int score;

    public Coin(){
        super(new Texture(Gdx.files.internal("")));

        Random rand = new Random();
        // Random score value between 1 and 50
        score = rand.nextInt(50)+1;
    }

    @Override
    public void onCollision() {

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
    public int getScore() {
        return score;
    }

}
