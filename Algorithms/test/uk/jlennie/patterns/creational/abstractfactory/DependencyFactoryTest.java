package uk.jlennie.patterns.creational.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DependencyFactoryTest {

    AbstractDependencyFactory factory;
    Dependency result;

    @Test
    void createDependencyOne() {
        factory = new DependencyFactoryOne();

        result =  factory.createDependency();

        assertEquals(1, result.method());
    }

    @Test
    void createDependencyTwo() {
        factory = new DependencyFactoryTwo();

        result = factory.createDependency();

        assertEquals(2, result.method());
    }
}