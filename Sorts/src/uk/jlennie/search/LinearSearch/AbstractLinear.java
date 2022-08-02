package uk.jlennie.search.LinearSearch;

import uk.jlennie.search.Abstractions.AbstractSearch;

import java.util.List;

abstract public class AbstractLinear<T extends Comparable<T>, R> implements AbstractSearch<T, R> {
    List<T> listToSearch;
    T target;

    public R search(T target, List<T> listToSearch) {
        this.listToSearch = listToSearch;
        this.target = target;

        for (int i = 0; i < listToSearch.size(); i ++)
            if (isAMatch(i))
                return getReturnValue(i);

        return nullValue();
    }

    abstract R nullValue();

    abstract R getReturnValue(int i);

    abstract boolean isAMatch(int i);
}
