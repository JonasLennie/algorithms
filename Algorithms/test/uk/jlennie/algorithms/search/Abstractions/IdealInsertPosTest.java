package uk.jlennie.algorithms.search.Abstractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public abstract class IdealInsertPosTest extends SearchListTest {
    protected SearchInsertPos<Integer> sut;

    @BeforeEach
    protected abstract void setUp();

    void makeAssertion(List<Integer> l, Integer target, Integer expected) {
        Integer result = sut.search(target, l);

        assertEquals(result, expected);
    }

    @Test
    void workOnEmptyList(){
        makeAssertion(Collections.emptyList(), 0, 0);
    }

    @Test
    void integerMatch() {
        List<Integer> l = listOneToTen();

        makeAssertion(l, 5, 4);
    }

    @Test
    void noMatch() {
        List<Integer> l = listOneToTen();

        makeAssertion(l, 11, 10);
    }

    @Test
    void firstElementMatch() {
        List<Integer> l = listOneToTen();

        makeAssertion(l, 1, 0);
    }

    @Test
    void lastElementMatch() {
        List<Integer> l = listOneToTen();

        makeAssertion(l, 10, 9);
    }

    @Test
    void randomListAllMatch() {
        List<Integer> l = getRandomList();
        l.sort(null);

        int index = 0;

        for (int n : l)
            makeAssertion(l, n, index++);
    }

    @Test
    void randomListAssortedFailures() {
        List<Integer> l = getRandomList();
        l.sort(null);

        makeAssertion(l, 0, 1);
        makeAssertion(l, -5, 0);
        makeAssertion(l, 22, 5);
    }
}