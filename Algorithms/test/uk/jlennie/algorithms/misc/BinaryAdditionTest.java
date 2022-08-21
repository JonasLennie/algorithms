package uk.jlennie.algorithms.misc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryAdditionTest {

    @Test
    void basicAddition() {
        ArrayList<Integer> three = new ArrayList<>();
        three.add(1);
        three.add(1);

        ArrayList<Integer> seven = new ArrayList<>();
        seven.add(1);
        seven.add(1);
        seven.add(1);

        ArrayList<Integer> ten = new ArrayList<>();
        ten.add(1);
        ten.add(0);
        ten.add(1);
        ten.add(0);

        BinaryAddition adder = new BinaryAddition();

        List<Integer> result = adder.add(three, seven);

        assertArrayEquals(result.toArray(), ten.toArray());
    }

}