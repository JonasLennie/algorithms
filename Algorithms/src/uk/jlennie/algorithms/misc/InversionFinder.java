package uk.jlennie.algorithms.misc;

import java.util.*;

public class InversionFinder<T extends Comparable<T>> {
    int numInversions;

    int countInversions(List<T> l) {
        numInversions = 0;

        for (int i = 0; i < l.size() - 1; i ++)
            for (int j = i + 1; j < l.size(); j++)
                if (l.get(i).compareTo(l.get(j)) > 0)
                    numInversions ++;


        return numInversions;
    }

}
