package com.logic.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public float executeStrategy(float value) {
        return strategy.doOperation(value);
    }
}
