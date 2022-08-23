package uk.jlennie.patterns.creational.prototype;

public class Client {
    private Prototype prototype;

    public void makeNew(Prototype prototype) {
        this.prototype = prototype.clone();
    }

    public int runMethod() {
        return prototype.method();
    }
}
