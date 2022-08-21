package uk.jlennie.algorithms.search.Abstractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class SearchListTest {
    protected SearchList<Integer> sut;

    @BeforeEach
    protected abstract void setUp();

    void makeAssertion(List<Integer> l, Integer target, Optional<Integer> expected) {
        Optional<Integer> result = sut.search(target, l);

        assertEquals(result, expected);
    }

    @Test
    void workOnEmptyList(){
        makeAssertion(Collections.emptyList(), 0, Optional.empty());
    }

    @Test
    void integerMatch() {
        List<Integer> l = listOneToTen();

        makeAssertion(l, 5, Optional.of(4));
    }

    List<Integer> listOneToTen() {
        List<Integer> listOneToTen = new ArrayList<>();

        for (int i = 1; i <= 10; i ++)
            listOneToTen.add(i);

        return listOneToTen;
    }

    @Test
    void noMatch() {
        List<Integer> l = listOneToTen();

        makeAssertion(l, 11, Optional.empty());
    }

    @Test
    void firstElementMatch() {
        List<Integer> l = listOneToTen();

        makeAssertion(l, 1, Optional.of(0));
    }

    @Test
    void lastElementMatch() {
        List<Integer> l = listOneToTen();

        makeAssertion(l, 10, Optional.of(9));
    }

    @Test
    void randomListAllMatch() {
        List<Integer> l = getRandomList();

        int index = 0;

        for (int n : l)
            makeAssertion(l, n, Optional.of(index++));
    }

    List<Integer> getRandomList() {
        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(7);
        l.add(3);
        l.add(11);
        l.add(-1);
        return l;
    }

    @Test
    void randomListAssortedFailures() {
        List<Integer> l = getRandomList();

        makeAssertion(l, 0, Optional.empty());
        makeAssertion(l, -5, Optional.empty());
        makeAssertion(l, 22, Optional.empty());
    }
}