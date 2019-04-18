package com.logic.command;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


public class MoveLeftOnCommand implements Command {
    private final Vector2 position = new Vector2();
    private TextureRegion player;

    public MoveLeftOnCommand(TextureRegion player)
    {
        this.player = player;
    }

    public void executeMovement(float pos, boolean orientation)
    {
        position.x = (pos-5);
        player.flip(orientation,false);
        player.flip(false,false);
    }

    @Override
    public void setPlayer(TextureRegion player)
    {
        this.player = player;
    }

    @Override
    public void getOrientation(Boolean orientation)
    {

    }

    public float getPosition(){
        return position.x;
    }
}
