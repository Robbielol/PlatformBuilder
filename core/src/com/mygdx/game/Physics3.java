package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Physics3 extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;

    @Override
    public void create() {
        batch = new SpriteBatch();

        texture = new Texture(Gdx.files.internal("sprites/goomba.gif"));
        sprite = new Sprite(texture);
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }

    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            sprite.setPosition(Gdx.input.getX() - sprite.getWidth()/2,
                    Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);
        }
        if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
            sprite.setPosition(Gdx.graphics.getWidth()/2 -sprite.getWidth()/2,
                    Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
        }
        batch.begin();
        sprite.draw(batch);
        batch.end();
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