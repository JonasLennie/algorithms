package uk.jlennie.patterns.creational.singleton;

public class SingletonFactory {
    private static GlobalInstance product;

    public GlobalInstance getInstance() {
        if (product == null)
            product = new GlobalInstance();

        return product;
    }
}
