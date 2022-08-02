package uk.jlennie.search.Abstractions;

import uk.jlennie.search.BinarySearch.BinarySearch;
import uk.jlennie.search.LinearSearch.LinearSearch;

import java.util.List;
import java.util.Optional;

abstract public class AbstractFactory<T extends Comparable<T>, R> implements AbstractSearch<T, R>{
    @Override
    public R search(T target, List<T> listToSearch) {
        AbstractSearch<T, R> searchAlgo;

        if (isSorted(listToSearch)) {
            searchAlgo = getBinaryAlgo();
        }
        else {
            searchAlgo = getLinearAlgo();
        }
        return searchAlgo.search(target, listToSearch);

    }

    protected abstract AbstractSearch<T, R> getBinaryAlgo();
    protected abstract AbstractSearch<T, R> getLinearAlgo();

    private boolean isSorted(List<T> listToSearch) {
        for (int i = 0; i < listToSearch.size() - 1; i ++) {
            if (listToSearch.get(i).compareTo(listToSearch.get(i + 1)) > 0)
                return false;
        }
        return true;
    }
}
