package uk.jlennie.algorithms.search.Abstractions;

import java.util.List;

public class InsertPosUtils<T extends Comparable<T>> {
    List<T> listToSearch;
    T target;

    public boolean isAMatch(int i, List<T> listToSearch, T target) {
        setup(listToSearch, target);

        boolean zeroIndexLargerThanTarget = gteq(i) && i == 0;
        boolean TargetFitsAtIndexI = gteq(i) && lt(i - 1);
        boolean LastValSmallerThanTarget = lt(i) && i == listToSearch.size() - 1;

        return zeroIndexLargerThanTarget || TargetFitsAtIndexI || LastValSmallerThanTarget;
    }

    private void setup(List<T> listToSearch, T target) {
        this.listToSearch = listToSearch;
        this.target = target;
    }

    public int getReturnValue(int i, List<T> listToSearch, T target) {
        setup(listToSearch, target);

        boolean zeroIndexLargerThanTarget = gteq(i) && i == 0;
        boolean TargetFitsAtIndexI = gteq(i) && lt(i - 1);
        boolean LastValSmallerThanTarget = lt(i) && i == listToSearch.size() - 1;

        if (zeroIndexLargerThanTarget)
            return 0;
        if (TargetFitsAtIndexI)
            return i;
        if (LastValSmallerThanTarget)
            return listToSearch.size();
        return -1;
    }

    private boolean gteq(int index) {
        return inValidBound(index) && compar(index) >= 0;
    }

    private boolean lt(int index) {
        return inValidBound(index) && compar(index) < 0;
    }

    private boolean inValidBound(int index) {
        return index >= 0 && index < listToSearch.size();
    }

    private int  compar(int index) {
        return listToSearch.get(index).compareTo(target);
    }
}
