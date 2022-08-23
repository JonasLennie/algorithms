# Sorting Algorithms

1. [The Interface](#the-interface)
2. [Insertion Sort](#insertion-sort)
3. [Merge Sort](#merge-sort)
4. [Hybrid Sort](#hybrid-sort)
5. [Bubble Sort](#bubble-sort)

## The Interface

All sorts implement the `Sort` interface, outlined below.

> `List<Integer> getSortedCopy(List<Integer> arrayToSort);`

Note that this returns a sorted copy, and does not mutate the original array.
This was just done as it varies a bit from what is usually done by Java.
Yes, it does introduce a performance penalty, but oh well. (It'll add at most
O(N), but searches are bounded by O(NlogN) anyway; let's just ignore memory
costs).

## Insertion Sort

There are four separate implementations of InsertionSort included.
1. [Insertion](#insertion)
2. [Fast Insertion](#fast-insertion)
3. [Recursive Insertion](#recursive-insertion)
4. [Reverse Insertion](#reverse-insertion)

### Insertion

A default insertion sort implementation.
Note that other versions of insertion sort will subclass this and override
methods where appropriate, so that every implementation need not start from scratch.

### Fast insertion

A variation of insertion sort which uses BinarySearch to determine where to
insert an element in the sorted portion of a list. This insertion runs N times, 
and the binary search takes LogN operations, so this has a complexity of O(NlogN).

### Recursive Insertion

Alternative implementation of recursive sort. End behaviour ultimately the same.

Takes a full list, extracts the last element, sorts all preceding elements
recursively and then finally inserts last element into sorted list.

### Reverse Insertion

Reverses criteria of sort to get a reversed list.

Subclassing the `Insertion` class makes this implementation very small.

## Merge Sort

Not much to say here, just a bog standard implementation of merge sort.
(With a slightly ugly merge method).

## Hybrid Sort

This is a combination of Merge Sort and Insertion sort. Since insertion 
sort has lower constant factors than merge sort, it can often be faster
use this for shorter lists.

As such, the approach is to use merge sort, until the sublist is of some
length k or less, and at that point, the remaining sublist is sorted with
insertion sort.

## Bubble Sort

Bog standard bubble sort, it's O(n^2), and rarely practical.
