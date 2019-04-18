package testcases;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.logic.command.Movements;
import org.junit.Assert;
import org.junit.Test;

public class MovementsTest extends TestSetUp
{

    private TextureRegion player;
    private Movements moveTest;
    private Vector2 velocity;
    private Vector2 position;

    public MovementsTest(){
        super();
        player = new TextureRegion(new Texture("sprites/CharSprite.png"));
        moveTest = new Movements(player);
        velocity = new Vector2();
        position = new Vector2();
    }

    @Test
    public void testJump()
    {
        moveTest.jump();
        velocity.y = moveTest.getJumpHeight();
        Assert.assertTrue(velocity.y == 500);
        position = moveTest.getPosition();
        Assert.assertTrue(position.x == 0);
    }

    @Test
    public void testMoveRight()
    {
        moveTest.moveLeft();
        velocity.y = moveTest.getJumpHeight();
        Assert.assertTrue(velocity.y == 0);
        position = moveTest.getPosition();
        Assert.assertTrue(position.x == 5);
    }

    @Test
    public void testMoveLeft()
    {
        moveTest.moveRight();
        velocity.y = moveTest.getJumpHeight();
        Assert.assertTrue(velocity.y == 0);
        position = moveTest.getPosition();
        Assert.assertTrue(position.x == -5);
    }


}
