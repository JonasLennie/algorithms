package uk.jlennie.algorithms.divide_and_conquer.matrices;

import java.util.*;

public class BasicMatrix implements Matrix {
    int size;

    List<List<Integer>> values;

    public BasicMatrix(int size) throws MatrixError {
        errorOnNonPositiveSize(size);

        this.size = size;

        initValuesArray(size);
    }

    private void errorOnNonPositiveSize(int size) throws MatrixError {
        if (size <= 0)
            throw new MatrixError("Bad size for specified matrix");
    }

    private void initValuesArray(int size) {
        values = new ArrayList<>();

        addNNewListsToValues(size);
    }

    private void addNNewListsToValues(int size) {
        for (int i = 0; i < size; i ++)
            addNewListToValues();
    }

    private void addNewListToValues() {
        List<Integer> l = getNElementLongList();
        values.add(l);
    }

    private List<Integer> getNElementLongList() {
        List<Integer> l = new ArrayList<>();

        for (int j = 0; j < size; j ++)
            l.add(0);

        return l;
    }

    @Override
    public int get(int i, int j) throws MatrixError {
        getThrowBadIJ(i, j);

        return values.get(i - 1).get(j - 1);
    }

    private void getThrowBadIJ(int i, int j) throws MatrixError {
        if (badIJ(i, j))
            throw new MatrixError("Bad Get with invalid i, j");
    }

    private boolean badIJ(int i, int j) {
        return i <= 0 || j <= 0 || i > size || j > size;
    }

    private void setThrowBadIJ(int i, int j) throws MatrixError {
        if (badIJ(i, j))
            throw new MatrixError("Bad Set with invalid i, j");
    }

    @Override
    public int set(int i, int j, int val) throws MatrixError {
        setThrowBadIJ(i, j);

        return values.get(i - 1).set(j - 1, val);
    }

    @Override
    public int size() {
        return size;
    }
}
