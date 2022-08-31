package uk.jlennie.algorithms.divide_and_conquer.max_sub_arr;

import java.util.List;

public class MaxSubArrayDivide implements MaxSubArray {
    List<Double> arr;

    @Override
    public SubArrayData getMaxSubArr(List<Double> arraySearch) {
        arr = arraySearch;
        return findMaxSub(0, arr.size() - 1);
    }

    private SubArrayData findMaxSub(int lo, int hi) {
        if (hi <= lo)
            return new SubArrayData(lo, hi, arr.get(lo));
        else {
            return findMaxSubSafeBounds(lo, hi);
        }
    }

    private SubArrayData findMaxSubSafeBounds(int lo, int hi) {
        int mid = (lo + hi) / 2;

        SubArrayData leftMax = findMaxSub(lo, mid);
        SubArrayData rightMax = findMaxSub(mid + 1, hi);
        SubArrayData midMax = findMaxAtCrossing(lo, mid, hi);

        return getMax(leftMax, rightMax, midMax);
    }

    private static SubArrayData getMax(SubArrayData leftMax, SubArrayData rightMax, SubArrayData midMax) {
        if (leftMax.getWeight() >= rightMax.getWeight() && leftMax.getWeight() >= midMax.getWeight())
            return leftMax;
        else if (midMax.getWeight() >= rightMax.getWeight())
            return midMax;
        else
            return rightMax;
    }

    private SubArrayData findMaxAtCrossing(int lo, int mid, int hi) {
        SubArrayData left = checkLeftHalf(lo, mid);

        SubArrayData right = checkRightHalf(mid, hi);

        return getCombined(left, right);
    }

    private static SubArrayData getCombined(SubArrayData left, SubArrayData right) {
        return new SubArrayData(left.getStartIndex(), right.getEndIndex(), left.getWeight() + right.getWeight());
    }

    private SubArrayData checkRightHalf(int mid, int hi) {
        SubArrayData right = new SubArrayData(0, 0, -Double.MAX_VALUE);
        double sum = 0.0;

        for (int i = mid + 1; i <= hi; i ++) {
            sum += arr.get(i);
            right = update(i, right, sum, mid + 1);
        }

        return right;
    }

    private SubArrayData checkLeftHalf(int lo, int mid) {
        SubArrayData left = new SubArrayData(0, 0, -Double.MAX_VALUE);
        double sum = 0.0;

        for (int i = mid; i >= lo; i --) {
            sum += arr.get(i);
            left = update(mid, left, sum, i);
        }

        return left;
    }

    private static SubArrayData update(int hiBound, SubArrayData target, double current, int loBound) {
        if (current > target.getWeight())
            target = new SubArrayData(loBound, hiBound, current);

        return target;
    }
}
