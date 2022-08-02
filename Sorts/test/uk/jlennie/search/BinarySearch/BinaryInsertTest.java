package uk.jlennie.search.BinarySearch;

import org.junit.jupiter.api.BeforeEach;
import uk.jlennie.search.Abstractions.IdealInsertPosTest;

class BinaryInsertTest extends IdealInsertPosTest {

    @BeforeEach
    protected void setUp() {
        sut = new BinaryInsert<>();
    }
}