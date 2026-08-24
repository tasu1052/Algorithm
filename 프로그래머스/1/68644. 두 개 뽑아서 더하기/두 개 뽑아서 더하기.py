from itertools import combinations
def solution(numbers):
    tmp = set()
    com = list(combinations(numbers, 2))
    for a, b in com:
        tmp.add(a + b)
    return sorted(tmp)