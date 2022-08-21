package uk.jlennie.algorithms.search.LinearSearch;

import org.junit.jupiter.api.BeforeEach;
import uk.jlennie.algorithms.search.Abstractions.IdealInsertPosTest;

class LinearInsertTest extends IdealInsertPosTest {

    @Override
    @BeforeEach
    protected void setUp() {
        sut = new LinearInsert<>();
    }

}