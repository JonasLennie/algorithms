package uk.jlennie.patterns.creational.builder;

public class Product {
    private int numMethodA;
    private int numMethodB;

    public void methodA() {
        numMethodA ++;
    }

    public void methodB() {
        numMethodB ++;
    }

    public int getNumMethodA() {
        return numMethodA;
    }

    public int getNumMethodB() {
        return numMethodB;
    }
}
