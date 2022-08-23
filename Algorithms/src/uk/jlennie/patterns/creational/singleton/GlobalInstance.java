package uk.jlennie.patterns.creational.singleton;

public class GlobalInstance {
    private int counter;

    public void incrementCounter() {
        counter ++;
    }

    public int getCounter() {
        return counter;
    }
}
