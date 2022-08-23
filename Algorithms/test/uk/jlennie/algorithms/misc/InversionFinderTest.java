package uk.jlennie.algorithms.misc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InversionFinderTest {
    InversionFinder<Integer> sut;

    void makeAssertion(int expected, int ...list) {
        sut = new InversionFinder<>();

        assertEquals(expected, sut.countInversions(Arrays.stream(list).boxed().toList()));
    }

    @Test
    void emptyListHasNoInversions() {
        makeAssertion(0);
    }

    @Test
    void singletonListHasNoInversions() {
        makeAssertion(0, 1);
        makeAssertion(0, -1);
    }

    @Test
    void sortedListHasNoInversions() {
        makeAssertion(0, 1, 2, 3);
        makeAssertion(0, -5, 17, 28, 53);
    }

    @Test
    void swappedPairHasOneInversion() {
        makeAssertion(1, 3, 2);
    }

    @Test
    void sortedExceptForOneHasOneInversion() {
        makeAssertion(1, 1, 3, 2, 4);
    }

    @Test
    void reversedListHasSumNMinusOneInversions() {
        makeAssertion(6, 4, 3, 2, 1);
        makeAssertion(10, 5, 4, 3, 2, 1);
    }

    @Test
    void someRandomList() {
        makeAssertion(10, 6, 3, 7, 2, 6, 1, 7);
    }

}