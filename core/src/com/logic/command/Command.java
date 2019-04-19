package com.logic.command;


import com.badlogic.gdx.math.Vector2;

public interface Command {
    void executeMovement(float pos, boolean bool);
    float getPosition();
    float getPlayerBounds();
    Vector2 getVelocity();
}
