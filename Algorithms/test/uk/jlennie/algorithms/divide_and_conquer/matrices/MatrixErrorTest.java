package uk.jlennie.algorithms.divide_and_conquer.matrices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixErrorTest {

    @Test
    void throwMatrixErrorCanBeRead() {
        try {
            throw new MatrixError("Bad things happened");
        } catch (MatrixError e) {
            assertEquals(e.getMessage(), "Bad things happened");
        }
    }

}