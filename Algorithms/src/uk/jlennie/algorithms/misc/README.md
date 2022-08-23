# A collection of miscellaneous algorithms

1. [Binary Addition](#binary-addition)
2. [TwoElementSum](#twoelementsum)
3. [Polynomial Evaluator](#polynomial-evaluator)
4. [Inversion Finder](#inversion-finder)

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

## Polynomial Evaluator

Given a list, representing coefficients, and a value, representing x,
evaluates the polynomial represented by these coefficents and that x-value.

Interface:
> `double evaluate(List<Integer> coefficents, double x);`

Example:

> `new PolynomialEvaluator.evaluate(new ArrayList<>(Arrays.asList(3, 2, 1)), 4.0);`\
> ==> f(x) = 3x^2 + 2x + 1\
> ==> f(4.0) = 57

## Inversion Finder

Given a list of integers, counts the number of pairs of (i, j) such that
A[i] > A[j] && i < j.

Uses Polymorphism to find inversions in any comparable types.

Interface

> `int countInversions(List<Comprable<T>> l);`

Example:

> `new InversionFinder.find(Arrays.AsList(2, 1, 4, 3)`\
> ==> 2 (pairs (0, 1) and (2, 3))
