package uk.jlennie.algorithms.divide_and_conquer.matrices;

class BasicMatrixTest extends MatrixTest {

    @Override
    void setSut(int size) throws MatrixError {
        sut = new BasicMatrix(size);
    }
}