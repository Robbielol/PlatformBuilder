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
import com.logic.common.Movements;
import com.logic.strategy.Context;
import com.logic.strategy.JumpHigher;
import com.logic.strategy.MoveFaster;

public class CharacterTest extends ApplicationAdapter {


    private boolean pressOnce = false;
    private SpriteBatch batch;
    private Texture background;
    private TextureRegion enemy;
    private Movements movements;

    @Override
    public void create () {
        batch = new SpriteBatch();
        background = new Texture("glassy/raw/white.png");

        TextureRegion player = new TextureRegion(new Texture("sprites/CharSprite.png"));
        enemy = new TextureRegion(new Texture("sprites/goomba.gif"));
        movements = new Movements(player);
        Sprite sprite = new Sprite(new Texture("sprites/goomba.gif"));
    }

    @Override
    public void render () {
        float scaleFactor = (float) 0.25;

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.W) && !movements.isJumping()) {
            movements.jump();
            pressOnce = false;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            movements.moveRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            movements.moveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) && !pressOnce) {
            pressOnce = true;
            Context context = new Context(new JumpHigher());
            movements.setGravity(context.executeStrategy(movements.getGravity()));
            movements.setPowerUpUsed(false);
        }



        movements.update();

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(movements.getPlayer(), movements.getPosition().x, movements.getPosition().y, movements.getPlayer().getRegionWidth() * scaleFactor, movements.getPlayer().getRegionHeight() * scaleFactor);
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


