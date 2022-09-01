package uk.jlennie.algorithms.divide_and_conquer.matrices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixQuartersTest {
    MatrixQuarters sut;

    @BeforeEach
    void setup() throws MatrixError {
        Matrix m = new BasicMatrix(8);

        for (int i = 1; i <= 6; i ++)
            for (int j = 1; j <= 6; j ++)
                m.set(i, j, i + j);

        sut = new MatrixQuarters(m);
    }

    @Test
    void constructsWithMatrix() {
        assertDoesNotThrow(() -> new MatrixQuarters(new BasicMatrix(8)));
    }

    @Test
    void canGetTopLeft() {
        Matrix topLeft = sut.getTopLeft();
    }

    @Test
    void canGetTopRight() {
        Matrix topRight = sut.getTopRight();
    }

    @Test
    void canGetBottomRight() {
        Matrix bottomRight = sut.getBottomRight();
    }

    @Test
    void canGetBottomLeft() {
        Matrix bottomLeft = sut.getBottomLeft();
    }

    @Test
    void cannotConstructWithNonPowerOfTwo() {
        assertThrows(MatrixError.class, () -> new MatrixQuarters(new BasicMatrix(7)));
        assertThrows(MatrixError.class, () -> new MatrixQuarters(new BasicMatrix(9)));
        assertThrows(MatrixError.class, () -> new MatrixQuarters(new BasicMatrix(3)));
    }

    @Test
    void cannotConstructWithSizeOneSquareMatrix() {
        assertThrows(MatrixError.class, () -> new MatrixQuarters(new BasicMatrix(1)));
    }

    @Test
    void canConstructWithVariousPowersOfTwo() {
        assertDoesNotThrow(() -> new MatrixQuarters(new BasicMatrix(2)));
        assertDoesNotThrow(() -> new MatrixQuarters(new BasicMatrix(4)));
        assertDoesNotThrow(() -> new MatrixQuarters(new BasicMatrix(8)));
    }

    @Test
    void canQuarterSimpleTwoMatrix() throws MatrixError {
        Matrix m = getSizeTwoMatrix();

        MatrixQuarters quarters = new MatrixQuarters(m);

        assertSingleSizedQuarter(quarters.getTopLeft(), 1);
        assertSingleSizedQuarter(quarters.getTopRight(), 2);
        assertSingleSizedQuarter(quarters.getBottomLeft(), 3);
        assertSingleSizedQuarter(quarters.getBottomRight(), 4);
    }

    private static void assertSingleSizedQuarter(Matrix matrix, int expectedVal) throws MatrixError {
        assertEquals(1, matrix.size());
        assertEquals(expectedVal, matrix.get(1, 1));
    }

    private static Matrix getSizeTwoMatrix() throws MatrixError {
        Matrix m = new BasicMatrix(2);
        m.set(1, 1, 1);
        m.set(2, 1, 2);
        m.set(1, 2, 3);
        m.set(2, 2, 4);
        return m;
    }
}