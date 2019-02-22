package com.Logic.Constructor;

import com.world.enemy.Enemy;
import com.world.enemy.HorizontalEnemy;
import com.world.enemy.VerticleEnemy;

public class JumpingEnemyFactory extends EnemyFactory {
    @Override
    public Enemy getEnemyF(String enemyType){
        if(enemyType.equals("JUMPINGENEMY")){
            return new VerticleEnemy();
        }
        else if(enemyType.equals("HORIZONTALENEMY")){
            return new HorizontalEnemy();
        }
        else return null;
    }
}
