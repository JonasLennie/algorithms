package uk.jlennie.sorts;

public class ReverseInsertion extends Insertion implements Sort {
    @Override
    protected boolean currentIndexIsSmallerThanBefore(int index) {
        // Should be currentIndexIsLargerThanBefore

        if (index <= 0)
            return false;

        return listToSort.get(index) > listToSort.get(index - 1);
    }
}
