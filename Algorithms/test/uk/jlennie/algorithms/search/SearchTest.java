package uk.jlennie.algorithms.search;

import org.junit.jupiter.api.BeforeEach;
import uk.jlennie.algorithms.search.Abstractions.SearchListTest;

class SearchTest extends SearchListTest {

    @BeforeEach
    protected void setUp() {
        sut = new Search<>();
    }
}