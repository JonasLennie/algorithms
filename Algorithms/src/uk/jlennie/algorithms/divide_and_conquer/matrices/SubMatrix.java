package uk.jlennie.algorithms.divide_and_conquer.matrices;

public class SubMatrix implements Matrix {
    private final Matrix m;
    private final int startIndex;
    private final int endIndex;

    public SubMatrix(Matrix startingMatrix, int startIndex, int endIndex) throws MatrixError {
        throwIfIndexesNotValid(startingMatrix, startIndex, endIndex);

        this.m = startingMatrix;
        this.startIndex = startIndex - 1;
        this.endIndex = endIndex;
    }

    private void throwIfIndexesNotValid(Matrix startingMatrix, int startIndex, int endIndex) throws MatrixError {
        if (areNotValid(startingMatrix, startIndex, endIndex))
            throw new MatrixError("Bad bounds for a sub-matrix");
    }

    private boolean areNotValid(Matrix startingMatrix, int startIndex, int endIndex) {
        return startIndex > endIndex
                || startIndex > startingMatrix.size()
                || endIndex > startingMatrix.size()
                || startIndex <= 0;
    }

    @Override
    public int get(int i, int j) throws MatrixError {
        throwIfIorJAreBad(i, j);

        return m.get(i + startIndex, j + startIndex);
    }

    private void throwIfIorJAreBad(int i, int j) throws MatrixError {
        if (IorJIsBad(i, j))
            throw new MatrixError("Bad Bounds on sub array for set and get");
    }

    private boolean IorJIsBad(int i, int j) {
        return i > size() || j > size() || i <= 0 || j <= 0;
    }

    @Override
    public int set(int i, int j, int val) throws MatrixError {
        return m.set(i + startIndex, j + startIndex, val);
    }

    @Override
    public int size() {
        return endIndex - startIndex;
    }
}
