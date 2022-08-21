package uk.jlennie.algorithms.sorts;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

abstract public class ReverseSortTest extends SortTest{
    @Override
    void sortAndAssertEq(List<Integer> input, List<Integer> expected){
        List<Integer> actual = sut.getSortedCopy(input);

        Collections.reverse(expected);

        assertArrayEquals(actual.toArray(), expected.toArray());
    }
}
