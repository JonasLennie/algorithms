package uk.jlennie.algorithms.divide_and_conquer.max_sub_arr;

import java.util.*;

public class MaxSubArrayComparison {

    private int inputSize;
    private boolean isDivideBetter;

    private long getRunTime(MaxSubArray implementation, List<Double> arr) {
        long startTime = System.nanoTime();

        implementation.getMaxSubArr(arr);

        return System.nanoTime() - startTime;
    }

    private boolean isDivideFasterForInputSize(int n) {
        List<Double> arr = getListOfSize(n);

        long bruteRun = getRunTime(new MaxSubArrayBruteForce(), arr);

        long divideRun = getRunTime(new MaxSubArrayDivide(), arr);

        System.out.println("Divide rt: " + divideRun + " Brute rt: " + bruteRun);

        return divideRun < bruteRun;
    }

    public int findInputSizeWhereDivideIsBetter() {
        isDivideBetter = false;
        inputSize = 0;

        while(!isDivideBetter)
            checkIfConsistentlyBetter();

        return inputSize;
    }

    private void checkIfConsistentlyBetter() {
        isDivideBetter = true;
        inputSize ++;
        isBetterOverTenRuns();
    }

    private void isBetterOverTenRuns() {
        for (int i = 0; i < 10; i ++)
            updateIsDivideBetterStillWithI();
    }

    private void updateIsDivideBetterStillWithI() {
        isDivideBetter &= isDivideFasterForInputSize(inputSize);
    }

    private List<Double> getListOfSize(int n) {
        List<Double> arr = new ArrayList<>();

        for (int i = 0; i < n; i ++)
            arr.add(Math.random());

        return arr;
    }
}
