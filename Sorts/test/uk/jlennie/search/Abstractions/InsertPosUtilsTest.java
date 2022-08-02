package uk.jlennie.search.Abstractions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.jlennie.search.Abstractions.InsertPosUtils;

import java.util.ArrayList;
import java.util.List;

class InsertPosUtilsTest {
    List<Integer> testArr;
    InsertPosUtils<Integer> sut;

    @BeforeEach
    void setUp() {
        testArr = new ArrayList<>();
        testArr.add(1);
        testArr.add(3);
        testArr.add(5);

        sut = new InsertPosUtils<>();
    }
    private void testResult(int expected, int target) {
        int result = getResult(target);

        assertEquals(expected, result);
    }

    private void testCheck(boolean expected, int target, int index) {
        boolean result = sut.isAMatch(index, testArr, target);

        assertEquals(expected, result);
    }

    private int getResult(int target) throws RuntimeException {
        for (int i = 0; i < testArr.size(); i ++) {
            if (sut.isAMatch(i, testArr, target)) {
                return sut.getReturnValue(i, testArr, target);
            }
        }
        throw new RuntimeException();
    }

    @Test
    void resultWorksForElementBeforeList() throws RuntimeException {
            testResult(0, 0);
    }

    @Test
    void resultWorksForElementInMiddleOfList() {
        testResult(1, 3);
    }

    @Test
    void resultWorksForElementAfterList() {
        testResult(3, 6);
    }

    @Test
    void resultWorksForElementNotInListButInRange() {
        testResult(2, 4);
    }

    @Test
    void checkWorksForElementBeforeList() throws RuntimeException {
        testCheck(true, 0, 0);
    }

    @Test
    void checkWorksForElementInMiddleOfList() {
        testCheck(true,3, 1);
    }

    @Test
    void checkWorksForElementAfterList() {
        testCheck(true,6, 2);
    }

    @Test
    void checkWorksForElementNotInListButInRange() {
        testCheck(true,4, 2);
    }

    @Test
    void checkFailsIfIndexAboveMatch() {
        testCheck(false, 3, 2);
    }

    @Test
    void checkFailsOnBad() {
        testCheck(false, 15, 0);
    }
}