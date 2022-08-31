package uk.jlennie.algorithms.divide_and_conquer.max_sub_arr;

public class Driver {
    public static void main(String[] args) {
        MaxSubArrayComparison compar = new MaxSubArrayComparison();

        int n = compar.findInputSizeWhereDivideIsBetter();

        System.out.println(n);
    }
}
