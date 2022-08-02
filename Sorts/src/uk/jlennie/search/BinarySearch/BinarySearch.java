package uk.jlennie.search.BinarySearch;

import uk.jlennie.search.Abstractions.SearchList;

import java.util.Optional;

public class BinarySearch <T extends Comparable<T>> extends AbstractBinary<T, Optional<Integer>> implements SearchList<T> {

    @Override
    Optional<Integer> emptyListVal() {
        return Optional.empty();
    }

    @Override
    Optional<Integer> nullValue() {
        return Optional.empty();
    }

    @Override
    Optional<Integer> onMatchChooseReturn(int mid) {
        return Optional.of(mid);
    }

    @Override
    boolean isTargetFound(int mid) {
        return searchList.get(mid).compareTo(target) == 0;
    }

    @Override
    Optional<Integer> withResultsChooseReturn(Optional<Integer> loResult, Optional<Integer> hiResult) {
        if (loResult.isPresent())
            return loResult;
        else
            return hiResult;
    }
}