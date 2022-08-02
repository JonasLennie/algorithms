package uk.jlennie.search;

import org.junit.jupiter.api.BeforeEach;
import uk.jlennie.search.Abstractions.SearchListTest;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest extends SearchListTest {

    @BeforeEach
    protected void setUp() {
        sut = new Search<>();
    }
}