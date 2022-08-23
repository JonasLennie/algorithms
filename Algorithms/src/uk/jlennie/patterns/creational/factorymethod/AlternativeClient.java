package uk.jlennie.patterns.creational.factorymethod;

public class AlternativeClient extends Client {
    @Override
    protected Product productFactory() {
        return new AlternativeProduct();
    }
}
