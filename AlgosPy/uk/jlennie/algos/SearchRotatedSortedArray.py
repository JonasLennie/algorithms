# Search through array which has potentially been rotated
# [0, 1, 2] has not been rotated, [2, 0, 1] has been rotated by 2

# Approach:
# 1. Find rotate index
# 2. Perform binary search, but offset all indexes by rotate index

class Solution:
    def __init__(self):
        self.nums = []
        self.target = 0
        self.offset = 0

    def search(self, nums: [int], target: int) -> int:
        self.setup(nums, target)

        return self.bin_search(0, len(self.nums) - 1)

    def setup(self, nums: [int], target: int):
        self.nums = nums
        self.target = target
        self.offset = self.find_offset(0, len(self.nums) - 1)

    def find_offset(self, lo: int, hi: int) -> int:
        if self.is_split_in_range(lo, hi):
            return self.find_split_in_range(lo, hi)
        else:
            return 0

    def is_split_in_range(self, lo, hi):
        for i in range(lo, hi):
            if self.nums[i] < self.nums[hi]:
                return False
            elif self.nums[i] > self.nums[hi]:
                return True

        return True

    def find_split_in_range(self, lo, hi):
        if self.is_split_at_lo(lo, hi):
            return lo
        else:
            return self.get_split_in_large_range(hi, lo)

    def get_split_in_large_range(self, hi, lo):
        mid = self.get_mid(hi, lo)
        split = self.get_split_with_mid(hi, lo, mid)
        return split

    def get_split_with_mid(self, hi, lo, mid):
        lo_split = self.find_offset(lo, mid)
        hi_split = self.find_offset(mid, hi)
        return max(lo_split, hi_split)

    def get_mid(self, hi, lo):
        return (lo + hi) // 2

    def is_split_at_lo(self, lo: int, hi: int) -> bool:
        return lo + 1 == hi

    def bin_search(self, lo, hi):
        mid = self.get_mid(hi, lo)
        if self.nums[self.idx(mid)] == self.target:
            return self.idx(mid)
        elif self.nums[self.idx(mid)] < self.target:
            return self.bin_search(mid + 1, hi)
        else:
            return self.bin_search(lo, mid - 1)

    def idx(self, i):
        return (i + self.offset) % len(self.nums)


def main():
    sut = Solution()
    result = sut.search([4,5,6,7,0,1,2], 4)
    print(result)


if __name__ == '__main__':
    main()
