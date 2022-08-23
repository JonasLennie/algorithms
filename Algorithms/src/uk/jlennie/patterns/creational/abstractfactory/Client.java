package uk.jlennie.patterns.creational.abstractfactory;

public class Client {
    private final Dependency dependency;

    public Client(AbstractDependencyFactory factory) {
        dependency = factory.createDependency();
    }

    public int runMethod() {
        return dependency.method();
    }
}
