package uk.jlennie.algorithms.divide_and_conquer.max_sub_arr;

import java.util.List;

public class MaxSubArrayBruteForce implements MaxSubArray {
    SubArrayData maxVal;
    List<Double> arrayToSearch;

    @Override
    public SubArrayData getMaxSubArr(List<Double> arrayToSearch) {
        setup(arrayToSearch);

        searchForMaxVal(arrayToSearch);

        return maxVal;
    }

    private void searchForMaxVal(List<Double> arrayToSearch) {
        for (int i = 0; i < arrayToSearch.size(); i ++)
            iterateOverAllElementsAfterI(arrayToSearch, i);
    }

    private void iterateOverAllElementsAfterI(List<Double> arrayToSearch, int i) {
        for (int j = i; j < arrayToSearch.size(); j ++)
            considerUpdateMaxVal(i, j);
    }

    private void considerUpdateMaxVal(int i, int j) {
        if (haveNewMaxVal(i, j))
            updateMaxVal(i, j);
    }

    private boolean haveNewMaxVal(int i, int j) {
        return maxVal.getWeight() < getSum(i, j);
    }

    private void setup(List<Double> arrayToSearch) {
        if (arrayToSearch.isEmpty())
            throw new RuntimeException("Cannot run with empty array");

        this.arrayToSearch = arrayToSearch;
        maxVal = new SubArrayData(0, 0, -Double.MAX_VALUE);
    }

    private void updateMaxVal(int i, int j) {
        maxVal = new SubArrayData(i, j, getSum(i, j));
    }

    private double getSum(int i, int j) {
        double sum = 0;

        for (int k = i; k <= j; k ++) {
            sum += arrayToSearch.get(k);
        }

        return sum;
    }
}
