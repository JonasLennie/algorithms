package uk.jlennie.algorithms.divide_and_conquer.max_sub_arr;

import org.junit.jupiter.api.BeforeEach;

class MaxSubArrayBruteForceTest extends MaxSubArrayTest {

    @BeforeEach
    @Override
    void setup() {
        sut = new MaxSubArrayBruteForce();
    }
}