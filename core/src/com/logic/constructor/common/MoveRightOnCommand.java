package com.logic.constructor.common;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.logic.constructor.common.Command;

public class MoveRightOnCommand implements Command
{

    private final Vector2 velocity = new Vector2();
    private final Vector2 acceleration = new Vector2();
    private final Vector2 position = new Vector2();
    private TextureRegion player;

    public MoveRightOnCommand(TextureRegion player)
    {
        this.player = player;
    }

    public void executeMovement(float pos, boolean orientation)
    {
        position.x = pos + 5;
        player.flip(orientation,false);
        player.flip(true,false);
    }

    public void setPlayer(TextureRegion player)
    {
        this.player = player;
    }


    public void getOrientation(Boolean orientation) {
    }

    public float getPosition(){
        return position.x;
    }
}
