import itertools

def solution(k, m, score):
    score.sort(reverse = True)
    answer = 0
    boxlen = m
    idx = 0
    while idx < len(score):
        onebox = score[idx:idx+m]
        if len(onebox) != m:
            break
        minn = min(onebox)
        answer += minn * len(onebox)
        idx += m
    return answer