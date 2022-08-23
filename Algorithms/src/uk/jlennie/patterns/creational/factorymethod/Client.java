package uk.jlennie.patterns.creational.factorymethod;

abstract public class Client {
    protected Product product;

    public Client() {
        product = productFactory();
    }

    protected abstract Product productFactory();

    public int getProductNumber() {
        return product.getNiceNumber();
    }
}
