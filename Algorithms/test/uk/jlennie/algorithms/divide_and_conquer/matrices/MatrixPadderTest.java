package uk.jlennie.algorithms.divide_and_conquer.matrices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixPadderTest extends MatrixTest{
    MatrixPadder padder;
    Matrix sample;
    int startingSize;

    // This ensures the resultant matrix behaves exactly as a normal matrix
    @Override
    void setSut(int size) throws MatrixError {
        MatrixPadder padder = new MatrixPadder();
        sut = padder.pad(new BasicMatrix(Math.max(size - 2, 1)), size);
    }

    @BeforeEach
    void setup() throws MatrixError {
        startingSize = 5;
        padder = new MatrixPadder();
        sample = new BasicMatrix(startingSize);

        for (int i = 1; i <= startingSize; i ++)
            for (int j = 1; j <= startingSize; j ++)
                sample.set(i, j, i + j);
    }

    void assertOriginalUnaltered(Matrix result) throws MatrixError {
        for (int i = 1; i <= startingSize; i ++)
            for (int j = 1; j <= startingSize; j ++)
                assertEquals(i + j, result.get(i, j));
    }

    @Test
    void padSmallerThanStartingThrows() {
        assertThrows(MatrixError.class, () -> padder.pad(sample, startingSize - 1));
    }

    @Test
    void padAtOriginalSizeGivesSameMatrix() throws MatrixError {
        Matrix result = padder.pad(sample, startingSize);

        assertEquals(result.size(), startingSize);
        assertOriginalUnaltered(result);
    }

    @Test
    void padOnePastSizeLeavesOriginalUnaltered() throws MatrixError {
        Matrix result = padder.pad(sample, startingSize + 1);

        assertEquals(result.size(), startingSize + 1);
        assertOriginalUnaltered(result);
    }

    @Test
    void padOnePastSizeAllOuterAreZero() throws MatrixError {
        Matrix result = padder.pad(sample, startingSize + 1);

        assertEquals(result.size(), startingSize + 1);

        for (int i = 1; i <= result.size(); i ++) {
            assertEquals(0, result.get(result.size(), i));
            assertEquals(0, result.get(i, result.size()));
        }
    }
}