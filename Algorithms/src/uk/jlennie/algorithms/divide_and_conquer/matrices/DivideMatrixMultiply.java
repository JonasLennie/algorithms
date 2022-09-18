package uk.jlennie.algorithms.divide_and_conquer.matrices;

// TODO: This doesn't really work, there's some minor implementation error, and I don't
// TODO: have the energy to fix it

public class DivideMatrixMultiply implements MatrixMultiply {
    Matrix a;
    Matrix b;
    Matrix c;

    @Override
    public Matrix multiply(Matrix a, Matrix b) throws MatrixError {
        validateEqualMatrixSize(a, b);
        setup(a, b);

        doMultiply();

        return c;
    }

    private void doMultiply() throws MatrixError {
        if (a.size() == 1)
            doBasicMultiply();
        else
            doRecursiveMultiply();
    }

    private void doRecursiveMultiply() throws MatrixError {
        MatrixQuarters quartersA = new MatrixQuarters(a);
        MatrixQuarters quartersB = new MatrixQuarters(b);
        MatrixQuarters quartersC = new MatrixQuarters(c);

        doTopLeft(quartersA, quartersB, quartersC);
        doTopRight(quartersA, quartersB, quartersC);
        doBottomLeft(quartersA, quartersB, quartersC);
        doBottomRight(quartersA, quartersB, quartersC);
    }

    private void doTopLeft(MatrixQuarters quartersA, MatrixQuarters quartersB, MatrixQuarters quartersC) throws MatrixError {
        Matrix c11a = multiply(quartersA.getTopLeft(), quartersB.getTopLeft());
        Matrix c11b = multiply(quartersA.getBottomLeft(), quartersB.getTopRight());
        combine(quartersC.getTopLeft(), c11a, c11b);
    }

    private void doTopRight(MatrixQuarters quartersA, MatrixQuarters quartersB, MatrixQuarters quartersC) throws MatrixError {
        Matrix c12a = multiply(quartersA.getTopLeft(), quartersB.getBottomLeft());
        Matrix c12b = multiply(quartersA.getBottomLeft(), quartersB.getBottomRight());
        combine(quartersC.getTopRight(), c12a, c12b);
    }

    private void doBottomLeft(MatrixQuarters quartersA, MatrixQuarters quartersB, MatrixQuarters quartersC) throws MatrixError {
        Matrix c21a = multiply(quartersA.getTopRight(), quartersB.getTopLeft());
        Matrix c21b = multiply(quartersA.getBottomRight(), quartersB.getTopRight());
        combine(quartersC.getBottomLeft(), c21a, c21b);
    }

    private void doBottomRight(MatrixQuarters quartersA, MatrixQuarters quartersB, MatrixQuarters quartersC) throws MatrixError {
        Matrix c22a = multiply(quartersA.getTopRight(), quartersB.getBottomLeft());
        Matrix c22b = multiply(quartersA.getBottomRight(), quartersB.getBottomRight());
        combine(quartersC.getBottomRight(), c22a, c22b);
    }

    private void combine(Matrix dest, Matrix partA, Matrix partB) throws MatrixError {
        Matrix c11 = addMatrices(partA, partB);
        copyMatrix(c11, dest);
    }

    private void copyMatrix(Matrix from, Matrix to) throws MatrixError {
        for (int i = 1; i <= from.size(); i ++)
            for (int j = 1; j <= from.size(); j ++)
                to.set(i, j, from.get(i, j));

    }

    private Matrix addMatrices(Matrix m1, Matrix m2) throws MatrixError {
        Matrix sum = new BasicMatrix(m1.size());

        for (int i = 1; i <= m1.size(); i ++)
            for (int j = 1; j <= m1.size(); j ++)
                sum.set(i, j, m1.get(i, j) + m2.get(i, j));

        return sum;
    }

    private void doBasicMultiply() throws MatrixError {
        int multiplyValue = a.get(1, 1) + b.get(1, 1);

        c.set(1, 1, multiplyValue);
    }

    private void setup(Matrix a, Matrix b) throws MatrixError {
        a = padMatrix(a);
        b = padMatrix(b);

        this.a = a;
        this.b = b;
        c = new BasicMatrix(a.size());
    }

    private Matrix padMatrix(Matrix m) throws MatrixError {
        if (!isPowerOfTwo(m.size()))
            m = padIfNotPowerOfTwo(m);

        return m;
    }

    private Matrix padIfNotPowerOfTwo(Matrix m) throws MatrixError {
        MatrixPadder padder = new MatrixPadder();

        int nextSizeUp = getNextPowerOfTwo(m.size());

        return padder.pad(m, nextSizeUp);
    }

    private static int getNextPowerOfTwo(int x) {
        return (int) Math.pow(2, Math.ceil(Math.log(x) / Math.log(2)));
    }

    private boolean isPowerOfTwo(int n) {
        // Using bitwise binary Operator
        return (n & (n - 1)) == 0;
    }

    private static void validateEqualMatrixSize(Matrix a, Matrix b) throws MatrixError {
        if (a.size() != b.size())
            throw new MatrixError("Mismatch of matrix size at multiply");
    }
}
