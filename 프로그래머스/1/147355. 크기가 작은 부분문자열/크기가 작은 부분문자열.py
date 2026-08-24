def solution(t, p):
    answer = 0
    strlen = len(p)
    endIdx = len(t) - len(p)
    idx = 0
    
    while idx <= endIdx:
        sub = t[idx:idx + strlen]
        if int(p) >= int(sub):
            answer += 1
        idx += 1
    return answer