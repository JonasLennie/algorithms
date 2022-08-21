package uk.jlennie.algorithms.misc;

import uk.jlennie.algorithms.search.Search;

import java.util.List;
import java.util.Optional;

public class TwoElementsSum {
    List<Integer> listToSearch;
    Integer target;

    public boolean doTwoElementsSum(List<Integer> listToSearch, Integer target) {
        setup(listToSearch, target);

        return searchListForTwoMatches(listToSearch);
    }

    private boolean searchListForTwoMatches(List<Integer> listToSearch) {
        for (int i = 0; i < listToSearch.size(); i++)
            if (canMakeSum(listToSearch, i))
                return true;

        return false;
    }

    private boolean canMakeSum(List<Integer> listToSearch, int i) {
        int valToFind = getValToFind(i);

        Optional<Integer> searchResult = getSearchResult(listToSearch, i, valToFind);

        return searchResult.isPresent();
    }

    private Optional<Integer> getSearchResult(List<Integer> listToSearch, int i, int valToFind) {
        Search<Integer> s = new Search<>();
        return s.search(valToFind, listToSearch.subList(i + 1, listToSearch.size()));
    }

    private void setup(List<Integer> listToSearch, Integer target) {
        this.listToSearch = listToSearch;
        this.target = target;
    }

    private int getValToFind(int i) {
        return target - listToSearch.get(i);
    }

}
