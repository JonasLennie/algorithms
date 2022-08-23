package uk.jlennie.algorithms.misc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialEvaluatorTest {
    PolynomialEvaluator sut;

    void makeAssertion(double expected, double x_value, int ... coefficients) {
        sut = new PolynomialEvaluator();

        assertEquals(expected, sut.evaluate(Arrays.stream(coefficients).boxed().toList(), x_value), 0.001);
    }

    @Test
    void testingNoCoefficentsZeroX() {
        makeAssertion(0.0, 0.0);
    }

    @Test
    void testingNoCoefficentsNonZeroX() {
        makeAssertion(0.0, 14);
    }

    @Test
    void simpleConstantTwoValuesOfXEqual() {
        makeAssertion(14, 3.0, 14);
        makeAssertion(14, 12, 14);
    }

    @Test
    void simpleXValuePlusOne() {
        makeAssertion(15, 14, 1, 1);
    }

    @Test
    void lastPositionZeroNoUnusualBehavior() {
        makeAssertion(14, 14, 1, 0);
    }

    @Test
    void onlyZerosIsFineAndXIndependent() {
        makeAssertion(0, 12, 0, 0);
        makeAssertion(0, 6, 0, 0);
    }

    @Test
    void frontZeroGivesExpectedResult() {
        makeAssertion(12, 7, 0, 12);
    }

    @Test
    void frontZeroMoreCoefficents() {
        makeAssertion(7, 7, 0, 0, 1, 0);
    }

    @Test
    void negativeCoefficients() {
        makeAssertion(-7, 7, -1, 0);
    }

    @Test
    void negativeXValue() {
        makeAssertion(-7, -7, 1, 0);
    }

    @Test
    void negativeXAndNegativeCoeff() {
        makeAssertion(7, -7, -1, 0);
    }

    @Test
    void floatingPointXValue() {
        makeAssertion(6.5, 6.5, 1, 0);
    }

    @Test
    void simpleMultiple() {
        makeAssertion(21, 7, 3, 0);
    }

    @Test
    void largerPolynomial() {
        // f(x) = 3x^3 + 2x + 5; f(3) = 92

        makeAssertion(92, 3, 3, 0, 2, 5);
    }

}