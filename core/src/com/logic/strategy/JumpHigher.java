package com.logic.strategy;

public class JumpHigher implements Strategy {
    @Override
    public int doOperation(int value) {
        return value*3;
    }
}
