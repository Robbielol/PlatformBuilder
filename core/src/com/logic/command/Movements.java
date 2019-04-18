package com.logic.command;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.world.player.Player;

public class Movements {

    private boolean isJumping = false;
    private boolean orientation = true;

    private boolean powerUpUsed = true;

    private float gravity = -1000;

    private Vector2 position;

    private Vector2 velocity;

    private Vector2 acceleration;
    private MoveRightOnCommand moveRight;
    private MoveLeftOnCommand moveLeft;
    private JumpOnCommand jump;
    private Player playerObject;
    private TextureRegion player;

    public Movements(TextureRegion player)
    {
        this.player = player;
        position = new Vector2();
        velocity = new Vector2();
        moveRight = new MoveRightOnCommand(player);
        moveLeft = new MoveLeftOnCommand(player);
        jump = new JumpOnCommand(player);
        float gravity = -1000;
        acceleration = new Vector2(0, gravity);
    }


    public void update()
    {
        float dt = Gdx.graphics.getDeltaTime();
        velocity.add(acceleration.x * dt, acceleration.y * dt);
        position.add(velocity.x * dt, velocity.y * dt);

        if (position.y <= 0){ // hit ground, so bounce
            position.y = 0;
            isJumping = false;
            player.setTexture(new Texture("sprites/CharSprite.png"));
            if(powerUpUsed){
                jump.setJumpHeight(500);
            }
        }
        if ((position.x <= 0)){
            position.x = 0;
        }
        if (position.x >= Gdx.graphics.getWidth() - player.getRegionWidth()/2){
            position.x = Gdx.graphics.getWidth() - player.getRegionWidth()/2;
        }

    }

    public void jump() {
        jump.executeMovement(position.x, orientation);
        velocity.y = jump.getVelocity();
        isJumping = true;
        powerUpUsed = true;
    }

    public void moveRight()
    {
        moveRight.executeMovement(position.x, orientation);
        orientation = true;
        position.x = moveRight.getPosition();
    }

    public void moveLeft() {
        moveLeft.executeMovement(position.x, orientation);
        orientation = false;
        position.x = moveLeft.getPosition();
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

    public void increaseJumpHeight(float jumpHeight) {
        jump.setJumpHeight(jumpHeight);
    }

    public float getGravity() {
        return gravity;
    }

    public float getJumpHeight(){
        return jump.getJumpHeight();
    }

    public void setPowerUpUsed(boolean powerUpUsed) {
        this.powerUpUsed = powerUpUsed;
    }
}
