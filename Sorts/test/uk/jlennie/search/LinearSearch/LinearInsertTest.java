package uk.jlennie.search.LinearSearch;

import org.junit.jupiter.api.BeforeEach;
import uk.jlennie.search.Abstractions.IdealInsertPosTest;

class LinearInsertTest extends IdealInsertPosTest {

    @Override
    @BeforeEach
    protected void setUp() {
        sut = new LinearInsert<>();
    }

}