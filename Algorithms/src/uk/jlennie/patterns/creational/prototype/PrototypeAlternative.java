package uk.jlennie.patterns.creational.prototype;

public class PrototypeAlternative implements Prototype{
    @Override
    public int method() {
        return 2;
    }

    @Override
    public Prototype clone() {
        return new PrototypeAlternative();
    }
}
