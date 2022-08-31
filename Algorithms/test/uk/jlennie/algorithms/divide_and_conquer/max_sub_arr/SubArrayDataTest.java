package uk.jlennie.algorithms.divide_and_conquer.max_sub_arr;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SubArrayDataTest {
    SubArrayData sut;

    @Test
    void testIsEqual() {
        sut = new SubArrayData(5, 10, 123);

        assertTrue(sut.isEqual(5, 10, 123));
    }

    @Test
    void testThrowOnBadBounds() {
        assertThrows(RuntimeException.class, () -> new SubArrayData(6, 5, 110));
    }

    @Test
    void testNoThrowOnEqualBounds() {
        assertDoesNotThrow(() -> new SubArrayData(6, 6, 100));
    }

    @Test
    void testEqualsOnEqualBounds() {
        sut = new SubArrayData(6, 6, 100);

        assertTrue(sut.isEqual(6, 6, 100));
    }

    @Test
    void testCreateSubArray() {
        sut = new SubArrayData(3, 5, 100);
        List<Double> testData = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));

        List<Double> result = sut.makeSubArray(testData);
        List<Double> expected = new ArrayList<>(Arrays.asList(4.0, 5.0, 6.0));

        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    void testCreateSubArrayEqualBounds() {
        sut = new SubArrayData(1, 1, 10);
        List<Double> testData = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0));

        List<Double> result = sut.makeSubArray(testData);
        List<Double> expected = new ArrayList<>(Collections.singleton(2.0));

        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    void testGetWeight() {
        sut = new SubArrayData(5, 7, 14.0);

        assertEquals(14.0, sut.getWeight());
    }

    @Test
    void testGetStartIndex() {
        sut = new SubArrayData(5, 7, 14.0);

        assertEquals(5, sut.getStartIndex());
    }

    @Test
    void testGetEndIndex() {
        sut = new SubArrayData(5, 7, 14.0);

        assertEquals(7, sut.getEndIndex());
    }

}