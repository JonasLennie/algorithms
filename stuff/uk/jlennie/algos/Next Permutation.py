import sys


class Solution:
    def __init__(self):
        self.nums = []
        self.i = 0

    def nextPermutation(self, nums: [int]) -> None:
        self.nums = nums

        for self.i in range(len(self.nums) - 2, -2, -1):
            if self.should_stop_at_i():
                self.get_next_order()
                return

    def should_stop_at_i(self):
        for v in sorted(self.nums[self.i + 1:]):
            if self.nums[self.i] < v:
                return True
        return False

    def get_next_order(self):
        self.swap(self.i, self.get_min_index())
        self.minimise(self.i + 1)

    def swap(self, i: int, j: int) -> None:
        if i >= 0 and j < len(self.nums):
            self.safe_swap(i, j)

    def safe_swap(self, i, j):
        tmp = self.nums[i]
        self.nums[i] = self.nums[j]
        self.nums[j] = tmp

    def minimise(self, i: int) -> None:
        sorted_sub_list = sorted(self.nums[i:])
        for j in range(i, len(self.nums)):
            self.nums[j] = sorted_sub_list[j - i]

    def get_min_index(self):
        min_val = sys.maxsize
        min_index = -1

        for (j, v) in enumerate(self.nums[self.i + 1:]):
            if self.nums[self.i] < v < min_val:
                min_val = v
                min_index = j + self.i + 1

        return min_index
