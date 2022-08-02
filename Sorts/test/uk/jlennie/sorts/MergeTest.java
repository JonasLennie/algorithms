package uk.jlennie.sorts;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest extends SortTest {

    @BeforeEach
    void setUp() {
        sut = new Merge();
    }
}