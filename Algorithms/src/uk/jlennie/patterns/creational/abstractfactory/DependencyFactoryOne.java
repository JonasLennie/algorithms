package uk.jlennie.patterns.creational.abstractfactory;

public class DependencyFactoryOne extends AbstractDependencyFactory{
    @Override
    Dependency createDependency() {
        return new DependencyImplementationOne();
    }
}
