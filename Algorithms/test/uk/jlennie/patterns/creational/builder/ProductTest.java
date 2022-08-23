package uk.jlennie.patterns.creational.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product sut;

    private void makeAssertion(int expectedA, int expectedB) {
        assertEquals(expectedA, sut.getNumMethodA());
        assertEquals(expectedB, sut.getNumMethodB());
    }

    @BeforeEach
    void setup() {
        sut = new Product();
    }

    @Test
    void bothZeroIfNoAction() {
        makeAssertion(0, 0);
    }

    @Test
    void oneOnMethodA() {
        sut.methodA();

        makeAssertion(1, 0);
    }

    @Test
    void oneOnMethodB() {
        sut.methodB();

        makeAssertion(0, 1);
    }

    @Test
    void bigOne() {
        for (int i = 0; i < 10; i ++)
            sut.methodA();

        for (int i = 0; i < 7; i ++)
            sut.methodB();

        makeAssertion(10, 7);
    }

}