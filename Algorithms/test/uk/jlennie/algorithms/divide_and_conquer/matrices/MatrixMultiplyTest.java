package uk.jlennie.algorithms.divide_and_conquer.matrices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class MatrixMultiplyTest {
    MatrixMultiply sut;

    @BeforeEach
    abstract void setup();


    @Test
    void cannonMultiplyNonEqualSizeMatrices() throws MatrixError {
        Matrix smallMatrix = new BasicMatrix(3);
        Matrix biggerMatrix = new BasicMatrix(4);

        assertThrows(MatrixError.class, () -> sut.multiply(smallMatrix, biggerMatrix));
        assertThrows(MatrixError.class, () -> sut.multiply(biggerMatrix, smallMatrix));
    }

    @Test
    void multipltyMatrixOfGivenSizeProducesMatrixOfEqualSize() throws MatrixError {
        Matrix a = new BasicMatrix(5);
        Matrix b = new BasicMatrix(5);

        Matrix result = sut.multiply(a, b);

        assertEquals(5, result.size());
    }

    @Test
    void identityMultiplyWorksAsExpected() throws MatrixError {
        Matrix a = getIdentityMatrix();
        Matrix b = getIdentityMatrix();

        Matrix result = sut.multiply(a, b);

        assertEquals(1, result.get(1, 1));
        assertEquals(0, result.get(2, 1));
        assertEquals(0, result.get(1, 2));
        assertEquals(1, result.get(2, 2));
    }

    private Matrix getIdentityMatrix() throws MatrixError {
        Matrix a = new BasicMatrix(2);
        a.set(1, 1, 1);
        a.set(1, 2, 0);
        a.set(2, 1, 0);
        a.set(2, 2, 1);
        return a;
    }

    @Test
    void multiplySingletonsWorks() throws MatrixError {
        Matrix a = new BasicMatrix(1);
        a.set(1, 1, 5);

        Matrix b = new BasicMatrix(1);
        b.set(1, 1, 6);

        Matrix result = sut.multiply(a, b);

        assertEquals(30, result.get(1, 1));
    }

    @Test
    void moreComplexMultiplyWorks() throws MatrixError {
        Matrix a = new BasicMatrix(3);
        a.set(1, 1, 12);
        a.set(1, 2, 8);
        a.set(1, 3, 4);
        a.set(2, 1, 3);
        a.set(2, 2, 17);
        a.set(2, 3, 14);
        a.set(3, 1, 9);
        a.set(3, 2, 8);
        a.set(3, 3, 10);

        Matrix b = new BasicMatrix(3);
        b.set(1, 1, 5);
        b.set(1, 2, 19);
        b.set(1, 3, 3);
        b.set(2, 1, 6);
        b.set(2, 2, 15);
        b.set(2, 3, 9);
        b.set(3, 1, 7);
        b.set(3, 2, 8);
        b.set(3, 3, 16);


        Matrix result = sut.multiply(a, b);

        assertEquals(136, result.get(1, 1));
        assertEquals(380, result.get(1, 2));
        assertEquals(172, result.get(1, 3));
        assertEquals(215, result.get(2, 1));
        assertEquals(424, result.get(2, 2));
        assertEquals(386, result.get(2, 3));
        assertEquals(163, result.get(3, 1));
        assertEquals(371, result.get(3, 2));
        assertEquals(259, result.get(3, 3));
    }
}