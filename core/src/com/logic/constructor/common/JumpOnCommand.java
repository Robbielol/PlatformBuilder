package com.logic.constructor.common;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.logic.constructor.common.Command;
import com.mygdx.game.CharacterTest;

public class JumpOnCommand implements Command {
    private float GRAVITY = -1000;
    private final Vector2 velocity = new Vector2();
    private final Vector2 acceleration = new Vector2();
    private final Vector2 position = new Vector2();
    private Movements move;
    private Boolean isJumping = false;
    private TextureRegion player;

    public JumpOnCommand(TextureRegion player)
    {
        this.player = player;
    }

    public void executeMovement(float pos, boolean orientation)
    {
        player.setTexture(new Texture("sprites/Jumping.png"));
        velocity.y = 500;
        isJumping = true;
    }

    @Override
    public void setPlayer(TextureRegion player)
    {
        this.player = player;
    }

    @Override
    public void getOrientation(Boolean isJumping)
    {
        this.isJumping = isJumping;
    }

    public float getVelocity()
    {
        return velocity.y;
    }
}
