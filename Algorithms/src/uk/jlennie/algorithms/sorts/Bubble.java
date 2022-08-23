package uk.jlennie.algorithms.sorts;

import java.util.ArrayList;
import java.util.List;

public class Bubble implements Sort {
    boolean didSwap;
    List<Integer> arrayBeingSorted;
    int upperBound;

    public Bubble() {
        didSwap = true;
        upperBound = 0;
    }

    @Override
    public List<Integer> getSortedCopy(List<Integer> arrayToSort) {
        setup(arrayToSort);

        runSort();

        return arrayBeingSorted;
    }

    private void setup(List<Integer> arrayToSort) {
        arrayBeingSorted = new ArrayList<>(arrayToSort);
        upperBound = arrayBeingSorted.size() - 1;
    }

    private void runSort() {
        while(didSwap)
            walkOverList();
    }

    private void walkOverList() {
        didSwap = false;

        for (int i = 0; i < upperBound; i ++)
            checkForSwap(i);

       upperBound --;
    }

    private void checkForSwap(int i) {
        if (shouldSwapAtI(i))
            swap(i);
    }

    private boolean shouldSwapAtI(int i) {
        return arrayBeingSorted.get(i) > arrayBeingSorted.get(i + 1);
    }

    private void swap(int i) {
        didSwap = true;

        int tmp = arrayBeingSorted.get(i);

        arrayBeingSorted.set(i, arrayBeingSorted.get(i + 1));
        arrayBeingSorted.set(i + 1, tmp);
    }
}
