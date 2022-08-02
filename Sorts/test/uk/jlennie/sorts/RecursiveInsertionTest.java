package uk.jlennie.sorts;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveInsertionTest extends SortTest {

    @BeforeEach
    @Override
    void setUp() {
        sut = new RecursiveInsertion();
    }
}