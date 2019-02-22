package com.logic.strategy;

public class MoveFaster implements Strategy {

    @Override
    public int doOperation(int value) {
        return value*2;
    }
}
