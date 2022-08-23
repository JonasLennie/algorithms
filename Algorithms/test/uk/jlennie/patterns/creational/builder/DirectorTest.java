package uk.jlennie.patterns.creational.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectorTest {
    Director sut;
    BuilderInstance builder;

    @BeforeEach
    void setup() {
        builder = new BuilderInstance();
    }

    @Test
    void tryCast() {
        sut = new Director(5, 7);

        sut.castToNewType(builder);

        Product result = builder.getResult();

        assertEquals(5, result.getNumMethodA());
        assertEquals(7, result.getNumMethodB());
    }

}