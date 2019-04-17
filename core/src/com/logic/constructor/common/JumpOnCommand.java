package com.logic.constructor.common;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.logic.constructor.common.Command;
import com.mygdx.game.CharacterTest;

public class JumpOnCommand implements Command {

    private final Vector2 velocity = new Vector2();

    private float jumpHeight = 500;

    private TextureRegion player;

    public JumpOnCommand(TextureRegion player)
    {
        this.player = player;
    }
    public void executeMovement(float pos, boolean orientation)
    {
        player.setTexture(new Texture("sprites/Jumping.png"));
        velocity.y = jumpHeight;
    }

    @Override
    public void setPlayer(TextureRegion player)
    {
        this.player = player;
    }

    @Override
    public void getOrientation(Boolean isJumping)
    {
    }

    public float getVelocity()
    {
        return velocity.y;
    }

    public void setJumpHeight(float jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public float getJumpHeight() {
        return jumpHeight;
    }
}
