# Divide And Conquer

1. [Max Sub Array Problem](#max-sub-array)
2. [Matrix Multiplication problem](#matrix-multiplication)

## Max Sub Array

The aim of the problem is to find the sub-array of a given array with a maximal sum.

The `SubArrayData` class gives a representation of a sub-array.

`MaxSubArray` interface defines the interface for a solution to this problem.

The solution to this problem is implemented in two ways;
1. [Brute Force](#brute-force)
2. [Divide and Conquer](#divide-and-conquer)

### Brute Force

The brute force method simply takes all possible start and end points of a sub-array
and tracks which one produces the maximum sum.\
This has O(N^2)

### Divide And Conquer

The divide and conquer method is somewhat more complex.\
It divides an array in half, and recursively finds the maximum sub array of each half.
Naturally, the base case is a sub-array of length one, whose maximum sum is the single 
value in the array.

Then, the maximum sum found by examining sub-arrays which cross the middle of the array is recorded.
The maximum of the whole array is then the maximum of the left half, the right half
and the maximum sub-array at the intersection.

> `[1, 2, 3, 4]` splits into `[1, 2]` and `[3, 4]`.\
> The maximum of `[1, 2]` and `[3, 4]` are found.\
> Then a maximum containing elements `[2, 3]` is found.

## Matrix Multiplication

All matrices used here are assumed to be square matrices for the purposes of simplicity.

The `Matrix` interface defines a square matrix interface, involving getting, setting and
the size of the square matrix.

`BasicMatrix` is a simple implementation of the `Matrix` interface.

`SubMatrix` allows a second square matrix to be created from the first square matrix.
Note, this implementation creates new sub-matrices in constant time, as it does not
clone the original, only constrain access, and shift indexes.\
This also implements the `Matrix` interface.

`MatrixQuarters` is a utility function that is able to take quarters of an existing matrix.
It then returns `SubMatrix` objects of the original.

`BasicMatrixMultiply` multiplies matrices in the basic way, by running through for loops
iteratively, in O(n^3).

`DivideMatrixMultiply` multiplies matrices by first multiplying quarters. This is
also O(n^3).

`StrassenMatrixMultiply` multiplies matrices by using Srassen's algorithms, which is
not outlined here. It does so in O(n^lg(7)). This is asymptotically better than other
solutions.
