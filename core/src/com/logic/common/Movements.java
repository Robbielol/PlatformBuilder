package com.logic.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Movements {

    private boolean isJumping = false;
    private boolean orientation = true;
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private TextureRegion player;

    public Movements(TextureRegion player) {
        this.player = player;
        position = new Vector2();
        velocity = new Vector2();
        float gravity = -1000;
        acceleration = new Vector2(0, gravity);
    }

    public void update(){
        float dt = Gdx.graphics.getDeltaTime();
        velocity.add(acceleration.x * dt, acceleration.y * dt);
        position.add(velocity.x * dt, velocity.y * dt);

        if (position.y <= 0){ // hit ground, so bounce
            position.y = 0;
            isJumping = false;
            player.setTexture(new Texture("sprites/CharSprite.png"));
        }
        if ((position.x <= 0)){
            position.x = 0;
        }
        if (position.x >= Gdx.graphics.getWidth() - player.getRegionWidth()/2){
            position.x = Gdx.graphics.getWidth() - player.getRegionWidth()/2;
        }

    }

    public void jump(){
        player.setTexture(new Texture("sprites/Jumping.png"));
        velocity.y = 500;
        isJumping = true;
    }

    public void moveRight() {
        position.x += 5;
        player.flip(orientation,false);
        orientation = true;
        player.flip(true,false);
    }

    public void moveLeft() {
        position.x += -5;
        player.flip(orientation,false);
        orientation = false;
        player.flip(false,false);
    }

    public TextureRegion getPlayer() {
        return player;
    }

    public Vector2 getPosition() {
        return position;
    }

    public boolean isJumping() {
        return isJumping;
    }
}
