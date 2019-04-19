package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.logic.controller.InputController;
import com.logic.command.Movements;
import com.world.objects.RectangleObstacle;
import com.world.player.Player;

public class GameWorld implements Screen {

    private PlatformBuilder game;
    private SpriteBatch batch;
    private Stage stage;
    private Player player;
    private RectangleObstacle rect1;
    private RectangleObstacle rect2;
    private RectangleObstacle rect3;


    public GameWorld(PlatformBuilder game) {
        this.game = game;
        create();
    }

    public GameWorld(){
        create();
    }

    public void create(){
        batch = new SpriteBatch();
        player = new Player("sprites/CharSprite.png",new Vector2(0,100), new Vector2(100,75));

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        stage.addActor(player);


        rect1 = new RectangleObstacle("badlogic.jpg",
                new Vector2(100, 0), new Vector2(100, 75));

        rect2 = new RectangleObstacle("badlogic.jpg",
                new Vector2(200, 0), new Vector2(100, 75));

        rect3 = new RectangleObstacle("badlogic.jpg",
                new Vector2(400, 100), new Vector2(100, 75));

        stage.addActor(rect1);
        stage.addActor(rect2);
        stage.addActor(rect3);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            player.jump();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.moveBy(5,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.moveBy(-5,0);
        }

        if(player.collidesWith(rect1) || player.collidesWith(rect2) || player.collidesWith(rect3)){
            player.onCollision();
        }
        player.update();

        stage.act();
        stage.draw();
        batch.begin();
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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
