package uk.jlennie.patterns.creational.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderInstanceTest {
    BuilderInstance sut;

    private void makeAssertion(int expectedA, int expectedB) {
        assertEquals(expectedA, sut.getResult().getNumMethodA());
        assertEquals(expectedB, sut.getResult().getNumMethodB());
    }

    @BeforeEach
    void setup() {
        sut = new BuilderInstance();
    }

    @Test
    void bothZeroIfNoAction() {
        makeAssertion(0, 0);
    }

    @Test
    void oneOnMethodA() {
        sut.buildMethodA();

        makeAssertion(1, 0);
    }

    @Test
    void oneOnMethodB() {
        sut.buildMethodB();

        makeAssertion(0, 1);
    }

    @Test
    void bigOne() {
        for (int i = 0; i < 10; i ++)
            sut.buildMethodA();

        for (int i = 0; i < 7; i ++)
            sut.buildMethodB();

        makeAssertion(10, 7);
    }
}