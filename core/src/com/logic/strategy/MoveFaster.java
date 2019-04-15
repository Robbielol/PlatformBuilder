package com.logic.strategy;

public class MoveFaster implements Strategy {

    @Override
    public float doOperation(float value) {
        return value*2;
    }
}
