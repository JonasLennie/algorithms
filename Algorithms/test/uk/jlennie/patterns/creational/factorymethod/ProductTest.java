package uk.jlennie.patterns.creational.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product sut;

    @Test
    void productReturnsNiceNumber() {
        sut = new ProductImplementation();

        assertEquals(49, sut.getNiceNumber());
    }

    @Test
    void alternativeProductReturns42() {
        sut = new AlternativeProduct();

        assertEquals(42, sut.getNiceNumber());
    }

}