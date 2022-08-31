package uk.jlennie.algorithms.divide_and_conquer.matrices;

public interface Matrix {
    int get(int i, int j) throws MatrixError;

    int set(int i, int j, int val) throws MatrixError;

    int size();
}
