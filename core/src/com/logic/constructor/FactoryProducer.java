package com.logic.constructor;

public class FactoryProducer {
    public static ObjectFactory getFactory(boolean isCoin){
        if(isCoin) return new CoinFactory();
        else return new RectFactory();
    }
}
