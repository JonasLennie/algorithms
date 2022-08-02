package uk.jlennie.sorts;

import java.util.ArrayList;
import java.util.List;

public class Merge implements Sort {
    List<Integer> arrayBeingSorted;

    @Override
    public List<Integer> getSortedCopy(List<Integer> arrayToSort) {
        arrayBeingSorted = new ArrayList<>(arrayToSort);

        mergeSort(0, arrayBeingSorted.size() - 1);

        return arrayBeingSorted;
    }

    private void mergeSort(int loIndex, int hiIndex) {
        if (boundsAreLargeEnough(loIndex, hiIndex))
            sortLargeBounds(loIndex, hiIndex);
    }

    private boolean boundsAreLargeEnough(int loIndex, int hiIndex) {
        return !(loIndex >= hiIndex);
    }

    private void sortLargeBounds(int loIndex, int hiIndex) {
        int mid = getMid(loIndex, hiIndex);

        mergeSort(loIndex, mid);

        mergeSort(mid + 1, hiIndex);

        MergeFunc m = new MergeFunc();
        m.merge(loIndex, mid, hiIndex);
    }

    class MergeFunc {
        int leftCounter;
        int rightCounter;
        int arrayCounter;

        int leftLimit;
        int rightLimit;

        List<Integer> left;
        List<Integer> right;

        private void merge(int loIndex, int mid, int hiIndex) {
            setup(loIndex, mid, hiIndex);

            while (bothListsStillHaveElements())
                addNextElementConsideringBothLists();

            insertRemainingList(left, leftCounter, leftLimit);

            insertRemainingList(right, rightCounter, rightLimit);
        }

        private void insertRemainingList(List<Integer> list, int counter, int limit) {
            while (counter <= limit) {
                arrayBeingSorted.set(arrayCounter ++, list.get(counter ++));
            }
        }

        private void addNextElementConsideringBothLists() {
            if (isNextLeftSmallerThanNextRight())
                insertNextElementFromList(left, leftCounter ++);
            else
                insertNextElementFromList(right, rightCounter ++);
            arrayCounter ++;
        }

        private boolean bothListsStillHaveElements() {
            return leftCounter <= leftLimit
                    && rightCounter <= rightLimit;
        }

        private boolean isNextLeftSmallerThanNextRight() {
            return left.get(leftCounter) < right.get(rightCounter);
        }

        private void insertNextElementFromList(List<Integer> src, int index) {
            arrayBeingSorted.set(arrayCounter, src.get(index));
        }

        private void setup(int loIndex, int mid, int hiIndex) {
            left = new ArrayList<>(arrayBeingSorted.subList(loIndex, mid + 1));
            right = new ArrayList<>(arrayBeingSorted.subList(mid + 1, hiIndex + 1));

            leftCounter = 0;
            rightCounter = 0;
            arrayCounter = loIndex;

            leftLimit = mid - loIndex;
            rightLimit= hiIndex - mid - 1;
        }
    }


    private int getMid(int loIndex, int hiIndex) {
        return (loIndex + hiIndex) / 2;
    }
}
