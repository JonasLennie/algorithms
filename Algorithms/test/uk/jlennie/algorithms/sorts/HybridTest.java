package uk.jlennie.algorithms.sorts;

import org.junit.jupiter.api.BeforeEach;

class HybridTest extends SortTest{

    @Override
    @BeforeEach
    void setUp() {
        sut = new Hybrid(10);
    }
}