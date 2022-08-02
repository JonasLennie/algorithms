package uk.jlennie.search.LinearSearch;

import uk.jlennie.search.Abstractions.SearchList;

import java.util.Optional;

public class LinearSearch<T extends Comparable<T>> extends AbstractLinear<T, Optional<Integer>> implements SearchList<T> {


    @Override
    Optional<Integer> nullValue() {
        return Optional.empty();
    }

    @Override
    Optional<Integer> getReturnValue(int i) {
        return Optional.of(i);
    }

    @Override
    boolean isAMatch(int i) {
        return target.compareTo(listToSearch.get(i)) == 0;
    }
}
