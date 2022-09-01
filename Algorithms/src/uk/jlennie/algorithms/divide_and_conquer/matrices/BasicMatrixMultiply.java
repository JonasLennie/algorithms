package uk.jlennie.algorithms.divide_and_conquer.matrices;

public class BasicMatrixMultiply implements MatrixMultiply {

    private Matrix c;
    private int size;
    private Matrix a;
    private Matrix b;

    @Override
    public Matrix multiply(Matrix a, Matrix b) throws MatrixError {
        throwIfSizeNotEqual(a, b);

        setup(a, b);

        doMultiply();

        return c;
    }

    private void setup(Matrix a, Matrix b) throws MatrixError {
        this.a = a;
        this.b = b;
        size = a.size();
        c = new BasicMatrix(size);
    }

    private void doMultiply() throws MatrixError {
        for (int i = 1; i <= size; i ++)
            setRowI(i);
    }

    private void setRowI(int i) throws MatrixError {
        for (int j = 1; j <= size; j ++)
            setCij(i, j);
    }

    private void setCij(int i, int j) throws MatrixError {
        int val = 0;

        for (int k = 1; k <= size; k ++)
            val += a.get(i, k) * b.get(k, j);

        c.set(i, j, val);
    }

    private static void throwIfSizeNotEqual(Matrix a, Matrix b) throws MatrixError {
        if (a.size() != b.size())
            throw new MatrixError("Mismatch of matrix size at multiply");
    }
}
