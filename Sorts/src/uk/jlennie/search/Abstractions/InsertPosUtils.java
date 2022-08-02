package uk.jlennie.search.Abstractions;

import java.util.List;

public class InsertPosUtils<T extends Comparable<T>> {
    List<T> listToSearch;
    T target;

    public boolean isAMatch(int i, List<T> listToSearch, T target) {
        setup(listToSearch, target);

        boolean smol = gt(i) && i == 0;
        boolean basecase = gt(i) && lt(i - 1);
        boolean chonk = lt(i) && i == listToSearch.size() - 1;

        return smol || basecase || chonk;
    }

    private void setup(List<T> listToSearch, T target) {
        this.listToSearch = listToSearch;
        this.target = target;
    }

    public int getReturnValue(int i, List<T> listToSearch, T target) {
        setup(listToSearch, target);

        boolean smol = gt(i) && i == 0;
        boolean basecase = gt(i) && lt(i - 1);
        boolean chonk = lt(i) && i == listToSearch.size() - 1;

        if (smol)
            return 0;
        if (basecase)
            return i;
        if (chonk)
            return listToSearch.size();
        return -1;
    }

    private boolean gt(int i) {
        return (i >= 0 && i < listToSearch.size()) && compar(i) >= 0;
    }

    private boolean lt(int i) {
        return (i >= 0 && i < listToSearch.size()) && compar(i) < 0;
    }

    private int  compar(int i) {
        return listToSearch.get(i).compareTo(target);
    }
}
