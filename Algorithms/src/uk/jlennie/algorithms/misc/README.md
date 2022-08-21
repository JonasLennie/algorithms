# A collection of miscellaneous algorithms

1. [Binary Addition](#binary-addition)
2. [TwoElementSum](#twoelementsum)

## Binary addition
Interface:
> `public List<Integer> add(ArrayList<Integer> a, ArrayList<Integer> b)`

Takes two lists of integers. Expected to represent two binary numbers.
Performs addition on these two binary numbers.

e.g.
>` new BinaryAddition().add(
 new ArrayList<>(Arrays.asList(1, 0, 1, 1, 0)
  , new ArrayList<>(Arrays.asList(1, 1, 0, 0)))) ` <br />
> ==> [1, 0, 0, 0, 1, 0]

NOTE: Performs no validation on lists provided

---

## TwoElementSum

Interface:
> `public boolean doTwoElementsSum(List<Integer> listToSearch, Integer target)`

Searches a List of integers against a target, and if any two values in that
list sum to the target, then it returns `true`

> `List<Integer> l = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5);`<br />
> `new TwoElementSum().doTwoElementSum(l, 3);` 
> <br />==> true
> <br /><br />
> `new TwoElementSum().doTwoElementSum(l, 1);`
> <br />==> false