package uk.jlennie.patterns.creational.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlobalInstanceTest {
    GlobalInstance sut;

    @BeforeEach
    void setup() {
        sut = new GlobalInstance();
    }

    @Test
    void doIncrement() {
        sut.incrementCounter();

        assertEquals(1, sut.getCounter());
    }

    @Test
    void threeIncrement() {
        sut.incrementCounter();
        sut.incrementCounter();
        sut.incrementCounter();

        assertEquals(3, sut.getCounter());
    }

}