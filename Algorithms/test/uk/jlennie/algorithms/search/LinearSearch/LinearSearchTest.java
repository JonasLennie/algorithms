package uk.jlennie.algorithms.search.LinearSearch;

import org.junit.jupiter.api.BeforeEach;
import uk.jlennie.algorithms.search.Abstractions.SearchListTest;

public class LinearSearchTest extends SearchListTest {
    @Override
    @BeforeEach
    protected void setUp() {
        sut = new LinearSearch<>();
    }
}
