package uk.jlennie.algorithms.sorts;

import org.junit.jupiter.api.BeforeEach;

class FastInsertionTest extends SortTest {

    @Override
    @BeforeEach
    void setUp() {
        sut = new FastInsertion();
    }
}