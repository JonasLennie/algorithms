package uk.jlennie.patterns.creational.builder;

public class Director {
    private final int a;

    private final int b;

    public Director(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void castToNewType(Builder builder) {
        for(int i = 0; i < a; i ++)
            builder.buildMethodA();

        for(int i = 0; i < b; i ++)
            builder.buildMethodB();
    }
}
