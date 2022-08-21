package uk.jlennie.algorithms.search;

import org.junit.jupiter.api.BeforeEach;
import uk.jlennie.algorithms.search.Abstractions.IdealInsertPosTest;

class InsertPosSearchTest extends IdealInsertPosTest {

    @Override
    @BeforeEach
    protected void setUp() {
        sut = new InsertPosSearch<>();
    }
}