package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.logic.strategy.Context;
import com.logic.strategy.JumpHigher;

public class CharacterTest extends ApplicationAdapter{
    private SpriteBatch batch;
    private Texture background;
    private TextureRegion player;
    private TextureRegion enemy;
    private Movement move;
    private Boolean isJumping = false;
    private Boolean orientation = true;


    @Override
    public void create () {
        batch = new SpriteBatch();
        background = new Texture("glassy/raw/white.png");

        player = new TextureRegion(new Texture("sprites/CharSprite.png"));
        enemy = new TextureRegion(new Texture("sprites/goomba.gif"));
        move = new Movement();
        System.out.println(enemy.getRegionX());

    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // don't forget to clear screen

        if (Gdx.input.isKeyPressed(Input.Keys.W) && !isJumping) {
            move.velocity.y = 500;
            isJumping = true;
            player.setTexture(new Texture("sprites/Jumping.png"));
            System.out.println(move.GRAVITY);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            move.moveRight();
            player.flip(orientation,false);
            orientation = true;
            player.flip(true,false);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            move.position.x += -5;
            player.flip(orientation,false);
            orientation = false;
            player.flip(false,false);

        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            Context context = new Context(new JumpHigher());
            move.setSpeed(context.executeStrategy(move.getSpeed()));
        }

        move.update();


        batch.begin();
        float scaleFactor = (float) 0.25;
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(player, move.position.x, move.position.y, player.getRegionWidth() * scaleFactor, player.getRegionHeight() * scaleFactor);
        batch.draw(enemy, 300, 0, enemy.getRegionWidth() * scaleFactor, enemy.getRegionHeight() * scaleFactor);

        batch.end();
    }

    public class Movement {

        float GRAVITY = -1000; // size depends on your world scale

        public int getSpeed() {
            return speed;
        }

        int speed = 5;

        public void setSpeed(int speed) {
            this.speed = speed;
        }
        final Vector2 position = new Vector2();
        final Vector2 velocity = new Vector2();
        final Vector2 acceleration = new Vector2(0, GRAVITY);

        void update(){
            float dt = Gdx.graphics.getDeltaTime();
            velocity.add(acceleration.x * dt, acceleration.y * dt);
            position.add(velocity.x * dt, velocity.y * dt);

            if (position.y <= 0){ // hit ground, so bounce
                position.y = 0;
                isJumping = false;
                player.setTexture(new Texture("sprites/CharSprite.png"));
            }
            if ((position.x <= 0)){
                position.x = 0;
            }
            if (position.x >= Gdx.graphics.getWidth() - player.getRegionWidth()/2){
                position.x = Gdx.graphics.getWidth() - player.getRegionWidth()/2;
            }
            if (position.x <= enemy.getRegionX()) {
                position.x = 0;
            }
        }

        public void moveRight(){
            move.position.x += speed;
        }

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


