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
import com.logic.common.InputController;
import com.logic.constructor.common.Movements;
import com.world.player.Player;

public class GameWorld implements Screen {

    private PlatformBuilder game;
    private boolean pressOnce = false;
    private SpriteBatch batch;
    private Texture background;
    private TextureRegion enemy;
    private Movements movements;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera camera;
    private final float TIMESTEP = 1 / 60f;
    private final int VELOCITY = 8, POSITIONITERATION = 3;
    private Stage stage;
    Player player1;



    public GameWorld(PlatformBuilder game) {
        this.game = game;
        create();
    }

    public GameWorld(){
        create();
    }

    public void create(){
        batch = new SpriteBatch();

    }

    @Override
    public void show() {
        world = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() / 10);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0,10);

        //ball
        CircleShape circleShape= new CircleShape();

        circleShape.setRadius(1);

        FixtureDef fixtureDef =  new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 2.5f;
        fixtureDef.friction = .25f;
        fixtureDef.restitution = .75f;

        world.createBody(bodyDef).createFixture(fixtureDef);
        circleShape.dispose();

        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0,0);

        ChainShape groundShape = new ChainShape();
        groundShape.createChain(new Vector2[]{ new Vector2(-10, 0), new Vector2(500, 0)});

        //Floor shape
        fixtureDef.shape = groundShape;
        fixtureDef.friction = .5f;
        fixtureDef.restitution = 0;

        world.createBody(bodyDef).createFixture(fixtureDef);

        groundShape.dispose();


        player1 = new Player("sprites/CharSprite.png",new Vector2(700,0), new Vector2(100,75));
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        stage.addActor(player1);

        Gdx.input.setInputProcessor(new InputController(){
            @Override
            public boolean keyDown(int keycode){
                if(keycode == Input.Keys.ESCAPE)
                    System.out.println("Escape pressed");
                if(keycode == Input.Keys.D) {

                }

                return true;
            }
            @Override
            public boolean keyUp(int keycode) {

                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        debugRenderer.render(world,camera.combined);

        world.step(TIMESTEP,VELOCITY,POSITIONITERATION);
        stage.act();
        stage.draw();
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
