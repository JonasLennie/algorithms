package uk.jlennie.algorithms.sorts;


import uk.jlennie.algorithms.search.InsertPosSearch;

import java.util.ArrayList;
import java.util.List;

public class FastInsertion extends Insertion {

    @Override
    protected void insertNextElement(int i) {
        int idealPos = getIdealPos(i);

        moveToIdealPos(i, idealPos);
    }

    private void moveToIdealPos(int i, int idealPos) {
        for (int j = i; j > idealPos; j --)
            swap(j, j - 1);
    }

    private int getIdealPos(int i) {
        InsertPosSearch<Integer> searcher = new InsertPosSearch<>();

        List<Integer> sortedSubList = getSortedSubList(i);

        return searcher.search(listToSort.get(i), sortedSubList);
    }

    private ArrayList<Integer> getSortedSubList(int i) {
        return new ArrayList<>(listToSort.subList(0, i));
    }

}
