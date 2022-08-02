package uk.jlennie.sorts;

import java.util.ArrayList;
import java.util.List;

public class Insertion implements Sort {
    List<Integer> listToSort;

    public List<Integer> getSortedCopy(List<Integer> arrayToSort) {
        listToSort = new ArrayList<>(arrayToSort);

        for (int i = 1; i < listToSort.size(); i ++)
            insertNextElement(i);

        return listToSort;
    }

    protected void insertNextElement(int i) {
        int index = i;

        while (currentIndexIsSmallerThanBefore(index)) {
            swap(index, index - 1);

            index --;
        }
    }

    protected boolean currentIndexIsSmallerThanBefore(int index) {
        if (index <= 0)
            return false;

        return listToSort.get(index) < listToSort.get(index - 1);
    }

    protected void swap(int firstIndex, int secondIndex) {
        int tmp = listToSort.get(firstIndex);

        listToSort.set(firstIndex, listToSort.get(secondIndex));
        listToSort.set(secondIndex, tmp);
    }
}
