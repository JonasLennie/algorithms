package uk.jlennie.algorithms.search;

import uk.jlennie.algorithms.search.Abstractions.AbstractFactory;
import uk.jlennie.algorithms.search.Abstractions.AbstractSearch;
import uk.jlennie.algorithms.search.Abstractions.SearchInsertPos;
import uk.jlennie.algorithms.search.BinarySearch.BinaryInsert;
import uk.jlennie.algorithms.search.LinearSearch.LinearInsert;

public class InsertPosSearch<T extends Comparable<T>> extends AbstractFactory<T, Integer> implements SearchInsertPos<T> {
    @Override
    protected AbstractSearch<T, Integer> getBinaryAlgo() {
        return new BinaryInsert<>();
    }

    @Override
    protected AbstractSearch<T, Integer> getLinearAlgo() {
        return new LinearInsert<>();
    }
}
