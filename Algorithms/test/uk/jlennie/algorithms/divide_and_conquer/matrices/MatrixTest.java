package uk.jlennie.algorithms.divide_and_conquer.matrices;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

abstract class MatrixTest {
    Matrix sut;

    @Test
    void cannotCreateZeroSizedMatrix(){
        assertThrows(MatrixError.class, () -> new BasicMatrix(0));
    }

    @Test
    void cannotHaveNegativeSizedMatrix() {
        assertThrows(MatrixError.class, () -> new BasicMatrix(-1));
    }

    @Test
    void canCreateMatrixSizeOne() {
        assertDoesNotThrow(() -> new BasicMatrix(1));
    }

    @Test
    void createMatrixSizeOneCanGetSize() throws MatrixError {
        setSut(1);

        assertEquals(1, sut.size()) ;
    }

    @Test
    void getSizeForBiggerMatrix() throws MatrixError {
        setSut(10);

        assertEquals(10, sut.size());
    }

    @Test
    void getElementInSmallMatrix() throws MatrixError {
        setSut(1);

        int val = sut.get(1, 1);

        assertEquals(0, val);
    }

    @Test
    void setAndReadValSmallMatrix() throws MatrixError {
        setSut(1);
        sut.set(1, 1, 5);

        int val = sut.get(1, 1);

        assertEquals(5, val);
    }

    @Test
    void cannotGetZeroI() throws MatrixError {
        setSut(5);

        assertThrows(MatrixError.class, () -> sut.get(0, 4));
    }

    @Test
    void cannotGetNegativeI() throws MatrixError {
        setSut(5);

        assertThrows(MatrixError.class, () -> sut.get(-5, 3));
    }

    @Test
    void cannotGetZeroJ() throws MatrixError {
        setSut(5);

        assertThrows(MatrixError.class, () -> sut.get(4, 0));
    }

    @Test
    void cannotGetNegativeJ() throws MatrixError {
        setSut(5);

        assertThrows(MatrixError.class, () -> sut.get(3,  -5));
    }

    @Test
    void cannotSetZeroI() throws MatrixError {
        setSut(5);

        assertThrows(MatrixError.class, () -> sut.set(0, 3, 1));
    }

    @Test
    void cannotSetZeroJ() throws MatrixError {
        setSut(5);

        assertThrows(MatrixError.class, () -> sut.set(4, 0, 2));
    }

    @Test
    void cannotGetIAboveSize() throws MatrixError {
        setSut(5);

        assertThrows(MatrixError.class, () -> sut.get(6, 1));
    }

    @Test
    void cannotGetJAboveSize() throws MatrixError {
        setSut(5);

        assertThrows(MatrixError.class, () -> sut.get(1, 6));
    }

    @Test
    void cannotSetAboveSize() throws MatrixError {
        setSut(5);

        assertThrows(MatrixError.class, () -> sut.set(6, 1, 2));

        assertThrows(MatrixError.class, () -> sut.set(1, 6, 2));
    }

    @Test
    void canSetAllInRange() throws MatrixError {
        setSut(6);

        iterateOverAllValues((i, j) -> setWrapper(i, j, 2), 6);
    }

    abstract void setSut(int size) throws MatrixError;

    protected boolean setWrapper(int i, int j, int val) {
        try {
            sut.set(i, j, val);
            return true;
        } catch (MatrixError e) {
            return false;
        }
    }

    protected boolean getWrapper(int i, int j) {
        try {
            sut.get(i, j);
            return true;
        } catch (MatrixError e) {
            return false;
        }
    }


    protected void iterateOverAllValues(BiFunction<Integer, Integer, Boolean> func, int size) {
        for (int i = 1; i <= size; i ++)
            for (int j = 1; j <= size; j ++)
                assertTrue(func.apply(i, j));
    }

    @Test
    void canGetAllInRange() throws MatrixError {
        setSut(6);

        iterateOverAllValues(this::getWrapper, 6);
    }

    @Test
    void setAllValsAndThenRead() throws MatrixError {
        setSut(6);

        iterateOverAllValues((i, j) -> setWrapper(i, j, i * j), 6);

        iterateOverAllValues(this::getAndAssertEqual, 6);
    }

    protected boolean getAndAssertEqual(int i, int j) {
        try {
            assertEquals(i * j, sut.get(i, j));
            return true;
        } catch (MatrixError e) {
            return false;
        }
    }

}