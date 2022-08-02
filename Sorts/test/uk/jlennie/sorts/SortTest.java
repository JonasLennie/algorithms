package uk.jlennie.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

abstract class SortTest {
    Sort sut;

    void sortAndAssertEq(List<Integer> input, List<Integer> expected){
        List<Integer> actual = sut.getSortedCopy(input);

        assertArrayEquals(actual.toArray(), expected.toArray());
    }

    @org.junit.jupiter.api.Test
    void sortOnEmpty() {
        List<Integer> empty = new ArrayList<>();

        sortAndAssertEq(empty, Collections.emptyList());
    }

    @org.junit.jupiter.api.Test
    void sortLotsOfSame() {
        List<Integer> manyFives = getManyFivesList();

        sortAndAssertEq(manyFives, manyFives);
    }

    @org.junit.jupiter.api.Test
    void sortsOrderedList() {
        List<Integer> orderedList = getOrderedList();

        sortAndAssertEq(orderedList, orderedList);
    }

    @org.junit.jupiter.api.Test
    void sortsReversedList() {
        List<Integer> reversedList = getReversedList();

        List<Integer> sortedList = getSortedList(reversedList);

        sortAndAssertEq(reversedList, sortedList);
    }

    @org.junit.jupiter.api.Test
    void sortRandomList() {
        List<Integer> randomList = populateRandomList();

        List<Integer> sortedList = getSortedList(randomList);

        sortAndAssertEq(randomList, sortedList);
    }

    @org.junit.jupiter.api.BeforeEach
    abstract void setUp();

    private List<Integer> getManyFivesList() {
        List<Integer> manyFives = new ArrayList<>();
        for (int i = 0; i < 5; i ++)
            manyFives.add(5);

        return manyFives;
    }

    private List<Integer> getOrderedList() {
        List<Integer> orderedList = new ArrayList<>();
        for (int i = 0; i < 5; i ++)
            orderedList.add(i);
        return orderedList;
    }

    private List<Integer> getReversedList() {
        List<Integer> reversedList = new ArrayList<>();
        for (int i = 5; i > 0; i --)
            reversedList.add(i);
        return reversedList;
    }

    private List<Integer> getSortedList(List<Integer> randomList) {
        List<Integer> sortedList = new ArrayList<>(randomList);

        sortedList.sort(null);
        return sortedList;
    }

    private List<Integer> populateRandomList() {
        List<Integer> randomList = new ArrayList<>();
        randomList.add(3);
        randomList.add(0);
        randomList.add(1);
        randomList.add(2);
        randomList.add(4);
        return randomList;
    }
}