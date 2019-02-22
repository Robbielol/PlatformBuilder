package com.logic.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int value) {
        return strategy.doOperation(value);
    }
}
