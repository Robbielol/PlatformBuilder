package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class CharacterTest extends ApplicationAdapter{
    private SpriteBatch batch;
    private Texture background;
    private TextureRegion texture;
    private Movement move;
    private Boolean isJumping = false;
    private Boolean orientation = true;


    @Override
    public void create () {
        batch = new SpriteBatch();
        System.out.println(Gdx.graphics.getWidth());
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        background = new Texture("glassy/raw/white.png");

        texture = new TextureRegion(new Texture("sprites/CharSprite.png"));

        move = new Movement();
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // don't forget to clear screen

        if (Gdx.input.isKeyPressed(Input.Keys.W) && !isJumping) {
            move.velocity.y = 500;
            isJumping = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            move.position.x += 5;
            texture.flip(orientation,false);
            orientation = true;
            texture.flip(orientation,false);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            move.position.x += -5;
            texture.flip(orientation,false);
            orientation = false;
            texture.flip(orientation,false);

        }

        move.update();


        batch.begin();
        float scaleFactor = (float) 0.25;
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(texture, move.position.x, move.position.y, texture.getRegionWidth() * scaleFactor, texture.getRegionHeight() * scaleFactor);

        batch.end();
    }

    public class Movement {

        static final float GRAVITY = -1000; // size depends on your world scale

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
            }
            if ((position.x <= 0)){
                position.x = 0;
            }
            else if (position.x >= Gdx.graphics.getWidth() - texture.getRegionWidth()/2){
                position.x = Gdx.graphics.getWidth() - texture.getRegionWidth()/2;
            }
        }

//        void changeOrientation(){
//            if(orientation){
//                texture.flip(false,false);
//            }
//            else{
//                texture.flip(true,false);
//            }
//        }

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


