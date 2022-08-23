package uk.jlennie.patterns.creational.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DependencyImplementationTest {
    Dependency sut;

    @Test
    void dependencyOne() {
        sut = new DependencyImplementationOne();

        assertEquals(1, sut.method());
    }

    @Test
    void dependencyTwo() {
        sut = new DependencyImplementationTwo();

        assertEquals(2, sut.method());
    }

}