package uk.jlennie.patterns.creational.factorymethod;


public class AlternativeProduct implements Product {

    @Override
    public int getNiceNumber() {
        return 42;
    }
}
