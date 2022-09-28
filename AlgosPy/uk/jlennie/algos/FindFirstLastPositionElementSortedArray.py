class Solution:
    def __init__(self):
        self.nums = []
        self.target = 0

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        self.setup(nums, target)

        idx_of_match = self.bin_search(0, len(nums) - 1)

        return self.find_range(idx_of_match)

    def setup(self, nums, target):
        self.nums = nums
        self.target = target

    def bin_search(self, lo, hi) -> int:
        if lo > hi:
            return -1

        return self.bin_search_safe_range(hi, lo)

    def bin_search_safe_range(self, hi, lo):
        mid = (lo + hi) // 2
        return self.bin_search_mid(hi, lo, mid)

    def bin_search_mid(self, hi, lo, mid):
        if self.mid_is_match(mid):
            return mid
        else:
            return self.do_recursive_step(lo, mid, hi)

    def mid_is_match(self, mid):
        return self.nums[mid] == self.target

    def do_recursive_step(self, lo: int, mid: int, hi: int) -> int:
        if self.target_can_be_found_above_mid(mid):
            return self.search_above_mid(hi, mid)
        else:
            return self.search_below_mid(lo, mid)

    def search_below_mid(self, lo, mid):
        return self.bin_search(lo, mid - 1)

    def search_above_mid(self, hi, mid):
        return self.bin_search(mid + 1, hi)

    def target_can_be_found_above_mid(self, mid):
        return self.nums[mid] < self.target

    def find_range(self, i_of_target):
        if self.is_not_in_list(i_of_target):
            return [-1, -1]
        else:
            return self.find_range_is_in_list(i_of_target)

    def is_not_in_list(self, i_of_target):
        return i_of_target == -1

    def find_range_is_in_list(self, i_of_target):
        lo = self.check_below(i_of_target)

        hi = self.check_above(i_of_target)

        return [lo, hi]

    def check_above(self, hi):
        while hi + 1 < len(self.nums) and self.nums[hi + 1] == self.target:
            hi += 1
        return hi

    def check_below(self, lo):
        while lo > 0 and self.nums[lo - 1] == self.target:
            lo -= 1
        return lo
