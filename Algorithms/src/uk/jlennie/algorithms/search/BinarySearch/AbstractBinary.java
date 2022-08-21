package uk.jlennie.algorithms.search.BinarySearch;

import uk.jlennie.algorithms.search.Abstractions.AbstractSearch;

import java.util.List;

public abstract class AbstractBinary<T extends Comparable<T>, R> implements AbstractSearch<T, R> {
    List<T> searchList;
    T target;

    public R search(T target, List<T> listToSearch) {
        searchList = listToSearch;
        this.target = target;

        if (listToSearch.size() == 0)
            return emptyListVal();

        return binSearch(0, searchList.size() - 1);
    }

    abstract R emptyListVal();


    R binSearch(int loIndex, int hiIndex) {
        if (loIndex > hiIndex)
            return nullValue();

        return nonTrivialBinaryS(loIndex, hiIndex);
    }

    abstract R nullValue();

    R nonTrivialBinaryS(int loIndex, int hiIndex) {
        int mid = (loIndex + hiIndex) / 2;

        if (isTargetFound(mid))
            return onMatchChooseReturn(mid);

        return SearchUpperAndLower(loIndex, hiIndex, mid);
    }

    abstract R onMatchChooseReturn(int mid);

    abstract boolean isTargetFound(int mid);

    R SearchUpperAndLower(int loIndex, int hiIndex, int mid) {
        R loResult = binSearch(loIndex, mid - 1);
        R hiResult = binSearch(mid + 1, hiIndex);

        return withResultsChooseReturn(loResult, hiResult);
    }

    abstract R withResultsChooseReturn(R loResult, R hiResult);
}
