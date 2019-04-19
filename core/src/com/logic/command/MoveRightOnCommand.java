package com.logic.command;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MoveRightOnCommand implements Command
{
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle bounds;

    public MoveRightOnCommand(Vector2 playerPos, Rectangle playerBounds)
    {
        position = playerPos;
        bounds = playerBounds;
    }

    public void executeMovement(float pos, boolean orientation)
    {
        position.x = pos+5;
        bounds.x = pos+5;
    }

    @Override
    public float getPosition(){
        return position.x;
    }

    @Override
    public float getPlayerBounds(){return bounds.x; }

    @Override
    public Vector2 getVelocity(){
        return velocity;
    }
}