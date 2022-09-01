package uk.jlennie.algorithms.divide_and_conquer.matrices;

import org.junit.jupiter.api.BeforeEach;

class BasicMatrixMultiplyTest extends MatrixMultiplyTest {

    @Override
    @BeforeEach
    void setup() {
        sut = new BasicMatrixMultiply();
    }
}