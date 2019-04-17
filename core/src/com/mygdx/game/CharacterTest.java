package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.logic.constructor.common.Movements;
import com.logic.strategy.Context;
import com.logic.strategy.JumpHigher;
import com.logic.strategy.MoveFaster;


public class CharacterTest extends ApplicationAdapter {

    private boolean pressOnce = false;
    private SpriteBatch batch;
    private Texture background;
    private TextureRegion enemy;
    private Movements moveTest;

    @Override
    public void create () {
        batch = new SpriteBatch();
        background = new Texture("glassy/raw/white.png");

        TextureRegion player = new TextureRegion(new Texture("sprites/CharSprite.png"));
        enemy = new TextureRegion(new Texture("sprites/goomba.gif"));
        moveTest = new Movements(player);
        Sprite sprite = new Sprite(new Texture("sprites/goomba.gif"));
    }

    @Override
    public void render () {
        float scaleFactor = (float) 0.25;

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.W) && !moveTest.isJumping()) {
            moveTest.jump();
            pressOnce = false;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveTest.moveRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            moveTest.moveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) && !pressOnce) {
            pressOnce = true;
            Context context = new Context(new JumpHigher());
            //moveTest.setGravity(context.executeStrategy(moveTest.getGravity()));
            moveTest.setPowerUpUsed(false);
        }

//        if (Gdx.input.isKeyPressed(Input.Keys.S)){
//            Context context = new Context(new JumpHigher());
//        }


        moveTest.update();

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(moveTest.getPlayer(), moveTest.getPosition().x, moveTest.getPosition().y, moveTest.getPlayer().getRegionWidth() * scaleFactor, moveTest.getPlayer().getRegionHeight() * scaleFactor);
        batch.draw(enemy, 300, 0, enemy.getRegionWidth() * scaleFactor, enemy.getRegionHeight() * scaleFactor);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        background.dispose();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

}


