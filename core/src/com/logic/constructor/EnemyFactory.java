package com.logic.constructor;

import com.world.enemy.Enemy;

public abstract class EnemyFactory {

    abstract Enemy getEnemyF(String enemyType);

}
