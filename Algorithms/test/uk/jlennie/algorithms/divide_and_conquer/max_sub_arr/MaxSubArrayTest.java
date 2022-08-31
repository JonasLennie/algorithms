package uk.jlennie.algorithms.divide_and_conquer.max_sub_arr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

abstract class MaxSubArrayTest {
    protected MaxSubArray sut;

    @BeforeEach
    abstract void setup();

    @Test
    void testThrowsWithEmptyList() {
        assertThrows(RuntimeException.class, () -> sut.getMaxSubArr(new ArrayList<>()));
    }

    @Test
    void testSingletonReturnsOne() {
        SubArrayData result = sut.getMaxSubArr(Collections.singletonList(1.0));

        assertTrue(result.isEqual(0, 0, 1));
    }

    @Test
    void testAllNegativeReturnsSmallestNegative() {
        List<Double> testData = Arrays.asList(-5.0, -7.1, -18.2, -3.0, -6.3);

        SubArrayData result = sut.getMaxSubArr(testData);

        assertTrue(result.isEqual(3, 3, -3.0));
    }

    @Test
    void allPositiveReturnsFullList() {
        List<Double> testData = Arrays.asList(5.0, 10.0, 8.0, 2.0);

        SubArrayData result = sut.getMaxSubArr(testData);

        assertTrue(result.isEqual(0, 3, 25.0));
    }

    @Test
    void twoInstancesReturnsFirst() {
        List<Double> testData = Arrays.asList(10.0, 12.0, -5.0, -20.0, 11.0, -3.0, 14.0);

        SubArrayData result = sut.getMaxSubArr(testData);

        assertTrue(result.isEqual(0, 1, 22.0));
    }

    @Test
    void testExpectedOnRandomSet() {
        List<Double> testData = Arrays.asList(-5.0, 7.0, 3.0, 8.0, -5.0, 7.0, -6.0, -3.0, 6.0, -4.0);

        SubArrayData result = sut.getMaxSubArr(testData);

        assertTrue(result.isEqual(1, 5, 20));
    }

}