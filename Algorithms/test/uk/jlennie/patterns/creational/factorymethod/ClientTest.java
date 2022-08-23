package uk.jlennie.patterns.creational.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client sut;

    @Test
    void clientHasRightProduct() {
        sut = new ClientImplementation();

        assertEquals(49, sut.getProductNumber());
    }

    @Test
    void alternativeClientHasRightProduct() {
        sut = new AlternativeClient();

        assertEquals(42, sut.getProductNumber());
    }

}