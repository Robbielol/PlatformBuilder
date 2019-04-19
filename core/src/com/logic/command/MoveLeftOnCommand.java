package com.logic.command;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class MoveLeftOnCommand implements Command {
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle bounds;

    public MoveLeftOnCommand(Vector2 playerPos, Rectangle playerBounds)
    {
        this.position = playerPos;
        bounds = playerBounds;
    }

    public void executeMovement(float pos, boolean orientation)
    {
        position.x = (pos-5);
    }

    @Override
    public float getPosition(){
        return position.x;
    }

    @Override
    public float getPlayerBounds(){return bounds.x; }

    @Override
    public Vector2 getVelocity() {
        return velocity;
    }
}
