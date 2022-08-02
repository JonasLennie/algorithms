package uk.jlennie.misc;

import java.util.ArrayList;
import java.util.List;

public class binaryAddition {
    int minLength;
    int maxLength;
    int carry;
    List<Integer> result;

    public List<Integer> add(ArrayList<Integer> a, ArrayList<Integer> b) {
        init(a, b);

        processNumbersToEqualLength(a, b);

        processLongerNumber(a, b);

        setMSB();

        return result;
    }

    private void setMSB() {
        result.set(0, (carry == 1? 1 : 0));
    }

    void init(List<Integer> a, List<Integer> b) {
        minLength = Math.min(a.size(), b.size());
        maxLength = Math.max(a.size(), b.size());
        setResult();
        carry = 0;
    }

    private void setResult() {
        result = new ArrayList<>();
        for (int i = 0; i < maxLength + 1; i ++)
            result.add(i, 0);
    }

    void processNumbersToEqualLength(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < minLength; i ++) {
            int sum = carry + getFromBack(a, i) + getFromBack(b, i);
            setNextBit(i, sum);

            setCarry(sum);
        }
    }

    private void setNextBit(int i, int sum) {
        result.set(maxLength - i, (sum % 2 == 1 ? 1 : 0));
    }

    private void setCarry(int sum) {
        carry = sum > 1 ? 1 : 0;
    }

    void processLongerNumber(List<Integer>a, List<Integer>b) {
        if (a.size() > b.size())
            processLongerNumberWithArray(a);
        else
            processLongerNumberWithArray(b);
    }

    void processLongerNumberWithArray(List<Integer> longer) {
        for (int i = minLength; i < maxLength; i ++){
            int sum = carry + getFromBack(longer, i);

            setNextBit(i, sum);

            setCarry(sum);
        }
    }

    private Integer getFromBack(List<Integer> longer, int i) {
        return longer.get(longer.size() - i - 1);
    }
}
