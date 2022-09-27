from collections import Counter


class Solution:
    def __init__(self):
        self.i = 0
        self.word_len = 0
        self.s = ''
        self.words_set = {}
        self.words = []
        self.offset = 0

    def findSubstring(self, s: str, words: [str]) -> [int]:
        self.setup(s, words)
        starts = []

        for self.offset in range(self.word_len):
            self.i = self.offset
            while self.i_in_bounds():
                starts += self.check_for_words()

        return starts

    def setup(self, s, words) -> None:
        self.s = s
        self.words_set = set(words)
        self.word_len = len(words[0])
        self.words = words
        self.i = 0

    def check_for_words(self) -> [str]:
        starting_i = self.i
        ls = self.get_consecutive_words()
        self.increment_i_if_no_word(starting_i)
        return self.process(ls, starting_i)

    def get_consecutive_words(self) -> [str]:
        ls = []
        while self.i_in_bounds() and self.next_possible_word_is_word():
            ls.append(self.get_next_possible_word())
            self.i += self.word_len
        return ls

    def next_possible_word_is_word(self) -> bool:
        return self.get_next_possible_word() in self.words_set

    def get_next_possible_word(self) -> str:
        return self.s[self.i: self.i + self.word_len]

    def increment_i_if_no_word(self, starting_i) -> None:
        if self.i == starting_i:
            self.i += self.word_len

    def i_in_bounds(self) -> bool:
        return self.i <= len(self.s) - self.word_len

    def process(self, ls: [str], starting_i: int) -> [int]:
        starts = []
        k = len(self.words)

        for j in range(len(ls) - k + 1):
            if self.next_k_words_are_good(j, ls):
                starts.append(starting_i + j * self.word_len)

        return starts

    def next_k_words_are_good(self, j: int, ls: [str]) -> bool:
        next_words = self.get_next_k_words(j, ls)
        return Counter(next_words) - Counter(self.words) == Counter() and \
            Counter(self.words) - Counter(next_words) == Counter()

    def get_next_k_words(self, j: int, ls: [str]) -> [str]:
        words = ls[j: j + len(self.words)]
        return words
