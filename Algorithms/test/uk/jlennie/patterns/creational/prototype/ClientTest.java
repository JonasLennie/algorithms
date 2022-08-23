package uk.jlennie.patterns.creational.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void makeFirstThenMakeAlternative() {
        Client sut = new Client();

        sut.makeNew(new PrototypeConcrete());

        assertEquals(1, sut.runMethod());

        sut.makeNew(new PrototypeAlternative());

        assertEquals(2, sut.runMethod());
    }

}