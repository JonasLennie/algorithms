package uk.jlennie.misc;

import java.util.*;

public class foo {
    int[] nums;
    Set<List<Integer>> triples;
    Index valueToIndexes;

    public foo() {
        triples = new HashSet<>();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        this.nums = nums;

        valueToIndexes = new Index(nums);

        setTwoAndFindThirdIndex();

        return new ArrayList<>(triples);
    }

    private void setTwoAndFindThirdIndex() {
        for (int i = 0; i < nums.length; i ++)
            for (int j = i + 1; j < nums.length; j ++)
                findPossibleThirdIndex(i, j);
    }

    private void findPossibleThirdIndex(int i, int j) {
        Optional<List<Integer>> possibleThirdIndex = valueToIndexes.query(i, j);

        if (possibleThirdIndex.isEmpty())
            return;

        addAnyPossibleResults(possibleThirdIndex.get(), i, j);
    }

    private void addAnyPossibleResults(List<Integer> matchingIndecies, int i, int j) {
        for (Integer index : matchingIndecies)
            addNewTripleIfDistinct(i, j, index);
    }

    private void addNewTripleIfDistinct(int i, int j, Integer index) {
        if (indicesAreDistinct(i, j, index)) {
            addAllValuesToTriple(i, j, index);
        }
    }

    private void addAllValuesToTriple(int i, int j, Integer index) {
        List<Integer> listToAdd = getListOfValues(i, j, index);

        triples.add(listToAdd);
    }

    private List<Integer> getListOfValues(int i, int j, Integer index) {
        List<Integer> listToAdd = Arrays.asList(nums[i], nums[j], nums[index]);
        Collections.sort(listToAdd);
        return listToAdd;
    }

    private boolean indicesAreDistinct(int i, int j, Integer index) {
        return index > i && index > j;
    }

    class Index {
        private int i;
        Map<Integer, List<Integer>> valueToIndexes;
        int[] nums;

        public Index(int[] nums) {
            this.nums = nums;
            valueToIndexes = new HashMap<>();
            populateIndex();

            i = 0;
        }

        public Optional<List<Integer>> query(int i, int j) {
            int remainder = -1 * (nums[i] + nums[j]);

            if (valueToIndexes.containsKey(remainder))
                return Optional.of(valueToIndexes.get(remainder));
            else
                return Optional.empty();
        }

        private void populateIndex() {
            for (int num : nums)
                addNumToIndex(num);
        }

        private void addNumToIndex(int num) {
            if (numExistsInHashMap(num))
                valueToIndexes.get(num).add(i ++);
            else
                CreateNewEntryInHashMap(num);
        }

        private void CreateNewEntryInHashMap(int num) {
            List<Integer> listToAdd = new ArrayList<>();
            listToAdd.add(i ++);

            valueToIndexes.put(num, listToAdd);
        }

        private boolean numExistsInHashMap(int num) {
            return valueToIndexes.containsKey(num);
        }
    }


}

