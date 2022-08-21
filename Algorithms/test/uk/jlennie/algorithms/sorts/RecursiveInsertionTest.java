package uk.jlennie.algorithms.sorts;

import org.junit.jupiter.api.BeforeEach;

class RecursiveInsertionTest extends SortTest {

    @BeforeEach
    @Override
    void setUp() {
        sut = new RecursiveInsertion();
    }
}