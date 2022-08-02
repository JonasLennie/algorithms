package uk.jlennie.search.LinearSearch;

import org.junit.jupiter.api.BeforeEach;
import uk.jlennie.search.Abstractions.SearchListTest;

public class LinearSearchTest extends SearchListTest {
    @Override
    @BeforeEach
    protected void setUp() {
        sut = new LinearSearch<>();
    }
}
