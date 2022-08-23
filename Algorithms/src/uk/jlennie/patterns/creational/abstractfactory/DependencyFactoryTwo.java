package uk.jlennie.patterns.creational.abstractfactory;

public class DependencyFactoryTwo extends AbstractDependencyFactory{
    @Override
    Dependency createDependency() {
        return new DependencyImplementationTwo();
    }
}
