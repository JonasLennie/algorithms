package uk.jlennie.patterns.creational.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrototypeTest {
    Prototype sut;

    @Test
    void createNewPrototypeConcrete() {
        sut = new PrototypeConcrete();

        assertEquals(1, sut.method());
    }

    @Test
    void createNewPrototypeAlternative() {
        sut = new PrototypeAlternative();

        assertEquals(2, sut.method());
    }

    @Test
    void clonePrototypeConcrete() {
        Prototype prototype = new PrototypeConcrete();
        sut = prototype.clone();

        assertEquals(1, sut.method());
    }

    @Test
    void clonePrototypeAlternative() {
        Prototype prototype = new PrototypeAlternative();
        sut = prototype.clone();

        assertEquals(2, sut.method());
    }
}