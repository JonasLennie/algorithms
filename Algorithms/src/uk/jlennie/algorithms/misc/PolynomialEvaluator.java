package uk.jlennie.algorithms.misc;

import java.util.*;

public class PolynomialEvaluator {
    double evaluate(List<Integer> coefficients, double x) {
        if (coefficients.size() < 1)
            return 0.0;

        int firstCoefficient = coefficients.get(0);
        int power = coefficients.size() - 1;

        double value = firstCoefficient * Math.pow(x, power);

        List<Integer> tail = coefficients.subList(1, coefficients.size());
        return value + evaluate(tail, x);
    }
}
