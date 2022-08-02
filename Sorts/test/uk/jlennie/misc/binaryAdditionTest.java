package uk.jlennie.misc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class binaryAdditionTest {

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

        binaryAddition adder = new binaryAddition();

        List<Integer> result = adder.add(three, seven);

        assertArrayEquals(result.toArray(), ten.toArray());
    }

}