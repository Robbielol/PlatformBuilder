package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.logic.common.Movements;

public class CharacterTest extends ApplicationAdapter {
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
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // don't forget to clear screen

        if (Gdx.input.isKeyPressed(Input.Keys.W) && !moveTest.isJumping()) {
            moveTest.jump();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveTest.moveRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            moveTest.moveLeft();
        }

//        if (Gdx.input.isKeyPressed(Input.Keys.S)){
//            Context context = new Context(new JumpHigher());
//        }

        moveTest.update();

        batch.begin();
        float scaleFactor = (float) 0.25;
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


