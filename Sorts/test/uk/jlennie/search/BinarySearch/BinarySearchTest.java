package uk.jlennie.search.BinarySearch;

import org.junit.jupiter.api.BeforeEach;
import uk.jlennie.search.Abstractions.SearchListTest;

class BinarySearchTest extends SearchListTest {

    @BeforeEach
    @Override
    protected void setUp() {
        sut = new BinarySearch<>();
    }
}