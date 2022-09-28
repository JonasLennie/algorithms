class Solution:
    def __init__(self) -> None:
        self.nums = []
        self.target = 0

    def setup(self, nums: [int], target: int) -> None:
        self.nums = nums
        self.target = target

    def searchInsert(self, nums: [int], target: int) -> int:
        self.setup(nums, target)

        return self.bin_search(0, len(nums) - 1)

    def bin_search(self, lo: int, hi: int) -> int:
        mid = self.get_mid(lo, hi)

        return self.do_search(lo, mid, hi)

    def do_search(self, lo: int, mid: int, hi: int) -> int:
        if self.nums[lo] > self.target:
            return lo
        return self.search_not_too_low(hi, lo, mid)

    def search_not_too_low(self, hi, lo, mid):
        if self.is_match(mid):
            return mid
        else:
            return self.check_for_surrounding_matches(lo, mid, hi)

    def check_for_surrounding_matches(self, lo: int, mid: int, hi: int) -> int:
        if self.should_insert_above_mid(mid):
            return mid + 1
        else:
            return self.do_recursive(lo, mid, hi)

    def do_recursive(self, lo: int, mid: int, hi: int) -> int:
        if self.should_search_upper(mid):
            return self.search_above(hi, mid)
        else:
            return self.search_below(lo, mid)

    def search_below(self, lo: int, mid: int) -> int:
        return self.bin_search(lo, mid - 1)

    def search_above(self, hi: int, mid: int) -> int:
        return self.bin_search(mid + 1, hi)

    def is_match(self, mid: int) -> bool:
        return self.nums[mid] == self.target

    def should_insert_above_mid(self, mid: int) -> bool:
        mid_too_small = self.nums[mid] < self.target
        next_too_large = mid + 1 == len(self.nums) or self.nums[mid + 1] > self.target
        return mid_too_small and next_too_large

    def should_search_upper(self, mid: int) -> bool:
        return self.nums[mid] < self.target

    @staticmethod
    def get_mid(lo: int, hi: int) -> int:
        mid = (lo + hi) // 2
        return mid


def main():
    sut = Solution()
    result = sut.searchInsert([1, 3, 5, 6], 0)
    print(result)


if __name__ == '__main__':
    main()
