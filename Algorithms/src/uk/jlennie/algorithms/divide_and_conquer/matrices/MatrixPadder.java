package uk.jlennie.algorithms.divide_and_conquer.matrices;

public class MatrixPadder {
    public Matrix pad (Matrix m, int size) throws MatrixError {
        throwIfSizeTooSmall(m, size);

        Matrix newMatrix = new BasicMatrix(size);

        copyMToNewMatrix(m, newMatrix);

        return newMatrix;
    }

    private static void copyMToNewMatrix(Matrix m, Matrix newMatrix) throws MatrixError {
        for (int i = 1; i <= m.size(); i ++)
            for (int j = 1; j <= m.size(); j ++)
                newMatrix.set(i, j, m.get(i, j));
    }

    private static void throwIfSizeTooSmall(Matrix m, int size) throws MatrixError {
        if (size < m.size())
            throw new MatrixError("Specified size too small to pad matrix");
    }
}
