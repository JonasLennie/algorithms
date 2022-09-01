package uk.jlennie.algorithms.divide_and_conquer.matrices;

public class SubMatrix implements Matrix {
    private final Matrix m;
    private final int rowStart;
    private final int rowEnd;
    private final int columnStart;

    public SubMatrix(Matrix startingMatrix, int rowStart, int rowEnd, int columnStart, int columnEnd) throws MatrixError {
        throwIfIndexesNotValid(startingMatrix, rowStart, rowEnd, columnStart, columnEnd);

        this.m = startingMatrix;
        this.rowStart = rowStart - 1;
        this.rowEnd = rowEnd;
        this.columnStart = columnStart - 1;
    }

    private void throwIfIndexesNotValid(Matrix startingMatrix, int rowStart, int rowEnd, int columnStart, int columnEnd) throws MatrixError {
        if (areInvalidBounds(startingMatrix, rowStart, rowEnd)
                || areInvalidBounds(startingMatrix, columnStart, columnEnd)
                || isNotSquareMatrix(rowStart, rowEnd, columnStart, columnEnd))
            throw new MatrixError("Bad bounds for a sub-matrix");
    }

    private boolean isNotSquareMatrix(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        return rowEnd - rowStart != columnEnd - columnStart;
    }

    private boolean areInvalidBounds(Matrix startingMatrix, int startIndex, int endIndex) {
        return startIndex > endIndex
                || endIndex > startingMatrix.size()
                || startIndex <= 0;
    }

    @Override
    public int get(int i, int j) throws MatrixError {
        throwIfIorJAreBad(i, j);

        return m.get(i + rowStart, j + columnStart);
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
        throwIfIorJAreBad(i, j);

        return m.set(i + rowStart, j + columnStart, val);
    }

    @Override
    public int size() {
        return rowEnd - rowStart;
    }
}
