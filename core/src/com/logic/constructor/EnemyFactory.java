package com.logic.constructor;

import com.world.enemy.Enemy;
import com.world.obstacle.Obstacle;

public abstract class EnemyFactory {

    abstract Enemy getEnemyF(String enemyType);

}
