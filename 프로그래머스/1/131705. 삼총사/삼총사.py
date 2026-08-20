from itertools import combinations
def solution(number):
    answer = 0
    cases = list(combinations(number, 3))
    
    for one, two, three in cases:
        total = one + two + three
        if total == 0:
            answer += 1
    return answer