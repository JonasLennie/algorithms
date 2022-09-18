package uk.jlennie.algorithms.divide_and_conquer.matrices;

public class MatrixQuarters {
    private SubMatrix topLeft;
    private SubMatrix topRight;
    private SubMatrix bottomLeft;
    private SubMatrix bottomRight;

    public MatrixQuarters(Matrix matrixToQuarter) throws MatrixError {
        throwIfSizeIsNotLargePowerOf2(matrixToQuarter);

        int mid = matrixToQuarter.size() / 2;

        topLeft = new SubMatrix(matrixToQuarter, 1, mid, 1, mid);
        topRight = new SubMatrix(matrixToQuarter, mid + 1, matrixToQuarter.size(), 1, mid);
        bottomLeft = new SubMatrix(matrixToQuarter, 1, mid, mid + 1, matrixToQuarter.size());
        bottomRight = new SubMatrix(matrixToQuarter, mid + 1, matrixToQuarter.size()
                , mid + 1, matrixToQuarter.size());
    }

    private void throwIfSizeIsNotLargePowerOf2(Matrix matrixToQuarter) throws MatrixError {
        if (!isPowerOfTwoAndGTOne(matrixToQuarter.size()))
           throw new MatrixError("Bad Matrix size, must be power of 2");
    }

    private boolean isPowerOfTwoAndGTOne(int n) {
        // Using bitwise binary Operator
        return (n & (n - 1)) == 0 && n > 1;
    }

    public Matrix getTopLeft() {
        return topLeft;
    }

    public Matrix getTopRight() {
        return topRight;
    }

    public Matrix getBottomRight() {
        return bottomRight;
    }

    public Matrix getBottomLeft() {
        return bottomLeft;
    }
}
