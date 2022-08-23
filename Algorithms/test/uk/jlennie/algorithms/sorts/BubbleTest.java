package uk.jlennie.algorithms.sorts;

import org.junit.jupiter.api.BeforeEach;

class BubbleTest extends SortTest {

    @Override
    @BeforeEach
    void setUp() {
        sut = new Bubble();
    }
}