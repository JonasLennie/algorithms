package uk.jlennie.search.BinarySearch;

import uk.jlennie.search.Abstractions.InsertPosUtils;
import uk.jlennie.search.Abstractions.SearchInsertPos;

public class BinaryInsert<T extends Comparable<T>> extends AbstractBinary<T, Integer> implements SearchInsertPos<T> {
    @Override
    Integer emptyListVal() {
        return 0;
    }

    @Override
    Integer nullValue() {
        return -1;
    }

    @Override
    Integer onMatchChooseReturn(int i) {
        InsertPosUtils<T> utils = new InsertPosUtils<>();
        return utils.getReturnValue(i, searchList, target);
    }

    @Override
    boolean isTargetFound(int i) {
        InsertPosUtils<T> utils = new InsertPosUtils<>();
        return utils.isAMatch(i, searchList, target);
    }

    @Override
    Integer withResultsChooseReturn(Integer loResult, Integer hiResult) {
        if (loResult != -1)
            return loResult;
        else
            return hiResult;

    }
}
