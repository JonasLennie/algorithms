package uk.jlennie.algorithms.misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoElementsSumTest {
    TwoElementsSum sut;
    List<Integer> l;

    @BeforeEach
    void setUp() {
        sut = new TwoElementsSum();
        l = new ArrayList<>();
    }

    @Test
    void doTwoElementsSumEmptyList() {
        // l is empty by default

        makeAssertion(l, 0, false);
    }

    @Test
    void oneElementList() {
        l.add(0);

        makeAssertion(l, 0, false);
    }

    @Test
    void wholeListSumsButNotTwo() {
        l.add(1);
        l.add(2);
        l.add(3);

        makeAssertion(l, 6, false);
    }

    @Test
    void notProduct() {
        l.add(2);
        l.add(3);

        makeAssertion(l, 6, false);
    }

    @Test
    void twoElementsExactAndZero() {
        l.add(5);
        l.add(0);

        makeAssertion(l, 5, true);
    }

    @Test
    void passesWithNegatives() {
        l.add(3);
        l.add(-5);

        makeAssertion(l, -2, true);
    }

    @Test
    void passesWithALongList() {
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(5);

        makeAssertion(l, 5, true);
    }

    @Test
    void passesWithNonAdjacentElements() {
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(5);

        makeAssertion(l, 6, true);
    }

    @Test
    void multipleSolutionsNoIssues() {
        l.add(1);
        l.add(4);
        l.add(3);
        l.add(2);

        makeAssertion(l, 5, true);
    }

    private void makeAssertion(List<Integer> l, Integer target, boolean expected) {
        boolean result = sut.doTwoElementsSum(l, target);

        assertEquals(expected, result);
    }
}