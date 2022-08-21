package uk.jlennie.algorithms.search;

import uk.jlennie.algorithms.search.Abstractions.AbstractFactory;
import uk.jlennie.algorithms.search.Abstractions.AbstractSearch;
import uk.jlennie.algorithms.search.Abstractions.SearchList;
import uk.jlennie.algorithms.search.BinarySearch.BinarySearch;
import uk.jlennie.algorithms.search.LinearSearch.LinearSearch;

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
