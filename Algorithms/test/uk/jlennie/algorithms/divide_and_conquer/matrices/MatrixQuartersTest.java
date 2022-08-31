package uk.jlennie.algorithms.divide_and_conquer.matrices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixQuartersTest {
    MatrixQuarters sut;

    @BeforeEach
    void setup() throws MatrixError {
        Matrix m = new BasicMatrix(6);

        for (int i = 1; i <= 6; i ++)
            for (int j = 1; j <= 6; j ++)
                m.set(i, j, i + j);

        sut = new MatrixQuarters(m);
    }

    @Test
    void constructsWithMatrix() {
        assertDoesNotThrow(() -> new MatrixQuarters(new BasicMatrix(5)));
    }

    @Test
    void canGetTopLeft() {
        Matrix topLeft = sut.getTopLeft();
    }

    @Test
    void canGetBottomRight() {
        Matrix topRight = sut.getTopRight();
    }
}