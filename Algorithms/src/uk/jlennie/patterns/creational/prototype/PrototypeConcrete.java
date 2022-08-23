package uk.jlennie.patterns.creational.prototype;

public class PrototypeConcrete implements Prototype{
    @Override
    public int method() {
        return 1;
    }

    @Override
    public Prototype clone() {
        return new PrototypeConcrete();
    }
}
