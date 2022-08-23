package uk.jlennie.algorithms.sorts;

import java.util.*;

public class Hybrid extends Merge{
    int k;

    public Hybrid(int k) {
        this.k = k;
    }

    @Override
    protected void mergeSort(int loIndex, int hiIndex) {
        if (hiIndex - loIndex <= k)
            insertionSmaller(loIndex, hiIndex);
        else
            sortLargeBounds(loIndex, hiIndex);
    }

    private void insertionSmaller(int loIndex, int hiIndex) {
        if (loIndex < hiIndex)
            sortWithInsertion(loIndex, hiIndex);
    }

    private void sortWithInsertion(int loIndex, int hiIndex) {
        List<Integer> sortedSubList = getSortedSubList(loIndex, hiIndex);

        addSortedSubListToArrayBeingSorted(loIndex, hiIndex, sortedSubList);
    }

    private void addSortedSubListToArrayBeingSorted(int loIndex, int hiIndex, List<Integer> sortedSubList) {
        for (int i = loIndex; i <= hiIndex; i ++)
            arrayBeingSorted.set(i, sortedSubList.get(i - loIndex));
    }

    private List<Integer> getSortedSubList(int loIndex, int hiIndex) {
        Insertion sorter = new Insertion();
        return sorter.getSortedCopy(arrayBeingSorted.subList(loIndex, hiIndex + 1));
    }
}
