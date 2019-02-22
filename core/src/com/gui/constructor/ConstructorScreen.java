package com.gui.constructor;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.PlatformBuilder;

public class ConstructorScreen implements Screen {

    private PlatformBuilder game;
    private SpriteBatch batch;
    private BitmapFont frames;
    private Label framesLabel;
    private Stage stage;
    private Table table;
    private float frameRate;
    private float sinceChange;
    private long lastTimeCounted;

    public ConstructorScreen(PlatformBuilder game){
        this.game = game;
        create();
    }

    public void create(){
        batch = new SpriteBatch();

        // FPS counter
        frames = new BitmapFont();
        lastTimeCounted = TimeUtils.millis();
        frameRate = Gdx.graphics.getFramesPerSecond();
        framesLabel = new Label("FPS: "+frameRate, new Label.LabelStyle(frames, Color.BLACK));
        framesLabel.setPosition(Gdx.graphics.getWidth()/50, Gdx.graphics.getHeight()-20);

        // Stage
        stage = new Stage();
        stage.addActor(framesLabel);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        framesLabel.setText("FPS: "+frameRate);
        stage.draw();
        batch.end();
        update();
    }

    public void update(){
        long delta = TimeUtils.timeSinceMillis(lastTimeCounted);
        lastTimeCounted = TimeUtils.millis();

        sinceChange += delta;
        if(sinceChange >= 1000) {
            sinceChange = 0;
            frameRate = Gdx.graphics.getFramesPerSecond();
        }
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
