package uk.jlennie.sorts;

import java.util.ArrayList;
import java.util.List;

public class RecursiveInsertion implements Sort {
    List<Integer> arrayBeingSorted;

    @Override
    public List<Integer> getSortedCopy(List<Integer> arrayToSort) {
        arrayBeingSorted = new ArrayList<>(arrayToSort);

        arrayBeingSorted = insert(arrayBeingSorted);

        return arrayBeingSorted;
    }

    private List<Integer> insert(List<Integer> listBeingSorted) {
        if (listBeingSorted.size() <= 1)
            return listBeingSorted;

        return insertNontrivialList(listBeingSorted);
    }

    private List<Integer> insertNontrivialList(List<Integer> listBeingSorted) {
        List<Integer> unsortedSubList = getUnsortedSubList(listBeingSorted);

        List<Integer> subList = insert(unsortedSubList);

        return insertIntoExisting(subList, getValueToInsert(listBeingSorted));
    }

    private Integer getValueToInsert(List<Integer> listBeingSorted) {
        return listBeingSorted.get(listBeingSorted.size() - 1);
    }

    private ArrayList<Integer> getUnsortedSubList(List<Integer> listBeingSorted) {
        return new ArrayList<>(listBeingSorted.subList(0, listBeingSorted.size() - 1));
    }

    private List<Integer> insertIntoExisting(List<Integer> subList, Integer valueToInsert) {
        List<Integer> newList = new ArrayList<>(subList);
        newList.add(valueToInsert);

        int indexOfValue = newList.size() - 1;

        while(indexOfValue > 0 && newList.get(indexOfValue) < newList.get(indexOfValue - 1))
            moveValueDownOne(newList, valueToInsert, indexOfValue --);

        return newList;
    }

    private void moveValueDownOne(List<Integer> subList, Integer valueToInsert, int indexOfValue) {
        subList.set(indexOfValue, subList.get(indexOfValue - 1));
        subList.set(indexOfValue - 1, valueToInsert);
    }

}
