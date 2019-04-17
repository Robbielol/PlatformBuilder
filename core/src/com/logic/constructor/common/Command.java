package com.logic.constructor.common;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface Command {
    void executeMovement(float pos, boolean bool);
    void setPlayer(TextureRegion player);
    void getOrientation(Boolean orientation);
}
