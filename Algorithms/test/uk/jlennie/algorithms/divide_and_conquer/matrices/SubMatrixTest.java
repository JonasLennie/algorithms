package uk.jlennie.algorithms.divide_and_conquer.matrices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubMatrixTest extends MatrixTest {

    // If all tests in base case pass SubMatrix can emulate a BasicMatrix
    @Override
    void setSut(int size) throws MatrixError {
        sut = new SubMatrix(new BasicMatrix(size), 1, size);
    }

    @Test
    void canTakeSizeOneSlice() {
        assertDoesNotThrow(() -> new SubMatrix(new BasicMatrix(6), 1, 1));
    }

    @Test
    void biggerStartThanEndCausesError() {
        assertThrows(MatrixError.class, () -> new SubMatrix(new BasicMatrix(6), 4, 3));
    }

    @Test
    void startOrEndOutsideRangeThrows() {
        assertThrows(MatrixError.class, () -> new SubMatrix(new BasicMatrix(6), 7, 7));

        assertThrows(MatrixError.class, () -> new SubMatrix(new BasicMatrix(6), 5, 7));
    }

    @Test
    void startOrEndAtRangeAllowed() {
        assertDoesNotThrow(() -> new SubMatrix(new BasicMatrix(6), 6, 6));

        assertDoesNotThrow(() -> new SubMatrix(new BasicMatrix(6), 5, 6));
    }

    @Test
    void setSpecialValueTakeReadingAndEval() throws MatrixError {
        Matrix m = new BasicMatrix(6);
        m.set(3, 3, 15);
        sut = new SubMatrix(m, 3, 3);

        int result = sut.get(1, 1);

        assertEquals(15, result);
    }

    @Test
    void sizeWorksForSubArrayInclusive() throws MatrixError {
        getSizeThreeSubArray();

        int actual = sut.size();

        assertEquals(3, actual);
    }

    @Test
    void cannotGetAboveSpecifiedBound() throws MatrixError {
        getSizeThreeSubArray();

        assertThrows(MatrixError.class, () -> sut.get(4, 2));

        assertThrows(MatrixError.class, () -> sut.get(2, 4));
    }

    @Test
    void cannotGetBelowSpecifiedBound() throws MatrixError {
        getSizeThreeSubArray();

        assertThrows(MatrixError.class, () -> sut.get(0, 2));

        assertThrows(MatrixError.class, () -> sut.get(2, 0));
    }

    private void getSizeThreeSubArray() throws MatrixError {
        sut = new SubMatrix(new BasicMatrix(6), 2, 4);
    }

    @Test
    void canGetAllInRange() throws MatrixError {
        getSizeThreeSubArray();

        iterateOverAllValues(this::getWrapper, 3);
    }

    @Test
    void canSetAllInRange() throws MatrixError {
        getSizeThreeSubArray();

        iterateOverAllValues((i, j) -> setWrapper(i, j, 2), 3);
    }

    @Test
    void setAllValsInRangeToCustomValue() throws MatrixError {
        getSizeThreeSubArray();

        iterateOverAllValues((i, j) -> setWrapper(i, j, i * j), 3);

        iterateOverAllValues(this::getAndAssertEqual, 3);
    }

}