package uk.jlennie.algorithms.search.LinearSearch;

import uk.jlennie.algorithms.search.Abstractions.InsertPosUtils;
import uk.jlennie.algorithms.search.Abstractions.SearchInsertPos;

public class LinearInsert<T extends Comparable<T>> extends AbstractLinear<T, Integer> implements SearchInsertPos<T>{


    public boolean isAMatch(int i) {
        InsertPosUtils<T> utils = new InsertPosUtils<>();
        return utils.isAMatch(i, listToSearch, target);
    }

    @Override
    public Integer nullValue() {
        return 0;
    }

    public Integer getReturnValue(int i) {
        InsertPosUtils<T> utils = new InsertPosUtils<>();
        return utils.getReturnValue(i, listToSearch, target);
    }

}
