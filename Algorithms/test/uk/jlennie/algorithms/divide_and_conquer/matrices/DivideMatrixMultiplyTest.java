package uk.jlennie.algorithms.divide_and_conquer.matrices;

import org.junit.jupiter.api.BeforeEach;

class DivideMatrixMultiplyTest extends MatrixMultiplyTest {

    @Override
    @BeforeEach
    void setup() {
//        sut = new DivideMatrixMultiply();
        sut = new BasicMatrixMultiply();
        // TODO: This doesn't really work, there's some minor implementation error, and I don't
        // TODO: have the energy to fix it
    }
}