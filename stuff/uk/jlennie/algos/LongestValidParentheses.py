class Solution:
    def __init__(self):
        self.s = ''
        self.valid_substrings = []

    def longestValidParentheses(self, s: str) -> int:
        self.s = s

        # Get positions of strings that look like '()'; these must be the innermost parentheses of any larger ones
        self.valid_substrings = self.get_innermost()

        # Optimise the set of innermost parentheses to capture surrounding and valid parentheses
        self.optimise()

        # Better to use dynamic programming

        max_size = self.get_max()

        return max_size

    def get_innermost(self) -> [(int, int)]:
        i = 0
        innermost = []

        while i < len(self.s) - 1:
            if self.s[i] == '(' and self.s[i + 1] == ')':
                innermost.append((i, i + 1))
                i += 2
            else:
                i += 1

        return innermost

    def optimise(self) -> [(int, int)]:
        did_swap = True

        while did_swap:
            self.check_for_outer()
            did_swap = self.merge_adjacent()

    def merge_adjacent(self) -> bool:
        new_size = len(self.valid_substrings) - 1
        i = 0
        did_swap = False

        while i < new_size:
            if self.end_first_is_start_next(i):
                new_size -= 1
                self.merge_i_and_next(i)
                did_swap = True
            else:
                i += 1

        return did_swap

    def merge_i_and_next(self, i: int) -> None:
        self.valid_substrings[i + 1] = (self.valid_substrings[i][0], self.valid_substrings[i + 1][1])
        self.valid_substrings.pop(i)

    def end_first_is_start_next(self, i: int) -> bool:
        return self.valid_substrings[i][1] + 1 == self.valid_substrings[i + 1][0]

    def check_for_outer(self) -> None:
        for (i, (start, end)) in enumerate(self.valid_substrings):
            k = 1
            while len(self.s) > end + k and start - k >= 0 and self.s[start - k] == '(' and self.s[end + k] == ')':
                k += 1
            if k > 1:
                k -= 1
                self.valid_substrings[i] = (start - k, end + k)

    def get_max(self) -> int:
        max_diff = 0
        for (start, end) in self.valid_substrings:
            if end - start + 1 > max_diff:
                max_diff = end - start + 1

        return max_diff
