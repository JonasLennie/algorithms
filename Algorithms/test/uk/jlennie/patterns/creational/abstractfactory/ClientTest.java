package uk.jlennie.patterns.creational.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client sut;

    @Test
    void constructClientWithFirstImplementation() {
        sut = new Client(new DependencyFactoryOne());

        assertEquals(1, sut.runMethod());
    }

    @Test
    void constructWithSecondImplementation() {
        sut = new Client(new DependencyFactoryTwo());

        assertEquals(2, sut.runMethod());
    }

}