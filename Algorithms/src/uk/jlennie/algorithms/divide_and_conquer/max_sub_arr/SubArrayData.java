package uk.jlennie.algorithms.divide_and_conquer.max_sub_arr;

import java.util.*;

public class SubArrayData {
    private final int startIndex;
    private final int endIndex;
    private final double weight;

    public SubArrayData(int startIndex, int endIndex, double weight) {
        if (startIndex > endIndex)
            throw new RuntimeException("Bad Array Bounds");

        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.weight = weight;
    }

    public boolean isEqual(int start, int end, double weight) {
        return startIndex == start
                && endIndex == end
                && this.weight == weight;
    }

    public List<Double> makeSubArray(List<Double> arr) {
        return new ArrayList<>(arr).subList(startIndex, endIndex + 1);
    }

    public double getWeight() {
        return weight;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }
}
