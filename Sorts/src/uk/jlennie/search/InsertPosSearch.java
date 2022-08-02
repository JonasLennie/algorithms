package uk.jlennie.search;

import uk.jlennie.search.Abstractions.AbstractFactory;
import uk.jlennie.search.Abstractions.AbstractSearch;
import uk.jlennie.search.Abstractions.SearchInsertPos;
import uk.jlennie.search.BinarySearch.BinaryInsert;
import uk.jlennie.search.LinearSearch.LinearInsert;

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
