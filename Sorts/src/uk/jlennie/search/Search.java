package uk.jlennie.search;

import uk.jlennie.search.Abstractions.AbstractFactory;
import uk.jlennie.search.Abstractions.AbstractSearch;
import uk.jlennie.search.BinarySearch.BinarySearch;
import uk.jlennie.search.LinearSearch.LinearSearch;
import uk.jlennie.search.Abstractions.SearchList;

import java.util.Optional;

public class Search<T extends Comparable<T>> extends AbstractFactory<T, Optional<Integer>> implements SearchList<T> {
    @Override
    protected AbstractSearch<T, Optional<Integer>> getBinaryAlgo() {
        return new BinarySearch<>();
    }

    @Override
    protected AbstractSearch<T, Optional<Integer>> getLinearAlgo() {
        return new LinearSearch<>();
    }
}
