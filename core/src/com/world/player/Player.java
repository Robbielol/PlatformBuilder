package com.world.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.world.objects.RectangleObstacle;


public class Player extends Image {

    private Vector2 playerPosition;
    private Vector2 playerSize;
    private Rectangle playerBounds;
    private boolean isColliding;
    private Texture playerTexture;
    private Texture jumpTexture;
    private String playerTexturePath;
    private Drawable drawableRegion;
    private Vector2 velocity;
    private Vector2 acceleration;
    private float dt;
    public Player(String playerTexture, Vector2 position, Vector2 size){
        super(new Texture(Gdx.files.internal(playerTexture)));
        this.playerTexture = new Texture(Gdx.files.internal(playerTexture));
        this.jumpTexture = new Texture("sprites/Jumping.png");

        this.playerTexturePath = playerTexture;
        isColliding = false;
        playerPosition = position;
        playerSize = size;
        velocity = new Vector2();
        acceleration = new Vector2(0, -1000);
        playerBounds = new Rectangle(position.x, position.y, size.x, size.y);
        setBounds(position.x, position.y, size.x, size.y);

    }

    @Override
    public void moveBy(float x, float y){
        if(getX()+x >= 0 & getX()+x <= 900) {
            setX(getX() + x);
            playerBounds.x += x;
        }

        if(getY()+y >= 0 & getY()+y <= 600) {
            setY(getY() + y);
            playerBounds.y += y;
        }
    }

    public Rectangle getPlayerBounds() {
        return playerBounds;
    }

    public boolean collidesWith(Player rect){
        Rectangle otherBounds = rect.getBounds();
        if(playerBounds.overlaps(otherBounds)){
            return true;
        }
        if(isColliding){
            drawableRegion = new TextureRegionDrawable(new TextureRegion(playerTexture));
            super.setDrawable(drawableRegion);
        }

        isColliding = false;
        return false;
    }
    public boolean collidesWith(RectangleObstacle rect){
        Rectangle otherBounds = rect.getBounds();
        if(playerBounds.overlaps(otherBounds)){
//            moveBy(0,rect.getHeight() + 20);
            return true;
        }
        if(isColliding){
//            drawableRegion = new TextureRegionDrawable(new TextureRegion(playerTexture));
//            super.setDrawable(drawableRegion);
        }
        isColliding = false;
        return false;
    }


    private Rectangle getBounds() {
        return playerBounds;
    }

    public void onCollision(){
        isColliding = true;
        drawableRegion = new TextureRegionDrawable(new TextureRegion(jumpTexture));
        super.setDrawable(drawableRegion);
    }

    public void update() {
        dt = Gdx.graphics.getDeltaTime();

        velocity.add(acceleration.x * dt, acceleration.y * dt);
//        if(!isColliding)
//        else {
//
//            System.out.println("Moved to 0,0");
////            isColliding = false;
//        }
        if(isColliding){
//            velocity.add(0,0);
//            dt = 0;
//            moveBy(velocity.x * dt, velocity.y * dt);
            System.out.println("Here");
//            velocity.y = 0;

            moveBy(0, 0);

        } else {
            moveBy(velocity.x * dt, velocity.y * dt);

        }
    }

    public void jump(){
        velocity.y = 300;
        if(isColliding){
//            velocity.y = 500;
//            System.out.println("Cannot jump");
        }
    }
}
