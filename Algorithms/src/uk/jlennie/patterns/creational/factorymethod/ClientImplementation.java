package uk.jlennie.patterns.creational.factorymethod;

public class ClientImplementation extends Client{
    @Override
    protected Product productFactory() {
        return new ProductImplementation();
    }
}
