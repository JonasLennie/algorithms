package uk.jlennie.patterns.creational.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonFactoryTest {
    SingletonFactory sut;

    @BeforeEach
    void setup() {
        sut = new SingletonFactory();
    }

    @Test
    void incrementOnce() {
        int before = sut.getInstance().getCounter();

        sut.getInstance().incrementCounter();

        int after = sut.getInstance().getCounter();

        assertEquals(1, after - before);
    }

    @Test
    void maintainsAcrossObjects() {
        int before = sut.getInstance().getCounter();

        sut = new SingletonFactory();

        int after = sut.getInstance().getCounter();

        assertEquals(before, after);
    }

    @Test
    void incrementMaintainsAcrossObjects() {
        int before = sut.getInstance().getCounter();

        sut.getInstance().incrementCounter();

        sut = new SingletonFactory();

        int after = sut.getInstance().getCounter();

        assertEquals(1, after - before);
    }
}