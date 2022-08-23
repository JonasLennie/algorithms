package uk.jlennie.patterns.creational.builder;

public class BuilderInstance implements Builder{
    private final Product product;

    public BuilderInstance() {
        product = new Product();
    }

    @Override
    public void buildMethodA() {
        product.methodA();
    }

    @Override
    public void buildMethodB() {
        product.methodB();
    }

    public Product getResult() {
        return product;
    }
}
