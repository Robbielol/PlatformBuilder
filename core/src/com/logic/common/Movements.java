package com.logic.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Movements {

    private float gravity = -1000;

    private boolean isJumping;
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    public Movements() {

        position = new Vector2();
        velocity = new Vector2();
        acceleration = new Vector2(0, gravity);

    }

    void update(){
        float dt = Gdx.graphics.getDeltaTime();
        velocity.add(acceleration.x * dt, acceleration.y * dt);
        position.add(velocity.x * dt, velocity.y * dt);

        if (position.y <= 0){ // hit ground, so bounce
            position.y = 0;
            isJumping = false;
        }
        if ((position.x <= 0)){
            position.x = 0;
        }
//        else if (position.x >= Gdx.graphics.getWidth() - texture.getRegionWidth()/2){
//            position.x = Gdx.graphics.getWidth() - texture.getRegionWidth()/2;
//        }
    }

    private void jump(){
        velocity.y = 500;
        isJumping = true;
    }

    private void moveRight() {
        position.x += 5;
    }

    private void moveLeft() {
        position.x += -5;
    }
}
