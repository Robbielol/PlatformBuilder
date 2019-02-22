package com.Logic.Constructor;

import com.world.enemy.Enemy;
import com.world.obstacle.Obstacle;

public abstract class EnemyFactory {

    abstract Enemy getEnemyF(String enemyType);

}
