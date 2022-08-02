package uk.jlennie.search;

import org.junit.jupiter.api.BeforeEach;
import uk.jlennie.search.Abstractions.IdealInsertPosTest;

class InsertPosSearchTest extends IdealInsertPosTest {

    @Override
    @BeforeEach
    protected void setUp() {
        sut = new InsertPosSearch<>();
    }
}